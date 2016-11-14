package hebcalgroupid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by We on 11.11.2016.
 */
public class MonthModel implements Serializable {
    private HashMap<Integer, DayModel> days;
    private int monthInt;

    public MonthModel() {
        days= new HashMap<>();
    }

    public MonthModel(int monthInt) {
        this();
        this.monthInt=monthInt;
    }

    public int getMonthInt() {
        return monthInt;
    }

    public void setMonthInt(int monthInt) {
        this.monthInt = monthInt;
    }

    public HashMap<Integer, DayModel> getDays() {
        return days;
    }

    public void setDays(HashMap<Integer, DayModel> days) {
        this.days = days;
    }

    ///add unique daymodel into list
    public void addDayModel(int dayInt, DayModel dayModel){
        days.put(dayInt,dayModel);
    }

    public DayModel getDay(int dayInt){
        return days.get(dayInt);
    }


}
