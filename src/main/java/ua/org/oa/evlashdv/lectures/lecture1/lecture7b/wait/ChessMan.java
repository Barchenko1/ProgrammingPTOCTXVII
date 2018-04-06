package ua.org.oa.evlashdv.lectures.lecture1.lecture7b.wait;

public class ChessMan extends Thread {
    private String manName;
    private Clock clock;
    private Color color;

    public ChessMan(String manName, Clock clock, Color color) {
        this.manName = manName;
        this.clock = clock;
        this.color = color;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            move();
        }
    }
    public void move(){
        synchronized (clock){
        if (clock.getState()!=color){
            System.out.println(manName+" move with "+color);
            clock.setState(color);
            try {
                clock.notifyAll();
                clock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            try {
                clock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
}
