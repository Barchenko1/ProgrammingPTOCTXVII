package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice8;

import interfaces.task8.SerializableUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializableUtilsImpl implements SerializableUtils {

    @Override
    public void serialize(OutputStream out, Object obj) {
        if (out == null || obj == null) {
            throw new NullPointerException();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object deserialize(InputStream in) {
        ObjectInputStream objectInputStream = null;
        Object object;
        try {
            objectInputStream = new ObjectInputStream(in);
            object = objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
