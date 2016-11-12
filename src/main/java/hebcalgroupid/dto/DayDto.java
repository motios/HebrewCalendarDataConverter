package hebcalgroupid.dto;


import java.io.Serializable;

/**
 * Created by We on 10.11.2016.
 */
public class DayDto implements Serializable {
    private String date;
    private String hebrew;
    private String title;
    private String category;
    private String link;
    private String memo;
    private boolean yomtov;

    public DayDto() {}


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHebrew() {
        return hebrew;
    }

    public void setHebrew(String hebrew) {
        this.hebrew = hebrew;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isYomtov() {
        return yomtov;
    }

    public void setYomtov(boolean yomtov) {
        this.yomtov = yomtov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayDto dayDto = (DayDto) o;

        if (!date.equals(dayDto.date)) return false;
        if (!hebrew.equals(dayDto.hebrew)) return false;
        return title.equals(dayDto.title);

    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + hebrew.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }
}
