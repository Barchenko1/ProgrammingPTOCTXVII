package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice1;

public class Part7 {
    public static void main(String[] args) {
        int digit1 = Integer.parseInt(args[0]);
        String char1 = String.valueOf(args[1]);
        String char2 = String.valueOf(args[2]);
        System.out.println(digit1 + " ==> " + Part7.digitsToChars(digit1));
        System.out.println(char1 + " ==> " + Part7.charsToNumbers(char1));
        System.out.println(char2 + " ==> " + Part7.rightColumn(char2));
    }
    public static int charsToNumbers(String number) {
        int numeric = 0;
        for (int i = 1,j=number.length(); j > 0;i++, j--) {
            numeric += (int) (number.toUpperCase().charAt(number.length() - i) - 64)
                    * Math.pow(26, number.length() - j);
        }
        return numeric;
    }

    public static String digitsToChars(int num) {
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
        num2 = charsToNumbers(num);
        num2++;
        chars = digitsToChars(num2);
        return chars;
    }

}
