package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		List<Employee> empregados = new ArrayList<>();
		
		System.out.print("Enter salary: ");
		double minSalary = sc.nextDouble();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			
			while (line != null) {
				String[] field = line.split(",");
				empregados.add(new Employee(field[0], field[1], Double.parseDouble(field[2])));
				line = br.readLine();
			}
			
			System.out.println("Email of people whose salary is more than " + minSalary + ":");
			List<String> email = empregados.stream()
					.filter(p -> p.getSalary() > minSalary)
					.map(p -> p.getEmail())
					.sorted()
					.toList();
			for (String e: email) {
				System.out.println(e);
			}
			
			System.out.print("Sum of salary of people whose name starts with 'M': " 
			+ empregados.stream()
			.filter(p -> p.getName().charAt(0) == 'M')
			.map(p -> p.getSalary())
			.reduce(0.0, (x, y) -> x + y));
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}

}
