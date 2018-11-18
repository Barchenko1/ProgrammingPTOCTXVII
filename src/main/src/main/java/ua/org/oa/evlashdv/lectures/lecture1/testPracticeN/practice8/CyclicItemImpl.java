package ua.org.oa.evlashdv.lectures.lecture1.testPracticeN.practice8;

import interfaces.task8.CyclicItem;

import java.io.Serializable;
import java.util.Objects;

public class CyclicItemImpl implements CyclicItem, Serializable {

    private transient Object temp;
    private Object value;
    private CyclicItem nextItem;

    public CyclicItemImpl() {
        this.nextItem = this;
    }

    public CyclicItemImpl(Object temp, Object value) {
        this.temp = temp;
        this.value = value;
    }

    @Override
    public void setValue(Object o) {
        this.value = o;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setTemp(Object o) {
        this.temp = o;
    }

    @Override
    public Object getTemp() {
        return temp;
    }

    @Override
    public CyclicItem nextItem() {
        return nextItem;
    }

    @Override
    public void setNextItem(CyclicItem item) {
        nextItem = item;
    }

    @Override public String toString() {
        return "CyclicItemImpl{" + "temp=" + temp + ", value=" + value + '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CyclicItemImpl that = (CyclicItemImpl) o;
        return Objects.equals(value, that.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
