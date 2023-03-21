package application;

import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        // Data collector (department, name, level and base salary) | create Worker object
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your personal data: ");
        System.out.print("Department: ");
        String department = sc.next();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Level (JUNIOR, MID_LEVEL OR SENIOR): ");
        WorkerLevel level = WorkerLevel.valueOf(sc.next());
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        // Create an object with the informed data
        Worker worker = new Worker(name, level, baseSalary);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Contract collector (number of contracts, date, value per hour and quantity of hours in each contract)
        System.out.println("How many contracts do you want to include? ");
        int numberOfContracts = sc.nextInt();

        // Create a vector to include all data from the contracts informed
        HourContract[] contracts = new HourContract[numberOfContracts];
        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println("Enter a date in format DD/MM/YYYY: ");
            String inputDate = sc.next();
            Date date = sdf.parse(inputDate);
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.println("How many hours: ");
            Integer hours = sc.nextInt();
            contracts[i] = new HourContract(date, valuePerHour, hours);
        }

        // Pass the contract to the List in Worker object
        for (HourContract contract : contracts) {
            String dateReformed = sdf.format(contract.getDate());
            System.out.print("Contract - Date: " + dateReformed);
            System.out.println(contract);
            worker.addContract(contract);
        }

        // Get the month and year to see earnings in that period
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
        System.out.print("Enter the month and year to see your gains: MM/YYYY: ");
        String dateConsult = sc.next();
        Date dateIncome = sdf2.parse(dateConsult);
        cal.setTime(dateIncome);
        double totalIncome = 0;

        // Compare if the month/year informed are equal to each item in the list of dates
        for (int i = 0; i < worker.getDateContract().size(); i++) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(worker.getDateContract().get(i));
            // If so, sum the value earned in that month to a total income variable
            if (cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {
                totalIncome += worker.getValueContract().get(i);
                }
            }

        // Print the data values
        System.out.println("Data" );
        System.out.println("Department: " +department);
        System.out.println(worker);
        System.out.println("Total income for " + dateConsult + ": " + totalIncome);
        }
    }
