package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice8;

import interfaces.task8.CyclicCollection;
import interfaces.task8.CyclicItem;

import java.io.Serializable;
import java.util.Objects;

public class CyclicCollectionImpl implements CyclicCollection, Serializable {

    private CyclicItem firstItem;
    private CyclicItem lastItem;
    private int size;

    public CyclicCollectionImpl() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CyclicCollectionImpl that = (CyclicCollectionImpl) o;
        return size == that.size && Objects.equals(firstItem, that.firstItem)
                && Objects.equals(lastItem, that.lastItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstItem, lastItem, size);
    }

    @Override
    public boolean add(CyclicItem item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (firstItem == null) {
            firstItem = item;
            firstItem.setNextItem(firstItem);
            lastItem = firstItem;
            size++;
        } else {
            if (isLocated(item)) {
                throw new IllegalArgumentException();
            } else {
                lastItem.setNextItem(item);
                lastItem = item;
                lastItem.setNextItem(firstItem);
                size++;
            }
        }
        return true;
    }

    private boolean isLocated(CyclicItem item) {
        int n = size;
        CyclicItem cyclicItem = firstItem;
        for (int i = n; i > 0; i--) {
            if (cyclicItem.equals(item)) {
                return true;
            }
            cyclicItem = cyclicItem.nextItem();
            n--;
        }
        return false;
    }

    @Override
    public void insertAfter(CyclicItem item,
            CyclicItem newItem) {
        if (item == null || newItem == null) {
            throw new NullPointerException();
        }
        if (!isLocated(item)) {
            throw new IllegalArgumentException();
        }
        if (isLocated(newItem)) {
            throw new IllegalArgumentException();
        }
        CyclicItem before = lastItem;
        CyclicItem now = firstItem;
        CyclicItem next = firstItem.nextItem();
        for (int i = 0; i < size; i++) {
            if (now.equals(item)) {
                if (size > 2) {
                    now.setNextItem(newItem);
                    newItem.setNextItem(next);
                    size++;
                    return;
                } else if (size == 2) {
                    now.setNextItem(newItem);
                    newItem.setNextItem(next);
                    before = newItem;
                    size++;
                    return;
                }
            }
            lastItem = now;
            now = newItem;
            next = next.nextItem();
        }
    }

    @Override
    public CyclicItem getFirst() {
        return firstItem;
    }

    @Override
    public boolean remove(CyclicItem item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size == 0) {
            return false;
        }
        CyclicItem before = lastItem;
        CyclicItem now = firstItem;
        CyclicItem next = firstItem.nextItem();
        for (int i = 0; i < size; i++) {
            if (now.equals(item)) {
                if (size > 2) {
                    now.setNextItem(null);
                    before.setNextItem(next);
                    size--;
                    return true;
                } else if (size == 2) {
                    now.setNextItem(null);
                    before.setNextItem(next);
                    firstItem = next;
                    size--;
                    return true;
                } else {
                    firstItem = null;
                    size--;
                    return true;
                }
            }
            lastItem = now;
            now = next;
            next = next.nextItem();
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "CyclicCollectionImpl{" + "size = " + size + ", firstItem = "
                + firstItem + ", lastItem = " + lastItem + '}';
    }
}
