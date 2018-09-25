package ua.org.oa.evlashdv.lectures.lecture1.lecture1b;

import java.util.HashMap;
import java.util.Map;

public enum Day {
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);
public static Map<Integer,Day> dayMap=new HashMap<>();
static {
    for (Day day:values()){
        dayMap.put(day.dayNumber,day);
    }
}
    int dayNumber;
    Day(int dayNumber){
        this.dayNumber=dayNumber;
    }
    public static Day getDayByNumber1(int dayNumber){
        Day result=null;
        for (Day day:values()) {
            if (day.dayNumber==dayNumber){
                return day;
            }
        }
        return result;
    }
    public static Day getDayByNumber2(int dayNumber){
        return dayMap.get(dayNumber);
    }
}
