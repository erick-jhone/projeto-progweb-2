package br.edu.ifto.aula02.controller;

import br.edu.ifto.aula02.model.dao.VendaRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@RequestMapping("venda")
public class VendaController {

    @Autowired
    VendaRepository repository;

    @GetMapping("/listarVendas")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/venda/list");
    }

    @GetMapping("/detalhar/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("itens", repository.venda(id).getItensVenda());
        return new ModelAndView("/venda/detail", model);
    }





}
