package hebcalgroupid.model;


import java.io.Serializable;

/**
 * Created by We on 11.11.2016.
 */
public class DayModel implements Serializable {



    private String dateGregorian;
    private String hebrewDate;
    private String titleEnglishDateHebrewCalendar;
    private String category;
    private boolean yomtov;

    public DayModel() {    }

    public DayModel(String dateGregorian, String hebrewDate, String titleEnglishDateHebrewCalendar, String category) {
        this.dateGregorian = dateGregorian;
        this.hebrewDate = hebrewDate;
        this.titleEnglishDateHebrewCalendar = titleEnglishDateHebrewCalendar;
        this.category = category;
    }

    public String getDateGregorian() {
        return dateGregorian;
    }

    public void setDateGregorian(String dateGregorian) {
        this.dateGregorian = dateGregorian;
    }

    public String getHebrewDate() {
        return hebrewDate;
    }

    public void setHebrewDate(String hebrewDate) {
        this.hebrewDate = hebrewDate;
    }

    public String getTitleEnglishDateHebrewCalendar() {
        return titleEnglishDateHebrewCalendar;
    }

    public void setTitleEnglishDateHebrewCalendar(String titleEnglishDateHebrewCalendar) {
        this.titleEnglishDateHebrewCalendar = titleEnglishDateHebrewCalendar;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

        DayModel dayModel = (DayModel) o;

        if (!dateGregorian.equals(dayModel.dateGregorian)) return false;
        if (!hebrewDate.equals(dayModel.hebrewDate)) return false;
        if (!titleEnglishDateHebrewCalendar.equals(dayModel.titleEnglishDateHebrewCalendar)) return false;
        return category.equals(dayModel.category);

    }

    @Override
    public int hashCode() {
        int result = dateGregorian.hashCode();
        result = 31 * result + hebrewDate.hashCode();
        result = 31 * result + titleEnglishDateHebrewCalendar.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}
