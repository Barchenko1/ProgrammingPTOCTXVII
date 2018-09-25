package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice3.part4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest=MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash=digest.digest();
        StringBuilder builder=new StringBuilder();
        for (byte b:hash) {
            builder.append(String.format("%02x",b));
        }
        return builder.toString();
    }

}
