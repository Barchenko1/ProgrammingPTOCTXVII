package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;

        if (args.length != 1) {
            System.out.println("ShowFile TEST");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if (i != -1) System.out.println((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Oшибкa чтения из файла");
        } finally {
            try {
                if (fin!=null) ;
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
