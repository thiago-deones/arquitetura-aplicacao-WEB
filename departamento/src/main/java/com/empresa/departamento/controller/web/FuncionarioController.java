package com.empresa.departamento.controller.web;

import com.empresa.departamento.model.Funcionario;
import com.empresa.departamento.services.FuncionarioService;
import com.empresa.departamento.services.DepartamentoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final DepartamentoService departamentoService;

    public FuncionarioController(FuncionarioService funcionarioService, DepartamentoService departamentoService) {
        this.funcionarioService = funcionarioService;
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "funcionarios/listar";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        model.addAttribute("departamentos", departamentoService.findAll());
        return "funcionarios/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/editar")
    public String editarForm(@PathVariable Long id, Model model) {
        model.addAttribute("funcionario", funcionarioService.findByid(id));
        model.addAttribute("departamentos", departamentoService.findAll());
        return "funcionarios/form";
    }

    @PostMapping("/{id}/deletar")
    public String delete(@PathVariable Long id) {
        funcionarioService.deleteById(id);
        return "redirect:/funcionarios";
    }
}