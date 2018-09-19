package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part5;

public class Part5 {
    private static int max=1000;
    private static int[] numbers={1,4,5,9,10,50,100,500,1000};
    private static String values[]={"I", "IV", "V", "IX", "X", "L", "C", "D", "M"};

    public static String decimal2Roman(int x) {
        String romanRes="";
        while (x>0){
            for (int i = 0; i <numbers.length; i++) {
                if (x<numbers[i]){
                    x-=numbers[i-1];
                    romanRes+=values[i-1];
                    break;
                }
            }
        }
        return romanRes;
    }
    public static int roman2Decimal(String s) {
        int intRes=0;
        for (int i = 0; i <s.length() ; i++) {
            char romanChar=s.charAt(i);
            int number=listElementstoNumber(romanChar);
            if (number==-1){
                throw new NumberFormatException("Invalid format");
            }if (max<number){
                number=number-max-1;
            }
            intRes+=number;
            max=number;
        }
        return intRes;
    }
    private static int listElementstoNumber(char listElement){
        switch (listElement){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return -1;
        }
    }

}
