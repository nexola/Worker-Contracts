package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private List<Date> dateContract = new ArrayList<>();
    private List<Double> valueContract = new ArrayList<>();

    // Constructors
    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public List<Date> getDateContract() {
        return dateContract;
    }

    public void setDateContract(List<Date> dateContract) {
        this.dateContract = dateContract;
    }

    public List<Double> getValueContract() {
        return valueContract;
    }

    public void setValueContract(List<Double> valueContract) {
        this.valueContract = valueContract;
    }

    // Add date and value data informed in the main program to lists
    public void addContract(HourContract contract){
        dateContract.add(contract.getDate());
        valueContract.add(contract.totalValue());
    }

    // To string
    @Override
    public String toString() {
        return "Worker: " +
                name +
                ", Level: " + level +
                ", Base salary: " + baseSalary;
    }
}


