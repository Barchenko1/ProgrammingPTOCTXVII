package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice1;

public class Part7 {
    public static void main(String[] args) {

        String char0 = String.valueOf(args[0]);
        String char1 = String.valueOf(args[1]);
        String char2 = String.valueOf(args[2]);
        String char3 = String.valueOf(args[3]);
        String char4 = String.valueOf(args[4]);
        String char5 = String.valueOf(args[5]);
        String char6 = String.valueOf(args[6]);
        String char7 = String.valueOf(args[7]);

        System.out.println(char0+" ==> "+chars2Numbers(char0)+" ==> "+digits2Chars(chars2Numbers(char0)));
        System.out.println(char1+" ==> "+chars2Numbers(char1)+" ==> "+digits2Chars(chars2Numbers(char1)));
        System.out.println(char2+" ==> "+chars2Numbers(char2)+" ==> "+digits2Chars(chars2Numbers(char2)));
        System.out.println(char3+" ==> "+chars2Numbers(char3)+" ==> "+digits2Chars(chars2Numbers(char3)));
        System.out.println(char4+" ==> "+chars2Numbers(char4)+" ==> "+digits2Chars(chars2Numbers(char4)));
        System.out.println(char5+" ==> "+chars2Numbers(char5)+" ==> "+digits2Chars(chars2Numbers(char5)));
        System.out.println(char6+" ==> "+chars2Numbers(char6)+" ==> "+digits2Chars(chars2Numbers(char6)));
        System.out.println(char7+" ==> "+chars2Numbers(char7)+" ==> "+digits2Chars(chars2Numbers(char7)));

    }
    public static int chars2Numbers(String number) {
        int numeric = 0;
        for (int i = 1,j=number.length(); j > 0;i++, j--) {
            numeric += (int) (number.toUpperCase().charAt(number.length() - i) - 64)
                    * Math.pow(26, number.length() - j);
        }
        return numeric;
    }

    public static String digits2Chars(int num) {
        String chars = "";
        String charsCoup  = "";
        int module;
        while (num != 0) {
            module = num % 26;
            if (module == 0) {
                chars += "Z";
                num = (num - 1) / 26;
            } else {
                chars += (char) (module + 64);
                num = (num - module) / 26;
            }
        }
        for (int i = 0; i < chars.length(); i++)
            charsCoup  += chars.charAt(chars.length() - i - 1);
        return charsCoup ;
    }

    public static String rightColumn(String num) {
        String chars = "";
        int num2;
        num2 = chars2Numbers(num);
        num2++;
        chars = digits2Chars(num2);
        return chars;
    }

}
