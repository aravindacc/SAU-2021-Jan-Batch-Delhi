package compositedesignpattern;

import java.util.Arrays;

public class TimeCard {

    private double[] hours;

    public TimeCard()
    {
        this.hours = new double[Day.values().length];
        Arrays.fill(this.hours, 0.0);
    }

    public double getHours(Day day)
    {
        return switch (day) {
            case SUNDAY -> hours[0];
            case MONDAY -> hours[1];
            case TUESDAY -> hours[2];
            case WEDNESDAY -> hours[3];
            case THURSDAY -> hours[4];
            case FRIDAY -> hours[5];
            case SATURDAY -> hours[6];
        };
    }

    public double[] getHours()
    {
        return hours;
    }

    public void addHours(Day day, double hrs)
    {
        if(hours[day.ordinal()] != 0.0)
            this.hours[day.ordinal()] = hrs;
        else
            this.hours[day.ordinal()] += hrs;
    }

    public enum Day
    {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
}




