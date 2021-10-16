package entities;

public class Company extends TaxPayer {

	private Integer employees;
	
	public Company() {
		super();
	}
	
	public Company(String name, Double annualIncome, Integer employees) {
		super(name, annualIncome);
		this.employees = employees;
	}

	public Integer getEmployees() {
		return employees;
	}

	public void setEmployees(Integer employees) {
		this.employees = employees;
	}

	@Override
	public double taxes() {
		if (employees < 10) {
			return annualIncome * 0.16;
		}
		else {
			return annualIncome * 0.14;
		}
	}
	
	@Override
	public String toString() {
		return name
		     + ": $ "
		     + String.format("%.2f", taxes());
	}
}
