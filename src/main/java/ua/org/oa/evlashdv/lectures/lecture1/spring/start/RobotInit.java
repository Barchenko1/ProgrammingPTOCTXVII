package ua.org.oa.evlashdv.lectures.lecture1.spring.start;

public class RobotInit {
    public static void main(String[] args) {
        SonyHead sonyHead=new SonyHead();
        ToshibaLeg toshibaLeg=new ToshibaLeg();
        SonyHand sonyHand=new SonyHand();

        Robot robot=new Robot(sonyHand, sonyHead,toshibaLeg);
        robot.action();
    }

}
