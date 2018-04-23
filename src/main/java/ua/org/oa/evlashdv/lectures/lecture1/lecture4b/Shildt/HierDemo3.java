package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class GenT<T>{
    T ob;

    public GenT(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}
class GenT2<T>extends GenT<T>{
    public GenT2(T ob) {
        super(ob);
    }
}
public class HierDemo3 {
    public static void main(String[] args) {
        GenT<Integer> iob=new GenT<>(88);
        GenT2<Integer> iob2=new GenT2<>(99);
        GenT2<String> strob2=new GenT2<>("Тест обобщения");
        if (iob2 instanceof GenT2<?>){
            System.out.println("iob2 обьект класса GenT2");
        }
        if (iob2 instanceof GenT<?>){
            System.out.println("iob2 обьект класса GenT");
        }
        if (strob2 instanceof GenT2<?>){
            System.out.println("strob2 обьект класса GenT2");
        }
        if (strob2 instanceof GenT<?>){
            System.out.println("strob2 обьект класса GenT");
        }
        if (iob instanceof GenT2<?>){
            System.out.println("iob обьект класса GenT2");
        }
        if (iob instanceof GenT<?>){
            System.out.println("iob обьект класса GenT");
        }
//        if (iob2 instanceof GenT2<Integer>){
//            System.out.println("iob2 обьект класса GenT2");
//        }
    }
}
