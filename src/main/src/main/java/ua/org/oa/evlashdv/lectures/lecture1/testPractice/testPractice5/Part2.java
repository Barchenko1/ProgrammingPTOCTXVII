package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice5;


import java.io.IOException;
import java.io.InputStream;
/**
 * Emulates presses "Enter" to stop threads of class "Spam".
 *
 * @author Barchenko Pavel
 * @version 1.0
 */
public class Part2 {

    private static final InputStream STD_IN=System.in;

    private static class MyInputStream extends InputStream{

        private boolean firstCall = true;
        private final int sleepTime = 2000;
        private final int enterKeyCode = 13;
        private final int emptyInputStreamCode = -1;


        @Override
        public int read() throws IOException {
            if (firstCall) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                firstCall = false;
                return enterKeyCode;
            } else {
                return emptyInputStreamCode;
            }
        }

    }

//	private static String encoding = "cp1251";
//
//	public static String getEncoding() {
//		return encoding;
//	}
    /**
     * Emulates presses "Enter" to stop threads of class "Spam"
     *
     * @see Spam
     * @param args
     *            command line parameter
     */

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setIn(new MyInputStream());
        Thread thread=new Thread()
        {	public void run() {
            try {
                Spam.main(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        };
        thread.start();
        thread.join();
        System.setIn(STD_IN);
    }

}