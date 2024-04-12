package br.edu.ifto.aula02.controller;

import br.edu.ifto.aula02.model.dao.PessoaJuridicaRepository;
import br.edu.ifto.aula02.model.entity.Pessoa;
import br.edu.ifto.aula02.model.entity.PessoaFisica;
import br.edu.ifto.aula02.model.entity.PessoaJuridica;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("pessoa/juridica")
public class PessoaJuridicaController {

    @Autowired
    PessoaJuridicaRepository repository;

    @GetMapping("/form")
    public String form(PessoaJuridica pessoaJuridica) {
        return "/pessoa-juridica/form";
    }

    @PostMapping("/save")
    public ModelAndView save(PessoaJuridica pessoaJuridica){
        repository.save(pessoaJuridica);
        return new ModelAndView("redirect:/pessoa/juridica/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaJuridica", repository.pessoa(id));
        return new ModelAndView("/pessoa-juridica/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("msg","Lista de Pessoas Jurídicas");
        model.addAttribute("pessoas", repository.pessoas());
        return new ModelAndView("/pessoa-juridica/list");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/pessoa/juridica/list");
    }


    @PostMapping("/update")
    public ModelAndView update(PessoaJuridica pessoaJuridica) {
        repository.update(pessoaJuridica);
        return new ModelAndView("redirect:/pessoa/juridica/list");
    }


}
