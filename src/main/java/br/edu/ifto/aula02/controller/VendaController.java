package br.edu.ifto.aula02.controller;

import br.edu.ifto.aula02.model.dao.ProdutoRepository;
import br.edu.ifto.aula02.model.dao.VendaRepository;

import br.edu.ifto.aula02.model.entity.ItemVenda;
import br.edu.ifto.aula02.model.entity.Produto;
import br.edu.ifto.aula02.model.entity.Venda;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@Scope("request")
@RequestMapping("venda")
public class VendaController {

    @Autowired
    VendaRepository repository;

    @Autowired
    ProdutoRepository productRepository;

    @Autowired
    private Venda venda;

    @GetMapping("/listarVendas")
    public ModelAndView listar(ModelMap model){
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/venda/list");
    }

    @PostMapping("/didTapAdd")
    public ModelAndView didTapAddItem(ItemVenda item, HttpSession session){

        Produto product = productRepository.produto((long) item.getProduto().getId());
        item.setProduto(product);
        Venda venda = (Venda) session.getAttribute("venda");
        venda.getItensVenda().add(item);
        item.setVenda(venda);
        return new ModelAndView("redirect:/produto/catalog");
    }


    @GetMapping("/detalhar/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("itens", repository.venda(id).getItensVenda());
        return new ModelAndView("/venda/detail", model);
    }





}
