package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.Shildt;
class Stats<T extends Number>{
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }
    double average(){
        double sum=0.0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i].doubleValue();
        }
        return sum/nums.length;
    }
    boolean sameAvg(Stats <?> ob){
        if (average()==ob.average()) return true;
        return false;
    }
}
public class BoundsDemo {
    public static void main(String[] args) {
        Integer inums[]={1,2,3,4,5};
        Stats<Integer>iOb=new Stats<>(inums);
        double v=iOb.average();
        System.out.println("Среднее значение iob равно "+v);
        Double dnums[]={1.1,2.2,3.3,4.4,5.5};
        Stats<Double>dob=new Stats<>(dnums);
        double w=dob.average();
        System.out.println("Среднее значение dob равно "+w);
//        String str[]={"1","2","3","4","5"};
//        Stats<String > strOb=new Stats<String>(str);
//        double x = strOb.average();
//        System.out.println(x);
        Float fnums[]={1.0F,2.0F,3.0F,4.0F,5.0F};
        Stats <Float> fob=new Stats<>(fnums);
        double x=fob.average();
        System.out.println("Среднее значение fob равно "+x);
        System.out.print("Среднее значение iob и dob ");
        if (iOb.sameAvg(dob)){
            System.out.println("Равны");
        }else System.out.println("Отличаются");
        System.out.print("Среднее значение iob и fob ");
        if (iOb.sameAvg(fob)){
            System.out.println("одинаковы");
        }else System.out.println("отличаются");

    }
}
