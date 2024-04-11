package br.edu.ifto.aula02.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("J")
public class PessoaJuridica extends Pessoa {

    private String cnpj;
}