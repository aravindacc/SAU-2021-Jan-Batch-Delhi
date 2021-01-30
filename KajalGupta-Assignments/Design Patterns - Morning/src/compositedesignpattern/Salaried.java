package compositedesignpattern;

public abstract class Salaried extends Employee
{
    public static final double MINIMUM_WAGE = 455.00;

    public Salaried(String name, String id, double ctc) {
        super(name, id, ctc);
    }
    public abstract int getOvertimeHours();
    public abstract double getOverTimePay();
}
