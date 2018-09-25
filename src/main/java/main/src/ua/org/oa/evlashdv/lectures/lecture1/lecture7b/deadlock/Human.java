package ua.org.oa.evlashdv.lectures.lecture1.lecture7b.deadlock;

public class Human extends Thread {
    private String humanName;
    private Phone phone;
    private Human frined;

    public Human(String name, Phone phone, Human human) {
        this.humanName=name;
        this.phone=phone;
        this.frined=human;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Human getFrined() {
        return frined;
    }

    public void setFrined(Human frined) {
        this.frined = frined;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    @Override
    public void run(){
        callToFriend();
    }
    public void callToFriend(){
        phone.makeCall(this,frined);
    }

    @Override
    public String toString() {
        return "Human{" +
                "humanName='" + humanName + '\'' +
                ", phone=" + phone +
                ", frined=" + frined +
                '}';
    }
}
