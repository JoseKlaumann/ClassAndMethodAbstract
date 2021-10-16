package entities;

public class Individual extends TaxPayer{

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double taxes() {
		double basicTax;
		if (annualIncome < 20000.00) {
			basicTax = annualIncome * 0.15;
		} 
		else {
			basicTax = annualIncome * 0.25;
		}
		
		basicTax -= healthExpenditures * 0.5;
		
		if(basicTax < 0.0) {
		//Se o gasto com saude for muito alto 
		//o imposto pode dar negativo e nao existe imposto negativo
			basicTax = 0.0;
		}
		return basicTax;
	}

	@Override
	public String toString() {
		return name 
			 + ": $ "
			 + String.format("%.2f", taxes());
	}
	
}
