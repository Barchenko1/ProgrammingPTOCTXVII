package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice6;

import interfaces.task6.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOUtilsImpl implements IOUtils {
    @Override
    public void replaceChars(Reader in, Writer out, String inChars,
            String outChars) {
        if (in == null || out == null) {
            throw new NullPointerException();
        }

        if (inChars != null && outChars != null
                && inChars.length() != outChars.length()) {
            throw new IllegalArgumentException();
        }

        int n;
        if (inChars == null || outChars == null) {
            n = 0;
        } else {
            n = inChars.length();
        }
        Map<Character, Character> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(inChars.charAt(i), outChars.charAt(i));
        }
        int i = 0;
        char ch = 0;
        try {
            while ((i = in.read()) != -1) {
                ch = (char) i;
                if (map.containsKey(ch)) {
                    ch = map.get(ch);
                }
                out.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String[] findFiles(String dir) {
        if (dir == null) {
            throw new NullPointerException();
        }
        File fileName = new File(dir);
        if (!fileName.exists()) {
            throw new IllegalArgumentException();
        }
        List<String> files = new ArrayList<>();
        String[] str = fileName.list();
        for (String s : str) {
            File f = new File(dir + "/" + s);
            if (f.isFile()) {
                files.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                String[] tempStrArray = findFiles(dir + "/" + s);
                for (String inStr:tempStrArray) {
                    files.add(inStr);
                }
            } else {
                throw new IllegalStateException("I don't know what it is...");
            }
        }
        return files.toArray(new String[files.size()]);
    }

    @Override
    public String[] findFiles(String dir, String extention) {
        if (dir == null) {
            throw new NullPointerException();
        }
        if (extention == null) {
            return findFiles(dir);
        }
        File fileName = new File(dir);
        if (!fileName.exists()) {
            throw new IllegalArgumentException();
        }
        List<String> files = new ArrayList<>();
        String[] str = fileName.list();
        for (String s : str) {
            File f = new File(dir + "/" + s);
            if (f.isFile()) {
                if (f.getName().matches("\\w+.+" + extention)) {
                    files.add(f.getAbsolutePath());
                }
            } else if (f.isDirectory()) {
                String[] tempStrArray = findFiles(dir + "/" + s,extention);
                for (String inStr:tempStrArray) {
                    files.add(inStr);
                }
            } else {
                throw new IllegalStateException("I don't know what it is...");
            }
        }
        return files.toArray(new String[files.size()]);
    }

    @Override
    public void copyFile(String source, String dest) {
        if (source == null || dest == null) {
            throw new NullPointerException();
        }
        InputStream inStream;
        OutputStream outStream;
        try {
            inStream = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        try  {
            outStream = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        int b;
        try {
            while ((b = inStream.read()) != -1) {
                outStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
                outStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void copyFileBuffered(File source, File dest) {
        if (source == null || dest == null) {
            throw new NullPointerException();
        }
        InputStream bufferedInStream;
        OutputStream bufferedOutStream;
        try {
            bufferedInStream = new BufferedInputStream(
                    new FileInputStream(source));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        try {
            bufferedOutStream = new BufferedOutputStream(
                    new FileOutputStream(dest));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        int b;
        try {
            while ((b = bufferedInStream.read()) != -1) {
                bufferedOutStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInStream.close();
                bufferedOutStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void copyFileBest(String source, String dest) {
        if (source == null || dest == null) {
            throw new NullPointerException();
        }
        FileInputStream inStream;
        try {
            inStream = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

        FileOutputStream output = null;

        try {
            output = new FileOutputStream(dest);
        } catch (FileNotFoundException e) {

            try {
                inStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            throw new IllegalArgumentException(e);
        }
        FileChannel inChannel = inStream.getChannel();
        FileChannel outChannel = output.getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inStream.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
