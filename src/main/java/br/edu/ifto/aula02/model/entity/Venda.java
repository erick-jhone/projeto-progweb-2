package br.edu.ifto.aula02.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Venda implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;
    private LocalDateTime data;

    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itensVenda;

    public double getTotal() {
        double total = 0.0;
        for(ItemVenda itemVenda:itensVenda){
            total += itemVenda.total();
        }

        return total;
    }

}
