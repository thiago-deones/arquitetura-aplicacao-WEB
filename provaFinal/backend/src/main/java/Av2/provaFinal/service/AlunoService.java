package Av2.provaFinal.service;

import Av2.provaFinal.entity.Aluno;
import Av2.provaFinal.repository.AlunoRepository;
import Av2.provaFinal.repository.CursoRepository;
import io.swagger.v3.oas.annotations.servers.Server;

@Server
public class AlunoService {

    private final AlunoRepository alunoRepo;
    private final CursoRepository cursoRepo;

    public AlunoService(AlunoRepository alunoRepo, CursoRepository cursoRepo) {
        this.alunoRepo = alunoRepo;
        this.cursoRepo = cursoRepo;
    }

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepo.save(aluno);
    }

    public Aluno matricularCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepo.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        var curso = cursoRepo.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        aluno.getCursos().add(curso);
        return alunoRepo.save(aluno);
    }

    public java.util.List<Aluno> listar() {
        return alunoRepo.findAll();
    }

    public Aluno editar(Long alunoId, Aluno alunoAtualizado) {
        Aluno existente = alunoRepo.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        // preserve id
        alunoAtualizado.setId(existente.getId());

        // if cursos não foram fornecidos, mantém os existentes
        if (alunoAtualizado.getCursos() == null) {
            alunoAtualizado.setCursos(existente.getCursos());
        }

        return alunoRepo.save(alunoAtualizado);
    }

    public void remover(Long alunoId) {
        if (!alunoRepo.existsById(alunoId)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        alunoRepo.deleteById(alunoId);
    }
    
}
