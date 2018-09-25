package ua.org.oa.evlashdv.lectures.lecture1.lecture4b.newExample;

public class Human<T extends Number,S> {
    private String name;
    private T age;
    private S sex;

    public Human(String name, T age, S sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public boolean isOlder(Human<?,?> human){
        return getAge().doubleValue()>human.getAge().doubleValue();
    }
    public<T> void print(T[] args){
        for (T arg:args) {
            System.out.println(arg);
        }
    }
    public<E extends Number> double sum(E[] args){
        double sum=0;
        for (E arg:args) {
            sum+=arg.doubleValue();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human<?, ?> human = (Human<?, ?>) o;

        if (name != null ? !name.equals(human.name) : human.name != null) return false;
        if (age != null ? !age.equals(human.age) : human.age != null) return false;
        return sex != null ? sex.equals(human.sex) : human.sex == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public S getSex() {
        return sex;
    }

    public void setSex(S sex) {
        this.sex = sex;
    }
}
