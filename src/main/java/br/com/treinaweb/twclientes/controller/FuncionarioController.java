package br.com.treinaweb.twclientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twclientes.model.Funcionario;
import br.com.treinaweb.twclientes.model.UF;
import br.com.treinaweb.twclientes.repository.CargoRepository;
import br.com.treinaweb.twclientes.repository.FuncionarioRepository;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView("funcionario/listar");
        modelAndView.addObject("funcionarios", funcionarioRepository.findAll());

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("funcionario/detalhar");
        modelAndView.addObject("funcionario", funcionarioRepository.getReferenceById(id));

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/funcionarios");

        funcionarioRepository.deleteById(id);

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("funcionario/cadastrar");

        modelAndView.addObject("funcionario", new Funcionario());
        modelAndView.addObject("cargos", cargoRepository.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }

    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);

        return "redirect:/funcionarios";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("funcionario/formulario");

        modelAndView.addObject("funcionario", funcionarioRepository.getReferenceById(id));
        modelAndView.addObject("cargos", cargoRepository.findAll());
        modelAndView.addObject("ufs", UF.values());

        return modelAndView;
    }    
}
