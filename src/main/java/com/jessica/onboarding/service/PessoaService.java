package com.jessica.onboarding.service;

import com.jessica.onboarding.model.Pessoa;
import com.jessica.onboarding.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class PessoaService {
    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa save(Pessoa pessoa) {
        if (CpfExists(pessoa.getCpf())) {
            throw new ValidationException("cpf já cadastrado");
        }

        if (EmailExists(pessoa.getEmail())) {
            throw new ValidationException("e-mail já cadastrado");
        }

        return repository.save(pessoa);
    }

    private boolean CpfExists(String cpf) {
        return repository.findByCpf(cpf) != null;
    }

    private boolean EmailExists(String email) {
        return repository.findByEmail(email) != null;
    }
}

