package br.edu.usj.pw.esportes.esportes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;
     
    @GetMapping(value="/cadastros")
    public ModelAndView getAdicionar() {
        //criar um objeto lista
        List<Cadastro> lista= new ArrayList<>();

        //preencher essa lista com os dados do banco
        lista = cadastroRepository.findAll();
        
        //instancia um template
        ModelAndView modelAndView = new ModelAndView("cadastros");

        //preencher o template com a lista
        modelAndView.addObject("lista", lista);
        
        //retornar o template
        return modelAndView;
    }

    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
        
        //ler contato do banco pelo id
        Cadastro cadastro = new Cadastro();
        cadastro = cadastroRepository.findById(id).get();

        //instanciar o template
        ModelAndView modelAndView = new ModelAndView("detalhes");

        //preencher o template com o cadastro selecionado
        modelAndView.addObject("cadastro", cadastro);
 
        //retornar o template
        return modelAndView;
    }
    
    
    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro() {
        Cadastro cadastro = new Cadastro();

        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("cadastro", cadastro);
        
        return modelAndView;
    }
    

    @PostMapping(value="/adicionar")
    public ModelAndView postAdicionar(@RequestParam Long id, @RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone, @RequestParam String email) {
        //criar objeto do tipo cadastro
         Cadastro cadastro = new Cadastro();

        //preencher objeto cadastro com os tipos que vierem
        cadastro.setId(id);
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

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        //selecionar cadastro do banco pelo id
        Cadastro cadastro = new Cadastro();
        cadastro = cadastroRepository.findById(id).get();

        //instanciar template
        ModelAndView modelAndView = new ModelAndView("cadastro");

        //popular o template
        modelAndView.addObject("cadastro", cadastro);

        //retornar o template
        return modelAndView;

    }
    

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {
        //deletar o objeto com o id passado pelo parametro
       cadastroRepository.deleteById(id);

        //retornar para (raiz)
        return "redirect:/";
    }
    
    
    
}
