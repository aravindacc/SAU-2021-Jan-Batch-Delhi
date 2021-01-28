package compositedesignpattern;

public class InternDeveloper extends Developer {

    public InternDeveloper( String id, double payRate, String notifyMode,String profile)
    {
        super(id, payRate,notifyMode,profile);
    }

    @Override
    public void printDetails() {
        System.out.println( "Id : "+this.getId()+" | "+
                            "Profile: "+this.getProfile()+" | "+
                            "Salary in Account: "+this.getNetSalary());
    }

}
