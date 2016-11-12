package hebcalgroupid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by We on 12.11.2016.
 */
public class YearModel implements Serializable {
    private int year;
    private List<MonthModel> months;

    public YearModel() {
        months=new ArrayList<>();
    }

    public YearModel(int year) {
        this();
        this.year = year;

    }

    ///add unique daymodel into list
    public void addMonthModel(MonthModel monthModel){
        if(!months.contains(monthModel)){
            months.add(monthModel);
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<MonthModel> getMonths() {
        return months;
    }

    public void setMonths(List<MonthModel> months) {
        this.months = months;
    }
}
