package ua.org.oa.evlashdv.lectures.lecture1.practice.perfumery;

import java.io.*;

public class MyObj implements Serializable {

}
class MyObj2 extends MyObj{
    private void writeObj() throws NotSerializableException {
        throw new NotSerializableException();
    }
}
