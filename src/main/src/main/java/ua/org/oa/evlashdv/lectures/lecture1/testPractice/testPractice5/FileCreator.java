package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileCreator {
    static void createFile(File fileName) throws IOException {
        fileName.createNewFile();
    }

    static void deleteFile(File fileName) {
        if(fileName.exists()) {
            fileName.delete();
        }
    }

    static void fillFileWithRandomNumbers(String fileName, int m, int n) throws IOException {
        FileWriter fileWriter=new FileWriter(fileName);
        Random random=new Random();
        int num;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                num=random.nextInt(900)+100;
                if(i==m-1&&j==n-1) {
                    fileWriter.write(num+"");
                }else if(j==n-1){
                    fileWriter.write(num+System.lineSeparator());
                }else {
                    fileWriter.write(num+" ");
                }
            }
        }
        fileWriter.close();
    }
}
