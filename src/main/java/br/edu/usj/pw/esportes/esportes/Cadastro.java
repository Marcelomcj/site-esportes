package br.edu.usj.pw.esportes.esportes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cadastro {
    

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long id;


    String nome;
    String cpf;
    String telefone;
    String email;
    
}
