package com.example.demo.controller;


import com.example.demo.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        Employee emp1 = new Employee(1,"Manh Cuong", "Tran", "trancuong@gmail.com", "0123456789");
        Employee emp2 = new Employee(2,"Manh Kien", "Tran", "saberValkyrie@gmail.com", "0987654321");
        Employee emp3 = new Employee(3,"Ngoc Mai", "Ngo", "ngongocmai@gmail.com", "0123456789");

        theEmployees = new ArrayList<>();
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", theEmployees);

        return "list_employees";
    }
}
