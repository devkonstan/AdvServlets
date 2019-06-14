package Date;

public class Date {
    private String dayOfTheWeek;
    private String month;
    private String year;

    public Date(String dayOfTheWeek, String month, String year) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.month = month;
        this.year = year;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date.Date{" +
                "dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
