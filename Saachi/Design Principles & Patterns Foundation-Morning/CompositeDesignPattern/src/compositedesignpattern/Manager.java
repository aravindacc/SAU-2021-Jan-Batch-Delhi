package compositedesignpattern;

public class Manager extends Salaried {

    private static final double PF_Percentage=6.73;
    private double bonusWorkHours = 0.0;
    private double overTimePay = 0.0;
    private int overTimeHours = 0;
    public Manager(String name, String id, double ctc, String notifyMode)
    {
        super(name, id, ctc, notifyMode);
    }

    public void setBonus(double b)
    {
        this.bonusWorkHours = b;
    }

    public int getOvertimeHours()
    {
        if(bonusWorkHours > MAX_WORK_WEEK)
            overTimeHours = (int) bonusWorkHours- MAX_WORK_WEEK;
        return overTimeHours;
    }

    public double getOverTimePay()
    {
        if(bonusWorkHours > MAX_WORK_WEEK)
            return overTimePay = getOvertimeHours() * this.getCTC()/40 * 1.5;
        else
            return overTimePay = 0.0;
    }

    public double computeSalary() {
        double PF_Amount = this.getCTC() * (PF_Percentage / 100);
        this.setNetSalary(this.getCTC() - PF_Percentage);
        return (getNetSalary()+this.getOverTimePay());
    }

    @Override
    public void printDetails() {
        System.out.println( "Id : "+this.getId()+" | "+
                            "Name: "+this.getName()+" | "+
                            "Salary in Account: "+this.getNetSalary());
    }
}
