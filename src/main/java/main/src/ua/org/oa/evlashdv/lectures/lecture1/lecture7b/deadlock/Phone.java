package ua.org.oa.evlashdv.lectures.lecture1.lecture7b.deadlock;

public class Phone {
    public synchronized void makeCall(Human from,Human to){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        to.getPhone().receiveCall(from);
    }
    public synchronized void receiveCall(Human human){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Incomming call from "+ human.getHumanName());
    }

    @Override
    public String toString() {
        return "Phone{}";
    }
}
