package br.edu.ifto.aula02.controller;

import br.edu.ifto.aula02.model.dao.PessoaRepository;
import br.edu.ifto.aula02.model.entity.Pessoa;
import br.edu.ifto.aula02.model.entity.PessoaFisica;
import br.edu.ifto.aula02.model.entity.PessoaJuridica;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @GetMapping("/form")
    public ModelAndView form(ModelMap model) {
            model.addAttribute("pessoa", new Pessoa());
            return new ModelAndView("/pessoa/form");
    }

    @PostMapping("/save")
    public ModelAndView save(Pessoa pessoa){
        repository.save(pessoa);

        return new ModelAndView("redirect:/pessoa/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.pessoa(id));
        return new ModelAndView("/pessoa/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("msg","Lista de Pessoas");
        model.addAttribute("pessoas", repository.pessoas());
        return new ModelAndView("/pessoa/list");
    }

}
