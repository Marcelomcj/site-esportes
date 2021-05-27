package br.edu.usj.pw.esportes.esportes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;

    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro() {
        ModelAndView modelAndView = new ModelAndView("cadastro");
        
        return modelAndView;
    }
    

    @PostMapping(value="/adicionar")
    public ModelAndView postAdicionar(@RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone, @RequestParam String email) {
        //criar objeto do tipo cadastro
         Cadastro cadastro = new Cadastro();

        //preencher objeto cadastro com os tipos que vierem
        cadastro.setNome(nome);
        cadastro.setCpf(cpf);
        cadastro.setTelefone(telefone);
        cadastro.setEmail(email);

        //salvar no banco (usando repository)
        cadastroRepository.save(cadastro);

        //criar template
        ModelAndView modelAndView = new ModelAndView("detalhes");

        //popular o template
        modelAndView.addObject("cadastro", cadastro);

        //retornar

        return modelAndView;
    }
    
    
}
