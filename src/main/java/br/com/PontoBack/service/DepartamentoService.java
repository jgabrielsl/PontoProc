package br.com.PontoBack.service;

import br.com.PontoBack.model.Departamento;
import br.com.PontoBack.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/{id}")
    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    @PostMapping
    public Optional<Departamento> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }
}
