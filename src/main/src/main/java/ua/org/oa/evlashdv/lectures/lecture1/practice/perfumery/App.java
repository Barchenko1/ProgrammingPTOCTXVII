package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private static String file1="test.txt";
    private static String file2="fileOut.txt";
    private static final String REGEX1 = "\\(\\w+\\)|\\(\\w+&\\w+\\)|\\(\\w+\\s*\\w+\\)";
    private static final String REGEX = "(M\\d+)\\s+((\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+.\\d+.\\d+\\s*)|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+)(\\(\\D+\\)|\\(\\w+\\s*\\w+\\))";
    private static final String REGEX2="(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+.\\d+.\\d+\\s*)|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+|\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))\\s+(\\w+|(\\w+'\\w+))";

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
        File fileToWrite=new File(file2);
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
            result.append(matcher.group()+System.lineSeparator());
        }
        return result.toString();
    }

}

