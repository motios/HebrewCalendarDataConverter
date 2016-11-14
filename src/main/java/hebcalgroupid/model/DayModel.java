package hebcalgroupid.model;


import java.io.Serializable;

/**
 * Created by We on 11.11.2016.
 */
public class DayModel implements Serializable {



    private int dayNumber;
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

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DayModel dayModel = (DayModel) o;

        if (dayNumber != dayModel.dayNumber) return false;
        if (yomtov != dayModel.yomtov) return false;
        if (!dateGregorian.equals(dayModel.dateGregorian)) return false;
        if (!hebrewDate.equals(dayModel.hebrewDate)) return false;
        return titleEnglishDateHebrewCalendar.equals(dayModel.titleEnglishDateHebrewCalendar) && category.equals(dayModel.category);

    }

    @Override
    public int hashCode() {
        int result = dayNumber;
        result = 31 * result + dateGregorian.hashCode();
        result = 31 * result + hebrewDate.hashCode();
        result = 31 * result + titleEnglishDateHebrewCalendar.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + (yomtov ? 1 : 0);
        return result;
    }
}

