package com.jessica.onboarding.repository;

import com.jessica.onboarding.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Pessoa findByCpf(String cpf);
    Pessoa findByEmail(String email);
}
