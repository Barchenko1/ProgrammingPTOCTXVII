package ua.org.oa.evlashdv.lectures.lecture1.lecture1b;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class App {
   // public static List<String> stringList=new ArrayList<>;
	public static void main(String[] args) {
		Clothing clothing=new Shirt("Shirt",250);
		clothing.wash();
	  //  stringList.add("Hello");
		Shape.Color color=new Shape.Color(25,25,89);
		System.out.println(color);
		Circle.Point point=new Circle(5,5,"green").new Point();
		System.out.println(point.returnColor());
		List<String > stringList=new ArrayList<>();
		stringList.add("Sveta");
		stringList.add("Misha");
		stringList.add("Sasha");
		stringList.add("Masha");

		stringList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		stringList.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		stringList.sort((a,b)->a.length()-b.length());
		stringList.forEach(System.out::println);

		Day myDay=Day.MONDAY;
		String s=myDay.name();
		System.out.println(s);
		System.out.println("myDay number= "+myDay.dayNumber);

		System.out.println(Day.getDayByNumber2(5));
	}
}
