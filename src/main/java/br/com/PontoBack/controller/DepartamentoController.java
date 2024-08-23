package br.com.PontoBack.controller;

import br.com.PontoBack.dto.RegisterDepRequestDTO;
import br.com.PontoBack.dto.ResponseDepDTO;
import br.com.PontoBack.model.Departamento;
import br.com.PontoBack.repository.DepartamentoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @PostMapping
    public ResponseEntity register(@Valid @RequestBody RegisterDepRequestDTO dto) {
        Optional<Departamento> dep = departamentoRepository.findByNome(dto.nome());
        Date data = new Date();
        if (dep.isEmpty()) {

            var departamento = new Departamento();
            departamento.setNome(dto.nome());

            departamento.setDtCriacao(data);
            departamento.setAtivo(true);
            departamento.setDtAtualizacao(data);

            this.departamentoRepository.save(departamento);
            return ResponseEntity.ok(new ResponseDepDTO(departamento.getNome()));
        }

        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}
