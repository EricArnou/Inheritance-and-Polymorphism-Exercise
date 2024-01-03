import ericarnou68.entities.Company;
import ericarnou68.entities.Person;
import ericarnou68.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<TaxPayer> listTaxPayers = new ArrayList<>();
        double totalTaxes = 0;

        System.out.print("Enter the number of tax payers: ");
        int numberOfTaxPayers = scanner.nextInt();

        for (int i = 0; i < numberOfTaxPayers; i++) {
            System.out.println();
            System.out.println("Individual or Company? (i/c)");
            char typeOftaxPayer = scanner.next().charAt(0);
            scanner.nextLine();

            if(typeOftaxPayer == 'i') {
                System.out.print("Name: ");
                String namesTaxPayer = scanner.nextLine();
                System.out.print("Annual Income: ");
                Double annualIncome = scanner.nextDouble();
                System.out.print("Healthcare expenses: ");
                Double healthCareExpenses = scanner.nextDouble();

                TaxPayer person = new Person(namesTaxPayer, annualIncome, healthCareExpenses);
                listTaxPayers.add(person);
            }
            else {
                System.out.print("Name: ");
                String namesTaxPayer = scanner.nextLine();
                System.out.print("Annual Income: ");
                Double annualIncome = scanner.nextDouble();
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = scanner.nextInt();

                TaxPayer company = new Company(namesTaxPayer, annualIncome, numberOfEmployees);
                listTaxPayers.add(company);
            }
        }
        System.out.println("Taxes Paid: ");

        for(TaxPayer e: listTaxPayers){
            System.out.println(e.getName() + ": $ " + e.tax());
            totalTaxes += e.tax();
        }
        System.out.println("Total taxes: $" + totalTaxes);
    }
}