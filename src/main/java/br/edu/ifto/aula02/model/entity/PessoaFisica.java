package br.edu.ifto.aula02.model.entity;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("F")
public class PessoaFisica extends Pessoa {

    private String cpf;

}