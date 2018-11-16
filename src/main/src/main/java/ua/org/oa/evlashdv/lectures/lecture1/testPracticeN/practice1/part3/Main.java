package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part3;


import ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part2.Circle;
import ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part2.Figure;
import ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice1.part2.Triangle;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[11];
        Random random = new Random();
        
        for (int i = 0; i < figures.length; i++) {

            if (random.nextInt(2) == 0) {
                figures[i] = new Circle(random.nextInt(100),
                        random.nextInt(100), random.nextInt(100));
            } else {
                figures[i] = new Triangle(random.nextInt(100),
                        random.nextInt(100), random.nextInt(100),
                        random.nextInt(100), random.nextInt(100),
                        random.nextInt(100));
            }

        }

        for (int i = 1; i < figures.length; i++) {
            System.out.print(i + " - ");
            if (figures[i] instanceof Circle) {
                figures[i].print();
            } else {
                figures[i].print();
            }
        }
    }
}
