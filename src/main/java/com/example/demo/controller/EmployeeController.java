package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/showEmployees/list")
    public String showEmployees(Model model) {
        List<Employee> listOfEmployyes = employeeRepository.findAll();
        model.addAttribute("employees", listOfEmployyes);
        return "list-employees";
    }

}
