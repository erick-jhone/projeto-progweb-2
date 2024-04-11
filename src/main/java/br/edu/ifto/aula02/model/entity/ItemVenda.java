package br.edu.ifto.aula02.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ItemVenda implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Double quantidade;

    @ManyToOne
    Venda venda;

    @ManyToOne
    Produto produto;

    public Double total(){
        return produto.getValor() * quantidade;
    };




}
