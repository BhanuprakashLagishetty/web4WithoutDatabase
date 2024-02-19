package com.example.web4.Services;

import com.example.web4.Model.Employee;
import com.example.web4.Repository.Mydata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    public EmployeeService() {
    }

    @Autowired
    private Mydata mydata;

    public void addEmployee(Employee employee)
    {
        mydata.addEmploy(employee);
    }
    public ArrayList<Employee> viewAllEmployee(){
        return mydata.getEmployeeArrayList();
    }
    public Employee Search(long sid)
    {

        ArrayList<Employee> employees=mydata.getEmployeeArrayList();
        int n=employees.size();
        System.out.println("size of array list: "+ n);
        for(int i=0;i<n;i++)
        {
            if(employees.get(i).getEid()==sid)
            {
                System.out.println("true");
                return employees.get(i);
            }


        }
        return null;

    }
    public String Remove(long sid)
    {
        ArrayList<Employee> employees=mydata.getEmployeeArrayList();
        int n=employees.size();
        System.out.println("size of array list: "+ n);
        for(int i=0;i<n;i++)
        {
            if(employees.get(i).getEid()==sid)
            {
                employees.remove(i);
                return "Successfully removed employee";

            }


        }
        return "Employee not found";
    }
    public  Employee viewSingleEmployee(long id)
    {
        ArrayList<Employee> employees=mydata.getEmployeeArrayList();
        for(Employee emp: employees)
        {
            System.out.println("sevice class update method is called");
            System.out.println(id);
            System.out.println(emp.getEid()+"is id");
            if(emp.getEid()==id)
            {
                System.out.println(emp.getEname());
                return emp;
            }
        }
        return null;

    }
    public String updateEmployee(Employee employee)
    {
        ArrayList<Employee> employees=mydata.getEmployeeArrayList();

        System.out.println("updating started method is called");
        for(Employee emp :employees)
        {
            if(emp.getEid()==employee.getEid())
            {
                emp.setEname(employee.getEname());
                emp.setEdesignation(employee.getEdesignation());
                emp.setEsalary(employee.getEsalary());
                return "updated succesffully";
            }
        }
        return "unable to update";

    }
    public boolean checkingForEmployee(long id)
    {
        ArrayList<Employee> employees=mydata.getEmployeeArrayList();
        for(Employee emp:employees)
        {
            if(emp.getEid()==id)
            {
                return true;
            }
        }
        return false;
    }
//    public boolean checkingData(Employee emp)
//    {
//        System.out.println("ENTERED INTO THE CHECKING DATA ");
//        if(emp.getEid()==null|| emp.getEname()==null || emp.getEdesignation()==null||emp.getEsalary() ==0)
//        {
//            System.out.println("ENTERD INTO THE FALSE STATEMENT");
//            return false;
//        }
//        return true;
//    }
}
