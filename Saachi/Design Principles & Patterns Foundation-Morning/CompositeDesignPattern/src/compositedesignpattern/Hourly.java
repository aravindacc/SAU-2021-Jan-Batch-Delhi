package compositedesignpattern;

public abstract class Hourly extends Employee
{
    public static final double MINIMUM_WAGE = 8.00;

    private TimeCard timecard = new TimeCard();
    private double pay = 0.0;
    private int hoursWorked = 0;

    Hourly(String id, double payRate, String notifyMode ) {
        super(id, payRate, notifyMode);
    }

    public void addHours(TimeCard.Day day, double hrs)
    {
        timecard.addHours(day, hrs);
    }

    public double computeSalary()
    {
        hoursWorked = 0;
        pay = 0;
        for(TimeCard.Day a: TimeCard.Day.values())
        {
            hoursWorked += (int) this.timecard.getHours(a);
        }
        if(hoursWorked <= MAX_WORK_WEEK)
        {
            pay = hoursWorked * this.getPayRate();
        }
        else
            pay = MAX_WORK_WEEK * this.getPayRate();
        //System.out.println(hoursWorked+" "+pay);
        this.setNetSalary(pay);
        return pay;
    }
}
