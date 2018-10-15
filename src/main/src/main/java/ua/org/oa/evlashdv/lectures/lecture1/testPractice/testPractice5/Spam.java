package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice5;

import java.util.Scanner;
/**
 * Displays corresponding messages on the screen at specified intervals time.
 *
 * @author Barchenko Pavel
 * @version 1.0
 */
public class Spam extends Thread{
    private static String[] messages = new String[] {"@@@", "bbbbbbb", "wadawd"};
    private static int[] times = new int[] {333, 222, 444};

    private static boolean flag = true;
    private String message;
    private int time;

    Spam(String message, int time) {
        this.message = message;
        this.time = time;
    }

    /**
     * Displays corresponding messages on the screen at specified intervals time
     */
    public void run() {
        while(flag) {
            try {
                sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(message);
        }
    }

    private static void interruptInput() {
        Scanner scanner=new Scanner(System.in);
        String command;
        while(true) {
            command=scanner.nextLine();
            if(command.equals("")) {
                flag=false;
                break;
            }
        }
        scanner.close();
    }
    /**
     * Running threads and shutting down the program when you click "Enter"
     *
     * @param args
     *            command line parameter
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Spam[] list=new Spam[messages.length];
        for(int i=0;i<messages.length;i++) {
            list[i]=new Spam(messages[i],times[i]);
            list[i].start();
        }

        interruptInput();

        for(Spam t:list) {
            t.join();
        }
    }
}
