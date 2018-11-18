package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice4;

import interfaces.task4.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtilsImpl implements MapUtils {
    private static final String REGEX = "[a-zA-Z0-9]{3}";

    @Override
    public Map<String, Integer> findThrees(String s) {
        Map<String, Integer> resultMap = new HashMap<>();
        if (s == null) {
            throw new NullPointerException();
        }
        String[] wordsArray = s.split(" ");
        for (int i = 0; i < wordsArray.length; i++) {
            List<String> threeCharsList = parsedString(wordsArray[i]);
            for (int j = 0; j < threeCharsList.size(); j++) {
                String treeChars = threeCharsList.get(j);
                if (resultMap.containsKey(treeChars)) {
                    int num = resultMap.get(treeChars);
                    num++;
                    resultMap.put(treeChars, num);
                } else {
                    resultMap.put(treeChars, 1);
                }
            }
        }
        return resultMap;
    }

    private static List<String> parsedString(String arg) {
        List<String> subs = new ArrayList<>();
        String s;
        for (int i = 0; i < arg.length() - 2; i++) {
            s = arg.substring(i, i + 3);
            if (s.matches(REGEX)) {
                subs.add(s);
            }
        }
        return subs;
    }
}
