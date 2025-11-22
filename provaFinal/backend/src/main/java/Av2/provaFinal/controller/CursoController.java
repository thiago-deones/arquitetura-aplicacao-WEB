package Av2.provaFinal.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import Av2.provaFinal.entity.Curso;
import Av2.provaFinal.repository.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @PostMapping
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }
}
