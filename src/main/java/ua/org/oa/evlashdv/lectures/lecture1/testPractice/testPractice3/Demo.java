package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3;

import ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part1.Part1;
import ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part2.Part2;

public class Demo {
    public static void main(String[] args) {
        String input = Util.readFile("part1.txt");
        System.out.println("Part1" + "\n" + Part1.convert1(input));
        System.out.println(Part1.convert2(input));
        System.out.println(Part1.convert3(input));
        System.out.println("\n"+Part1.convert4(input));
        String input2 = Util.readFile("part2.txt");
        System.out.println("Part2"+"\n"+ Part2.convert(input2));

    }
}
