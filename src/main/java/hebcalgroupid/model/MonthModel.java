package hebcalgroupid.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by We on 11.11.2016.
 */
public class MonthModel implements Serializable {
    private List<DayModel> days;
    private Date date;

    public MonthModel() {
        days= new ArrayList<>();

    }

    public List<DayModel> getDays() {
        return days;
    }

    ///add unique daymodel into list
    public void addDayModel(DayModel dayModel){
        if(!days.contains(dayModel)){
            days.add(dayModel);
        }
    }

    public void setDays(List<DayModel> days) {
        this.days = days;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
