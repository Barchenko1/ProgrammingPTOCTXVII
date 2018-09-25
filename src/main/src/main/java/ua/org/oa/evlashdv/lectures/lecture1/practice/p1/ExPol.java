package ua.org.oa.evlashdv.lectures.lecture1.practice.p1;
interface prof{
    int a=1;
    static void prof(){
        System.out.println("Привет инт");
    };
}
abstract class CPU{
    public abstract void process();
}
class Intel extends CPU{
    @Override
    public void process() {
        System.out.println("Intel");
    }
}
class Amd extends CPU{

    @Override
    public void process() {
        System.out.println("AMD");
    }
}
public class ExPol {
    public static void main(String[] args) {
        CPU intel=new Intel();
        CPU amd = new Amd();
        intel.process();
        amd.process();
        prof a=new prof() {};
        prof.prof();
    }
}
