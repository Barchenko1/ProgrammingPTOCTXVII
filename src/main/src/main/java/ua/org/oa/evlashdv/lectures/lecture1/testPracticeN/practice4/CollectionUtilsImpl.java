package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice4;

import interfaces.task4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtilsImpl implements CollectionUtils {

    @Override
    public List<Integer> union(Collection<Integer> a,
            Collection<Integer> b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        List<Integer> result = new ArrayList<>(a);
        result.addAll(b);
        return result;
    }

    @Override
    public List<Integer> intersection(Collection<Integer> a,
            Collection<Integer> b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        List<Integer>  startList = union(a,b);
        List<Integer>  result = new ArrayList<>();

        for (Integer num:startList) {
            if (a.contains(num) && b.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    @Override
    public Set<Integer> intersectionWithoutDuplicate(
            Collection<Integer> a, Collection<Integer> b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        Set<Integer> startSet = new HashSet<>(a.size() > b.size() ? a : b);
        Set<Integer> result = new HashSet<>();
        for (Integer num:startSet) {
            if (a.contains(num) && b.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    @Override
    public Collection<Integer> difference(
            Collection<Integer> a, Collection<Integer> b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        List<Integer>  result = new ArrayList<>(a);

        for (Integer num:a) {
            if (b.contains(num)) {
                result.remove(num);
            }
        }
        return result;
    }
}
