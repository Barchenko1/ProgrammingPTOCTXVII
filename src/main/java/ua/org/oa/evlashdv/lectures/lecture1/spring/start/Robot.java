package ua.org.oa.evlashdv.lectures.lecture1.spring.start;

public class Robot {
    private Hand hand;
    private Head head;
    private Leg leg;

    public Robot(Hand hand, Head head, Leg leg) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }
    public void action(){
        head.calc();
        hand.catchSomething();
        leg.go();
    }
}
