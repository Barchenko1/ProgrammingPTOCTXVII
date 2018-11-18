package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice7;

import interfaces.task7.executor.CopyTask;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTaskImpl implements CopyTask {

    private String source;
    private String dest;
    private int count;

    public CopyTaskImpl(String source, String dest) {
        this.source = source;
        this.dest = dest;
    }

    public CopyTaskImpl() {
    }

    @Override
    public void setSource(String source) {
        if (source == null) {
            throw new NullPointerException();
        }
        if (!source.matches(".+[.]{1}.+")) {
            throw new IllegalArgumentException(new IllegalArgumentException());
        }
        this.source = source;
    }

    @Override
    public void setDest(String dest) {
        if (dest == null) {
            throw new NullPointerException();
        }
        this.dest = dest;
    }

    @Override
    public int getTryCount() {
        return count;
    }

    @Override
    public void incTryCount() {
        count++;
    }

    //////////мб не верно попробовать через буфер

    @Override
    public boolean execute() throws Exception {
        BufferedInputStream bfin;
        BufferedOutputStream bfout;
        File fileSource = new File(source);
        File fileDest = new File(dest);
        if (!fileSource.exists()) {
            fileSource.createNewFile();

        }
        if (!fileDest.exists()) {
            fileDest.createNewFile();
        }

        try {
            bfin = new BufferedInputStream(new FileInputStream(fileSource));
            bfout = new BufferedOutputStream(new FileOutputStream(fileDest));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        }

        try {
            int b;
            while ((b = bfin.read()) > -1) {
                bfout.write(b);
            }
            bfout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bfin.close();
            bfout.close();
        }
        return true;
    }
}
