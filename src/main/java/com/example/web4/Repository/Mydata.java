package com.example.web4.Repository;

import com.example.web4.Model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class Mydata {
    private ArrayList<Employee> employeeArrayList=new ArrayList<>();


    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    public Mydata() {
        Employee emp1=new Employee("Bhanuprakash",1234,"software",30000);
        employeeArrayList.add(emp1);
        Employee emp2=new Employee("siddu",12,"software",30000);
        employeeArrayList.add(emp2);
    }

    public void addEmploy(Employee employee) {
        long uniqueNumber = System.currentTimeMillis();
        employee.setEid(uniqueNumber);
        employeeArrayList.add(employee);
        System.out.println("employee is added");
        System.out.println(getEmployeeArrayList());
    }
}
