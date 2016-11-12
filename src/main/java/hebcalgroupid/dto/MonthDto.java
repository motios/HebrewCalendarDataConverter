package hebcalgroupid.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by We on 10.11.2016.
 */
public class MonthDto implements Serializable {

    private Location location;

    private List<DayDto> items;
    private String title;
    private String date;
    private String link;

    public MonthDto() {
        items = new ArrayList<DayDto>();
        location=new Location();
    }

    public List<DayDto> getItems() {
        return items;
    }

    public void setItems(List<DayDto> items) {
        this.items = items;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
