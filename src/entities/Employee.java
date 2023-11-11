package entities;

public class Employee {
	
	String name;
	String email;
	double Salary;
	
	public Employee(String name, String email, double salary) {
		this.name = name;
		this.email = email;
		Salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
}
