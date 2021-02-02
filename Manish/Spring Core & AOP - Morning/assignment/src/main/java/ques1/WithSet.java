package ques1;

import java.util.Set;

public class WithSet {

    private Set<Integer> values;

    public Set<Integer> getValues() {
        return values;
    }

    public void setValues(Set<Integer> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "WithSet{" +
                "values=" + values +
                '}';
    }
}
