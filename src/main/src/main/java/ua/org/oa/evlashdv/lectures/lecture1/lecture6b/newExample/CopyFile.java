package ua.org.oa.evlashdv.lectures.lecture1.lecture6b.newExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin=null;
        FileOutputStream fout=null;

        if (args.length!=2){
            System.out.println("Иcпoльзoвaниe : CopyFile откуда куда");
            return;
        }

        try {
            try {
                fin=new FileInputStream(args[0]);
                fout=new FileOutputStream(args[1]);

                do {
                    i=fin.read();
                    if (i!=-1)fout.write(i);
                }while (i!=-1);
            }catch (IOException e){
                System.out.println("Ошибка ввода-вывоад");
            }
        } finally {
            try {
                if (fin!=null) fin.close();
            } catch (IOException e2){
                System.out.println("Ошибка открытия");
            }
            try {
                if (fout!=null) fout.close();
            }catch (IOException e2){
                System.out.println("Ошибка закрытия");
            }
        }
    }
}
