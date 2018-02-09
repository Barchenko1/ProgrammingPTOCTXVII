package ua.org.oa.evlashdv.lectures.lecture1.lecture1b;

public class Shirt extends Clothing {

    public Shirt(String name, int price) {
        super(name, price);
    }

    @Override
    public void wash(){
        System.out.println("Shirt is clean");
    }
}
