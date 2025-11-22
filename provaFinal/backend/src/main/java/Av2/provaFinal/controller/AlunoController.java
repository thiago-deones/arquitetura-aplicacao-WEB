import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Av2.provaFinal.entity.Aluno;
import Av2.provaFinal.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService; // ✅ agora está certo
    }

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listar();
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Aluno criado = alunoService.criarAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PostMapping("/{alunoId}/cursos/{cursoId}")
    public ResponseEntity<Aluno> matricularCurso(@PathVariable Long alunoId,
                                                  @PathVariable Long cursoId) {
        Aluno atualizado = alunoService.matricularCurso(alunoId, cursoId);
        return ResponseEntity.ok(atualizado);
    }
}
