package br.com.PontoBack.controller;

import br.com.PontoBack.dto.LoginDTO;
import br.com.PontoBack.dto.RegisterRequestDTO;
import br.com.PontoBack.dto.ResponseDTO;
import br.com.PontoBack.model.Usuario;
import br.com.PontoBack.repository.UsuarioRepository;
import br.com.PontoBack.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginDTO dto) {
        var user = userRepository.findByEmail(dto.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(dto.senha(), user.getSenha())) { // compare the password
            var token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterRequestDTO dto) {
        Date data = new Date();
        Optional<Usuario> user = userRepository.findByEmail(dto.email());
        if (user.isEmpty()) {

            var usuario = new Usuario();
            usuario.setSenha(passwordEncoder.encode(dto.senha()));
            usuario.setEmail(dto.email());
            usuario.setNome(dto.nome());
            usuario.setCpf(dto.cpf());
            usuario.setDepartamento(dto.departamento());

            usuario.setDtCriacao(data);
            usuario.setAtivo(true);
            usuario.setDtAtualizacao(data);

            this.userRepository.save(usuario);
            String token = tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseDTO(usuario.getNome(), token));
        }

        return ResponseEntity.badRequest().body("Invalid credentials");
    }

}
