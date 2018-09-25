package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3;

import ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part1.Part1;
import ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part2.Part2;
import ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part3.Part3;
import ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part4.Part4;
import ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part5.Part5;

import java.security.NoSuchAlgorithmException;

public class Demo {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = Util.readFile("part1.txt");
        System.out.println("part1" + "\n" + Part1.convert1(input));
        System.out.println(Part1.convert2(input));
        System.out.println(Part1.convert3(input));
        System.out.println("\n"+Part1.convert4(input));
        String input2 = Util.readFile("part2.txt");
        System.out.println("\nPart2"+"\n"+ Part2.convert5(input2));
        String intut3=Util.readFile("part3.txt");
        System.out.println("\nPart3"+"\n"+ Part3.convert6(intut3));
        System.out.println("\nPart4");
        System.out.println(Part4.hash("password", "SHA-256"));
        System.out.println(Part4.hash("passwort", "SHA-256"));
        System.out.println("\nPart5");
        System.out.println(Part5.decimal2Roman(66));
        System.out.println(Part5.roman2Decimal("LXVI"));

    }
}
