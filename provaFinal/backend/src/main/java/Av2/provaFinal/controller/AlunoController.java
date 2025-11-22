package Av2.provaFinal.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import Av2.provaFinal.entity.Aluno;
import Av2.provaFinal.service.AlunoService;

@RestController
@RequestMapping("/api/alunos") // rota base
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Listar todos os alunos
    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listar();
    }

    // Criar um novo aluno
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.criarAluno(aluno);
    }
}
