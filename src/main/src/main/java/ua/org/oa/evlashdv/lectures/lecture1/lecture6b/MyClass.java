package ua.org.oa.evlashdv.lectures.lecture1.lecture6b;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyClass {

    private static void listAll(String path, ArrayList<String> res)
            throws IOException
    {
        File dir = new File(path);
        File[] list = dir.listFiles();

        for (File f : list) {
            if (f.isFile()) {
                res.add("F: " + f.getCanonicalPath());
            } else {
                res.add("D: " + f.getCanonicalPath());
                listAll(f.getCanonicalPath(), res);
            }
        }
    }

    public static void main(String[] args) {
        final String path = "D:\\Siemens NX";
        ArrayList<String> res = new ArrayList<String>();

        try {
            listAll(path, res);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : res)
            System.out.println(s);
    }
}
