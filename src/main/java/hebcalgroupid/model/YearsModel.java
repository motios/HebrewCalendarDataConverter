package hebcalgroupid.model;

import java.io.Serializable;
import java.util.HashMap;


/**
 * Created by We on 14.11.2016.
 */
public class YearsModel implements Serializable{

    private HashMap<Integer,YearModel> years;

    public YearsModel() {
        years=new HashMap<>();
    }

    public YearsModel(HashMap<Integer, YearModel> years) {
        this();
        this.years = years;
    }

    public void addYear(int yearInt, YearModel yearModel){
        years.put(yearInt,yearModel);
    }

    public YearModel getYear(int yearInt){
        return years.get(yearInt);
    }

    public HashMap<Integer, YearModel> getYears() {
        return years;
    }

    public void setYears(HashMap<Integer, YearModel> years) {
        this.years = years;
    }
}
