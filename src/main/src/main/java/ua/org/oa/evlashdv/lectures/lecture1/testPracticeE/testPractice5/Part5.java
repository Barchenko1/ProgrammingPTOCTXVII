package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice5;

import java.io.*;
public class Part5 {
    private static final int THREADS = 10;
    private static String FILE = "part5.txt";
    private static RandomAccessFile access;
    /**
     * @param args
     *            command line parameter
     * @throws IOException
     *             if file not found
     * @throws InterruptedException
     *             if thread is sleeping and the thread is interrupted, either
     *             before or during the activity
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        FileCreator.deleteFile(new File(FILE));
        FileCreator.createFile(new File(FILE));
        startThreads(FILE,THREADS);
        Thread.sleep(1000);
        readFile(FILE);

    }

    private static void startThreads(String fileName, int threadNumber) throws FileNotFoundException {
        RandomAccessFile raf=new RandomAccessFile(fileName,"rw");
        for(int rowNum=0;rowNum<threadNumber;rowNum++) {
            MyThread thread=new MyThread(rowNum,raf);
            thread.start();
        }

    }


    private static void readFile(String fileName) throws IOException {
        BufferedReader buffer=new BufferedReader(new FileReader(fileName));
        String str;
        while((str=buffer.readLine())!=null) {
            System.out.println(str);
        }
        buffer.close();
    }

    private static class MyThread extends Thread{
        private int rowNum;
        private long point;
        private static final int COLUMNS = 20;
        public static final long ROWSIZE = COLUMNS + System.lineSeparator().length();
        private static final Object MONITOR = new Object();

        public MyThread(int rowNum, RandomAccessFile access){
            this.rowNum=rowNum;
            Part5.access=access;
            this.point=rowNum*ROWSIZE;
        }
        public void run() {
            for(int i=0;i<COLUMNS;i++) {
                synchronized(MONITOR) {
                    try {
                        Thread.sleep(1);
                        access.seek(point+i);
                        access.writeBytes(String.valueOf(rowNum));
                    } catch (IOException |InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized(MONITOR) {
                try {
                    if(rowNum<THREADS-1) {
                        access.writeBytes(System.lineSeparator());
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
