package compositedesignpattern;

public abstract class Developer extends Hourly {

    String profile;
    public Developer(String id, double payRate,  String profile) {
        super(id, payRate);
        this.profile=profile;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public abstract void printDetails();
}
