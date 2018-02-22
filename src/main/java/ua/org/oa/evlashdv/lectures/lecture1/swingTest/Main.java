package ua.org.oa.evlashdv.lectures.lecture1.swingTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class Main {


    private static JTextField text1Field = new JTextField(10);
    private static JTextField text2Field = new JTextField(10);

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Авторизация в системе:");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        //Размещение компонент

        JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");

        JButton loginButton = new JButton("Login in");
        JButton registrationButton = new JButton("Registration");

        JTextField text1Field = new JTextField(10);
        JTextField text2Field = new JTextField(10);

        JButton myButton = new JButton();

        loginButton.addActionListener(new MyButtonActionListener());


        frame.add(loginLabel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        frame.add(text1Field, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        frame.add(passwordLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        frame.add(text2Field, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        frame.add(loginButton, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        frame.add(registrationButton, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));


        frame.setVisible(true);
        frame.pack();
    }
    static class MyButtonActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String str1=text1Field.getText();
            String str2=text2Field.getText();

            text1Field.setText(str2);
            text2Field.setText(str1);
        }
    }
//        JPanel panelCenter =new JPanel(new GridLayout(3,3));
//        JPanel panelNorth =new JPanel(new BorderLayout());
//
//        JButton b1=new JButton("b1");
//        JButton b2=new JButton("b2");
//        JButton b3=new JButton("b3");
//        JButton b4=new JButton("b4");
//        JButton b5=new JButton("b5");
//        JButton b6=new JButton("b6");
//        JButton b7=new JButton("b7");
//        JButton b8=new JButton("b8");
//        JButton b9=new JButton("b9");
//        JButton b0=new JButton("b0");
//
//        JTextField textField=new JTextField(10);
//
//
//        panelCenter.add(b1);
//        panelCenter.add(b2);
//        panelCenter.add(b3);
//        panelCenter.add(b4);
//        panelCenter.add(b5);
//        panelCenter.add(b6);
//        panelCenter.add(b7);
//        panelCenter.add(b8);
//        panelCenter.add(b9);
//        panelCenter.add(b0);
//
//        panelNorth.add(textField,BorderLayout.CENTER);
//
//        frame.add(panelCenter,BorderLayout.CENTER);
//        frame.add(panelNorth,BorderLayout.NORTH);



//        JPanel panel =new JPanel(new FlowLayout());
//
//        panel.setPreferredSize(new Dimension(600,100));
//
//        panel.setBackground(Color.GREEN);
//
//        JButton button=new JButton("the button 1");
//        JTextField textField=new JTextField(10);
//
//        JButton button1=new JButton("the button 2");
//        JButton button2=new JButton("the button 3");
//        JButton button3=new JButton("the button 4");
//        JButton button4=new JButton("the button 5");
//
//        panel.add(button);
//        panel.add(textField);
//        panel.add(button1);
//        panel.add(button2);
//        panel.add(button3);
//        panel.add(button4);
//        frame.add(panel, BorderLayout.SOUTH);
//


//        JPanel panel1=new JPanel();
//        JPanel panel2=new JPanel();
//        JPanel panel3=new JPanel();
//        JPanel panel4=new JPanel();
//        JPanel panel5=new JPanel();
//
//        panel5.setLayout(new BorderLayout());
//
//
//        panel1.setBackground(Color.yellow);
//        panel2.setBackground(Color.blue);
//        panel3.setBackground(Color.green);
//        panel4.setBackground(Color.red);
//        panel5.setBackground(Color.gray);
//
//        frame.add(panel1, BorderLayout.NORTH);
//        frame.add(panel2, BorderLayout.SOUTH);
//        frame.add(panel3, BorderLayout.WEST);
//        frame.add(panel4, BorderLayout.EAST);
//        frame.add(panel5, BorderLayout.CENTER);
//
//        panel5.add(button, BorderLayout.PAGE_START);


        //Панель

//        JPanel panel=new JPanel();
//        JPanel panel2=new JPanel();
//        JButton button=new JButton("the button");
//        JButton button2=new JButton("the button 2");
//        panel.setBackground(Color.yellow);
//        panel2.setBackground(Color.green);
//        panel2.add(button2);
//        panel.add(button);
//        panel.add(panel2);
//        frame.add(panel);
//
//        Component[]comp=panel.getComponents();
//        for (int i=0;i<comp.length;i++){
//            if (comp[i] instanceof JPanel) System.out.println("panel");
//            if (comp[i] instanceof JButton) {
//                String titleButton=((JButton) comp[i]).getText();
//                System.out.println(titleButton);
//            }
//        }



        //Процесс выполнения

//        JLabel label = new JLabel("Загрузка...");
//
//        JProgressBar progressBar=new JProgressBar();
//        progressBar.setStringPainted(true);
//        progressBar.setIndeterminate(true);
//        progressBar.setMinimum(0);
//        progressBar.setMaximum(100);
//
//
//        frame.add(progressBar);
//        frame.add(label);
//
//        for (int i=progressBar.getMinimum();i<=progressBar.getMaximum();i++){
//            Thread.sleep(100);
//            progressBar.setValue(i);
//        }
//        label.setText("Загружено");

        //Метка

//        JLabel label=new JLabel("Здесь выводится информация");
//        frame.add(label);
//        Font font =new Font("Verdana",Font.ITALIC,25);
//        label.setForeground(Color.BLUE);
//        label.setFont(font);
//        frame.setLayout(new GridBagLayout());
        //строка ввода
//        JTextField textField=new JTextField(30);
//        JButton button=new JButton("Кнопка");
//
//        textField.setBackground(Color.white);
//        textField.setText("123");
//        System.out.println(textField.getText());
//
//
//        frame.add(textField);
//        frame.add(button);
//


        //Кнопки
//        JButton myButton=new JButton();
//        JButton myButton2=new JButton("Моя первая кнопка");
//        myButton.setText("Моя первая кнопка");
//        myButton.setBackground(Color.yellow);
//        myButton.setForeground(Color.blue);
//        Color forColor=myButton.getForeground();
//        Color color=myButton.getBackground();
//        myButton2.setBackground(color);
//        myButton2.setForeground(forColor);
//        frame.add(myButton);
//        frame.add(myButton2);

//        Cursor cursor=new Cursor(Cursor.MOVE_CURSOR);
//        myButton.setCursor(cursor);






}
