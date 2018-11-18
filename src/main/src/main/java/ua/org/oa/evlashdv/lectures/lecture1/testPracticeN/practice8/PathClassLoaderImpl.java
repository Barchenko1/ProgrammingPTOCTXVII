package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice8;

import interfaces.task8.PathClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathClassLoaderImpl extends ClassLoader
        implements PathClassLoader {

    private String path;

    @Override
    public void setPath(String dir) {
        if (dir == null) {
            throw new NullPointerException();
        }
        this.path = dir;
    }

    @Override
    public String getPath() {
        return path;
    }

    private File getFile(String name) throws FileNotFoundException {
        File file = new File(path + File.separator + name + ".class");
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        return file;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String classNameWithoutPackafe = getRightName(name);
        File file;
        try {
            file = getFile(classNameWithoutPackafe);
        } catch (FileNotFoundException e) {
            throw new ClassNotFoundException("couldn't find class ", e);
        }

        byte[] bytes;
        try {
            bytes = getByte(file);
        } catch (IOException e1) {
            throw new ClassNotFoundException(
                    "couldn't get bytecode ", e1);
        }
        Class<?> result = defineClass(name, bytes, 0, bytes.length);
        return result;
    }

    private String getRightName(String name) {
        Pattern pat = Pattern.compile("[a-zA-Z0-9]+$");
        Matcher matcher = pat.matcher(name);
        String stringRight = null;
        if (matcher.find()) {
            stringRight = matcher.group();
        } else {
            throw new IllegalArgumentException();
        }
        return stringRight;
    }

    private byte[] getByte(File file) throws IOException {
        InputStream inputStream =
                new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[(int) file.length()];
        for (int i = 0; i < file.length(); i++) {
            bytes[i] = (byte) inputStream.read();
        }
        inputStream.close();
        return bytes;
    }
}
