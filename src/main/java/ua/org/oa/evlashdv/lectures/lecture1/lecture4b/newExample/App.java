package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.newExample;

public class App {
    public static void main(String[] args) {
        Pair<String > pair1=new Pair<>("first","Vasya");

        Human<Integer ,Sex > human1=new Human<>("Vasya",25,Sex.MALE);
        //Human<String ,String> human2=new Human<>("Vasya","25","Male");
        //Human human3=new Human("Misha","mama","wer");
        human1.<String >print(new String []{"1","2","3"});
        Human<Double, Sex> human4=new Human<>("Sveta",35.0,Sex.FEMALE);
        System.out.println(human4.isOlder(human1));
    }
}
