package com.empresa.departamento.controller.web;

import com.empresa.departamento.model.Departamento;
import com.empresa.departamento.services.DepartamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService service;
    public DepartamentoController(DepartamentoService service) { this.service = service; }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("departamentos", service.findAll());
        return "departamentos/listar";
    }

    @GetMapping("/novo")
    public String novoForm(Model model){
        model.addAttribute("departamento", new Departamento());
        return "departamentos/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Departamento departamento){
        service.save(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model){
        Departamento departamento = service.findById(id);
        if (departamento != null) {
            model.addAttribute("departamento", departamento);
            return "departamentos/form";
        }
        return "redirect:/departamentos";
    }

    @GetMapping("/{id}/detalhes")
    public String detalhes(@PathVariable Long id, Model model){
        Departamento departamento = service.findById(id);
        if (departamento != null) {
            model.addAttribute("departamento", departamento);
            return "departamentos/detalhes";
        }
        return "redirect:/departamentos";
    }

    @PostMapping("/{id}/deletar")
    public String excluir(@PathVariable Long id){
        service.deleteById(id);
        return "redirect:/departamentos";
    }
}