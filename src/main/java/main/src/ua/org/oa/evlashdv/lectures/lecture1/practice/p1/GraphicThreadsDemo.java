package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicThreadsDemo extends JFrame {
    JPanel panel=new JPanel();
    Graphics g;
    JButton btn=new JButton("Добавить шарик");
    int i;

    public GraphicThreadsDemo()  {
        setBounds(100,200,270,350);
        Container containerPane=getContentPane();
        containerPane.setLayout(null);
        btn.setBounds(50,10,160,20);
        containerPane.add(btn);
        panel.setBounds(30,40,200,200);
        panel.setBackground(Color.WHITE);
        containerPane.add(panel);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BallThread(panel).start();
                i++;
                repaint();
            }
        });
    }

    public static void main(String[] args) {
        GraphicThreadsDemo frame=new GraphicThreadsDemo();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Количество шаров: "+i,65,300);
    }
}
class BallThread extends Thread{
    JPanel panel;
    private int posX, posY;
    private final int BALL_SIZE = 10;
    private double alpha;
    private int SPEED = 4;
    BallThread(JPanel p){
        this.panel=p;
        posX = (int)((panel.getWidth() - BALL_SIZE) * Math.random());
        posY = (int)((panel.getHeight() - BALL_SIZE) * Math.random());
        alpha = Math.random() * 10;
    }
        public void run() {
            while(true) {
                posX += (int)(SPEED * Math.cos(alpha));
                posY += (int)(SPEED * Math.sin(alpha));
                if( posX >= panel.getWidth() - BALL_SIZE )
                    alpha = alpha + Math.PI - 2 * alpha;
                else if( posX <= 0 )
                    alpha = Math.PI - alpha;
                if( posY >= panel.getHeight() - BALL_SIZE )
                    alpha = -alpha;
                else if( posY <= 0 )
                        alpha = -alpha;
                    paint(panel.getGraphics());
            }
        }
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
        g.setColor(Color.WHITE);
        g.drawArc(posX + 1, posY + 1, BALL_SIZE, BALL_SIZE, 120, 30);
        try {
            sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.setColor(panel.getBackground());
        g.fillArc(posX, posY, BALL_SIZE, BALL_SIZE, 0, 360);
    }
}
