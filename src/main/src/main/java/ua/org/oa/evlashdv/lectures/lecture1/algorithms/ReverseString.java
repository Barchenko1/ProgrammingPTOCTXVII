package ua.org.oa.evlashdv.lectures.lecture1.algorithms;

public class ReverseString {
    public static void main(String[] args) {
        String str="hello + 1";
        char[] tempArray=new char[str.length()];
        char[] charArray=new char[str.length()];

        for (int i = 0; i <str.length() ; i++) {
            tempArray[i]=str.charAt(i);
        }
        for (int j = 0; j < str.length(); j++) {
            charArray[j]=tempArray[str.length()-1-j];
        }
        String reverseStr=new String (charArray);
        System.out.println(reverseStr);
    }
}
