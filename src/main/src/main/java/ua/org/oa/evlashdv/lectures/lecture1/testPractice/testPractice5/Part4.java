package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice5;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Parallelize the task of finding the maximum value and output the result and
 * code execution time.
 *
 * @author Barchenko Pavel
 * @version 1.0
 */
public class Part4 {
    private static int rows, cols;

    private static final String REGEXP = "(\\w+)\\s+";
    private static final String REGEXP_ROW = "\\n";
    private static final String REGEXP_COL = "(\\w+)\\s+";

    private static int[][] array;
    private static MyThread thread;
    private static final String FILE="part4.txt";
    private static int[][] fillArrayFromFile(String regExp, String fileName) throws IOException {
        Pattern pattern=Pattern.compile(regExp);
        Matcher matcher=pattern.matcher(fileToString(fileName));
        Pattern patternRows = Pattern.compile(REGEXP_ROW);
        Matcher matcherRows = patternRows.matcher(fileToString(fileName));
        Pattern patternCol = Pattern.compile(REGEXP_COL);
        Matcher matcherCol = patternCol.matcher(fileToString(fileName));
        int countRow=0;
        int countCol=0;
        while(matcherRows.find()) {
            countRow++;
        }
        while(matcherCol.find()) {
            countCol++;
        }
        rows=countRow;
        cols=countCol/countRow;
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matcher.find())
                    array[i][j] = Integer.parseInt(matcher.group(1));
            }
        }
        return array;

    }

    private static String fileToString(String fileName) throws IOException {
        BufferedReader buff=new BufferedReader(new FileReader(fileName));
        StringBuilder builder=new StringBuilder();
        String line;
        while((line=buff.readLine())!=null) {
            builder.append(line).append(System.lineSeparator());
        }
        buff.close();
        return builder.toString();
    }
    /**
     * Parallelize the task of finding the maximum value and output the result and
     * code execution time
     *
     * @param args
     *            command line parameter
     * @throws InterruptedException
     *             if thread is sleeping and the thread is interrupted, either
     *             before or during the activity
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        array=fillArrayFromFile(REGEXP,FILE);
        long before=System.currentTimeMillis();
        int maxValue=0;
        for(int i=0;i<rows;i++) {
            thread=new MyThread(array[i],maxValue);
            thread.start();
            if(i==rows-1) {
                thread.join();
            }
        }
        int maxMultiple=thread.getMaxValue();
        long after=System.currentTimeMillis();
        long time=after-before;
        System.out.println(maxMultiple +System.lineSeparator()+time);

        MySlowThread mySlowThread=new MySlowThread(array,rows,cols);
        long before2=System.currentTimeMillis();
        mySlowThread.start();
        mySlowThread.join();
        int max2=mySlowThread.getMaxValue();
        long after2=System.currentTimeMillis();
        long time2=after2-before2;
        System.out.println(max2 +System.lineSeparator()+time2);
    }


    /**
     * Finds the maximum element in an array.
     *
     * @author Barchenko Pavel
     * @version 1.0
     */
    private static class MyThread extends Thread{
        private static int maxValue;
        private int[] array;
        /**
         * Initializes class fields
         *
         * @param array
         *            array for searching max element
         */
        private MyThread(int[] array, int maxValue) {
            this.array = array;
            this.maxValue = maxValue;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void run() {
            try {
                for(int i=0;i<array.length;i++) {
                    Thread.sleep(1);
                    if(maxValue<array[i]) {
                        maxValue=array[i];
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MySlowThread extends Thread{
        private int maxValue, m, n;
        private int[][] array;

        private MySlowThread(int[][] array, int m, int n) {
            this.array = array;
            this.m = m;
            this.n = n;
        }

        public int getMaxValue() {
            return maxValue;
        }

        public void run() {
            try {
                for(int i=0;i<m;i++) {
                    for(int j=0;j<n;j++) {
                        Thread.sleep(1);
                        if(maxValue<array[i][j]) {
                            maxValue=array[i][j];
                        }
                    }
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

