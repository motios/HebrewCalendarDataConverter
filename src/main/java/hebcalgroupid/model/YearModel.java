package hebcalgroupid.model;

import java.io.Serializable;
import java.util.HashMap;


/**
 * Created by We on 12.11.2016.
 */
public class YearModel implements Serializable {
    private int yearInt;
    private HashMap<Integer,MonthModel> months;

    private YearModel() {
        months=new HashMap<>();
    }

    public YearModel(int yearInt) {
        this();
        this.yearInt = yearInt;

    }

    ///add unique monthModel into list
    public void addMonthModel(int monthInt, MonthModel monthModel){
        months.put(monthInt,monthModel);
    }

    public int getYearInt() {
        return yearInt;
    }

    public void setYearInt(int yearInt) {
        this.yearInt = yearInt;
    }

    public MonthModel getMonth(int monthNum) {
        return months.get(monthNum);
    }

    public HashMap<Integer, MonthModel> getMonths() {
        return months;
    }

    public void setMonths(HashMap<Integer, MonthModel> months) {
        this.months = months;
    }
}
