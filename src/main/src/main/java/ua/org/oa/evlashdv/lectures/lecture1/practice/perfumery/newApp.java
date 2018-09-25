package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class newApp {
    private static String file0="test.txt";
    private static String file00="test0.txt";
    private static String file1="test1.txt";
    private static String file3="fileOut1.txt";
    private static String file2="fileOut2.txt";
    private static String file4="fileOut2.doc";
    private static String file5="fileOut3.txt";
    private static final String REGEX1 = "\\(\\w+\\)|\\(\\w+&\\w+\\)|\\(\\w+\\s*\\w+\\)";
    //regex просто для всех файлов без всяких М с цифрой
    private static final String REGEX="(\\d+|\\w\\d+)\\s+((\\w+|\\w+\\-\\w+|\\w+'\\w+|\\w+&\\w+)|((\\w+|\\w+.\\d+.\\d+|\\w+'\\w+|\\w+\\-\\w+)\\s+(\\w+|\\w+'\\w+|\\w+-\\w+|\\w+.\\d+.\\d+.\\w+))|((\\w+|\\w+'\\w+)\\s+(\\w+|\\w+'\\w+))|((\\w+|\\w*'\\w+|\\w+.\\w+.\\w+|\\w+&+\\w+)\\s+(\\w+|\\w*'\\w+|\\w+.\\d+.\\d+)\\s+(\\w+|\\w+\\-\\w+|\\w+'\\w+))|(\\w+|\\w+&\\w+)\\s+(\\w+|\\w+'\\w+)\\s+(\\w+|\\w+'\\w+|\\w+.\\w+.)\\s+\\w+|\\w+\\s+\\w+\\s+(\\w+|\\w+'\\w+)\\s+\\w+\\s+\\w+|(\\w+|\\w+'\\w+)\\s+(\\w+|\\w+'\\w+)\\s+\\w+\\s+\\w+\\s+\\w+\\s+\\w+|\\w+\\s+\\w+\\s+\\w+\\s+\\w+\\s+\\w+\\s+\\w+\\s+\\w+)\\s+(\\(\\w+\\)|\\(\\w+&\\w+\\)|\\(\\w+\\s+\\w+\\)|\\(\\w+\\s+\\w+\\s+\\w+\\)|\\(\\w+.\\w+\\)|\\(\\w+.\\w+.\\w+\\))";

    private static final String REGEX2="(\\d+|\\w\\d+)";
    public static void main(String[] args) throws IOException {
        File fileToRead=new File(file1);
        String str=fileToString(fileToRead);

        str=find(str,REGEX);
        String[] array=str.split(System.lineSeparator());

        System.out.println(Arrays.toString(array));
        //Arrays.sort(array);
        stringToFile(arrayToString(array));

    }



    private static String arrayToString(String[] array){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]+System.lineSeparator());
        }
        return builder.toString();
    }
    private static void stringToFile(String str) throws IOException {
        File fileToWrite=new File(file3);
        BufferedWriter bfw=new BufferedWriter(new FileWriter(fileToWrite));
        bfw.write(str);
        bfw.flush();
        bfw.close();
    }

    private static String fileToString(File file) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String text;
        while((text=bufferReader.readLine())!=null) {
            builder.append(text+System.lineSeparator());
        }
        bufferReader.close();
        return builder.toString();
    }
    private static String find(String string, String REGEX){
        StringBuilder result = new StringBuilder();
        Pattern pattern=Pattern.compile(REGEX,Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher=pattern.matcher(string);
        while (matcher.find()){
            result.append(matcher.group(20)+" "+matcher.group(2)+" "+matcher.group(1)+System.lineSeparator());
            //result.append(matcher.group()+System.lineSeparator());
        }
        return result.toString();
    }

}
