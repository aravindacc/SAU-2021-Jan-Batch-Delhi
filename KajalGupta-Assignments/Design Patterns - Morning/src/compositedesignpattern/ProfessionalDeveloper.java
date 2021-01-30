package compositedesignpattern;

public class ProfessionalDeveloper extends Developer{

    double bonusAmount=0;
    public ProfessionalDeveloper( String id, double payRate, String profile)
    {
        super(id, payRate,profile);
    }

    public double getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(double b)
    {
        this.bonusAmount = b;
    }

    @Override
    public void printDetails() {
        System.out.println( "Id : "+this.getId()+" | "+
                "Profile: "+this.getProfile()+" | "+
                "Salary in Account: "+this.getNetSalary()+" | "+
                "Bonus Amount: "+this.getBonusAmount());
    }

}
