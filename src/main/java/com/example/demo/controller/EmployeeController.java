package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model model){
        Employee newEmployee = new Employee();
        model.addAttribute("employee", newEmployee);
        return "add-employee-form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/showEmployees/list";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateFOrm(@RequestParam Long employeeId, Model model){
        Employee existingEmployee = employeeRepository.findById(employeeId).get();
        model.addAttribute("employee", existingEmployee);
        return "add-employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee (@RequestParam Long employeeId) {
        employeeRepository.deleteById(employeeId);
        return "redirect:/showEmployees/list";
    }

}
