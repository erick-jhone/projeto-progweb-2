package br.edu.ifto.aula02.controller;


import br.edu.ifto.aula02.model.dao.PessoaFisicaRepository;
import br.edu.ifto.aula02.model.entity.Pessoa;
import br.edu.ifto.aula02.model.entity.PessoaFisica;
import br.edu.ifto.aula02.model.entity.Produto;
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
@RequestMapping("pessoa/fisica")
public class PessoaFisicaController {

    @Autowired
    PessoaFisicaRepository repository;

    @GetMapping("/form")
    public ModelAndView formulario(ModelMap model) {
        model.addAttribute("pessoa", new Pessoa());
        return new ModelAndView("/pessoa-fisica/form"); //caminho para a view
    }

    @PostMapping("/save")
    public ModelAndView save(PessoaFisica pessoaFisica){
        repository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoa/fisica/list");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoa", repository.pessoa(id));
        return new ModelAndView("/pessoa-fisica/form");
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("msg","Lista de Pessoas");
        model.addAttribute("pessoas", repository.pessoas());
        return new ModelAndView("/pessoa-fisica/list"); //caminho para a view
    }

}
