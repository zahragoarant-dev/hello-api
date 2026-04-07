package com.devcorp.hello_api;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
}