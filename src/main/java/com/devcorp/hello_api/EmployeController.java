package com.devcorp.hello_api;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @PostMapping
    public Employe createEmploye(@RequestBody Employe employe) {
        return employeService.saveEmploye(employe);
    }
}