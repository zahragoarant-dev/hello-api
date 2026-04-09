package com.devcorp.hello_api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeServiceTest {

    @Mock
    private EmployeRepository employeRepository;

    @InjectMocks
    private EmployeService employeService;

    @Test
    void getAllEmployes_retourneListeVide() {
        when(employeRepository.findAll()).thenReturn(List.of());

        List<Employe> result = employeService.getAllEmployes();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void getAllEmployes_retourneListeAvecEmployes() {
        Employe employe = new Employe("Goarant", "Zahra", "Développeuse Backend Java");
        when(employeRepository.findAll()).thenReturn(List.of(employe));

        List<Employe> result = employeService.getAllEmployes();

        assertEquals(1, result.size());
        assertEquals("Zahra", result.get(0).getPrenom());
    }

    @Test
    void saveEmploye_sauvegardEtRetourneEmploye() {
        // ARRANGE
        Employe employe = new Employe("Dupont", "Jean", "Développeur Java");
        when(employeRepository.save(employe)).thenReturn(employe);

        // ACT
        Employe result = employeService.saveEmploye(employe);

        // ASSERT
        assertNotNull(result);
        assertEquals("Jean", result.getPrenom());
        assertEquals("Dupont", result.getNom());
        verify(employeRepository, times(1)).save(employe);

    }
}