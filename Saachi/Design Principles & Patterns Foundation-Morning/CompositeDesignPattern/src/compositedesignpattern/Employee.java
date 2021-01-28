package compositedesignpattern;

public abstract class Employee {

    private String name;
    private String id;
    private double CTC;
    private double netSalary;
    private double payRate;
    private String notifyMode;

    public static final int MAX_WORK_WEEK = 40;
    public static final int MAX_WORK_DAY = 9;

    Employee(String name, String id, double ctc, String notifyMode) {
        this.name = name;
        this.id = id;
        this.CTC = ctc;
        this.notifyMode=notifyMode;
    }

    Employee(String id, double payRate, String notifyMode) {
        this.id = id;
        this.payRate = payRate;
        this.notifyMode=notifyMode;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return id;
    }

    public double getCTC() {
        return CTC;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public void sendEmail(String msg){
        System.out.println(msg);
    }

    public void sendSMS(String msg){
        System.out.println(msg);
    }

    public String getNotifyMode() {
        return notifyMode;
    }


    public abstract double computeSalary();
    public void sendSalaryNotification(String notificationMode){
        if(notificationMode.equals("E-mail")){
            sendEmail("E-mail ALERT!\nYour account is credited with "+ this.getNetSalary());
        }
        else{
            sendSMS("SMS ALERT !\nYour account is credited with "+ this.getNetSalary());
        }
    }
    public abstract void printDetails();
}
