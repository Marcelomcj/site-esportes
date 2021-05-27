package br.edu.usj.pw.esportes.esportes;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CadastroRepository extends CrudRepository<Cadastro, Long> {
    
    List<Cadastro> findAll();
}
