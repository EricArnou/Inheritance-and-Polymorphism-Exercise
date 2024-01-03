package ericarnou68.entities;

public class Person extends TaxPayer {
    private Double healthCareExpenses;

    public Person() {
        super();
    }

    public Person(String name, Double annualIncome, Double healthCareExpenses) {
        super(name, annualIncome);
        this.healthCareExpenses = healthCareExpenses;
    }

    public Double getHealthCareExpenses() {
        return healthCareExpenses;
    }

    public void setHealthCareExpenses(Double healthCareExpenses) {
        this.healthCareExpenses = healthCareExpenses;
    }

    @Override
    public Double tax() {
        if (getAnnualIncome() < 20000 && getHealthCareExpenses()>0){
            return getAnnualIncome() * 0.15 - 0.5 * getHealthCareExpenses();
        }
        else if (getAnnualIncome() < 20000){
            return getAnnualIncome() * 0.15;
        }
        else if(getAnnualIncome() > 20000 && getHealthCareExpenses()>0){
            return getAnnualIncome() * 0.25 - 0.5 * getHealthCareExpenses();
        }
        else{
            return getAnnualIncome() * 0.25;
        }
    }
}
