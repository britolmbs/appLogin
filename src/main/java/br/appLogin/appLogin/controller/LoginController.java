package br.appLogin.appLogin.controller;

import br.appLogin.appLogin.model.Usuario;
import br.appLogin.appLogin.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository ur;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/cadastro")
    public String Cadastro(){
        return "cadastro";
    }
    @RequestMapping(value = "/cadastro" , method = RequestMethod.POST)
    public String cadastroUsuario(@Valid Usuario usuario, BindingResult result){

        if (result.hasErrors()) {
            return "redirect:/cadastro";
        }
        ur.save(usuario);
        return "redirect:/login";
    }
}
