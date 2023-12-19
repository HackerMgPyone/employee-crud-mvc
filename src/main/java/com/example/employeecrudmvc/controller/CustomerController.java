package com.example.employeecrudmvc.controller;

import com.example.employeecrudmvc.entity.Customer;
import com.example.employeecrudmvc.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("customers", customerService.findAllCustomer());
        return "home";
    }

    @GetMapping("/save-customer")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @PostMapping("/save-customer")
    public String processCustomer(@Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "customerForm";
        }

        customerService.createCustomer(customer);
        return "redirect:/home";
    }
}