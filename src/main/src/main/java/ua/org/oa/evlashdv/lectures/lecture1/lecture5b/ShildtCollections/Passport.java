package ua.org.oa.evlashdv.lectures.lecture1.lecture5b.ShildtCollections;

public class Passport {
    private String number;
    private String date;

    public Passport(String number, String date) {
        this.number = number;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "number='" + number + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
