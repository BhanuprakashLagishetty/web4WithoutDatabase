package com.example.web4;

import com.example.web4.Model.Employee;
import com.example.web4.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    private EmployeeService service;


    @RequestMapping("/")
    public String home(ModelMap model)
    {
        System.out.println("HOME PAGE IS CALLED");
        System.out.println("HOME PAGE IS CALLED");

//        return "employeereport";
        return "index";
    }


    @RequestMapping("/GenerateEmployee")
    public String GenerateEmployee(Employee employee, Model model)
    {
        employee.setEid(678999);
        System.out.println("IAMD BAHNU"+employee);
        service.addEmployee(employee);
//        service.viewAllEmployee();



            model.addAttribute("allEmployee",service.viewAllEmployee());
            return "viewEmployees";




    }
    @RequestMapping("/Singleemployee")
    public String Singleemployee()
    {
        System.out.println("Bhanuprakash");
        return "SearchEmployee";
    }
    @RequestMapping("/employeereport")
    public String employeereport()
    {
        return "employeereport";
    }
    @RequestMapping("/SearchEmployee")
    public String SearchEmployee( long eid,Model model)
    {
        System.out.println("METHOD CALLED");
        System.out.println(eid);
        Employee e2=service.Search(eid);
        System.out.println(e2.getEname());
        model.addAttribute("employee",e2);
        return "singleEmployee";
    }
    @RequestMapping("/viewEmployees")
    public String viewEmployees(Model model)
    {
        model.addAttribute("allEmployee",service.viewAllEmployee());
        ArrayList<Employee> a=service.viewAllEmployee();
        return "viewEmployees";
    }

    //removeing element

    @RequestMapping("/removeemployee1")
    public String removeemployee1()
    {
        return "removeemployee";
    }
    @RequestMapping("/removeemployee")
    public String removeemployee( long eid,Model model)
    {

        String res=service.Remove(eid);
        model.addAttribute("result",res);
        return "removeResult";
    }

    @RequestMapping("/SearchUpdateEmployee")
    public String SearchUpdateEmployee()
    {
        return "SearchUpdateEmployee";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(long eid,Model model)
    {
        if(service.checkingForEmployee(eid))
        {
            model.addAttribute("singleEmployee",service.viewSingleEmployee(eid));
            return "updateEmployee";
        }
        else{
            String res="Employee not found";
            model.addAttribute("res",res);
            return "updateResult";
        }

    }
    @RequestMapping("/SuccesfullUpdate")
    public String SuccesfullUpdate(Employee employee,Model model)
    {
        String res=service.updateEmployee(employee);
        model.addAttribute("res",res);
        return "updateResult";

    }

}
