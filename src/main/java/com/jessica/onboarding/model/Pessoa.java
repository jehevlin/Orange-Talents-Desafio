package com.jessica.onboarding.model;

import com.jessica.onboarding.model.validation.IdadeMinima;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "nome obrigatório")
    private String nome;

    @NotBlank(message = "e-mail obrigatório")
    @Email(message = "e-mail inválido")
    private String email;

    @CPF(message = "CPF inválido")
    private String cpf;

    @IdadeMinima(idade = 16, message = "menores de 16 anos precisam da autorização do tutor legal para cadastro")
    private LocalDate dataNascimento;

    public int getId() { return id; }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
