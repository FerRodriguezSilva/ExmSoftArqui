package com.examen.demo.service;

import com.examen.demo.Command;
import com.examen.demo.IUserRepository;
import com.examen.demo.Model.Usuario;
import com.examen.demo.Model.UsuarioDto;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<UsuarioDto, String>{

    private final IUserRepository iUserRepository;


    public CreateUserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }


    @Override
    public String execute(UsuarioDto input) {


        Usuario usuario = input.toUsuario();
        int id = iUserRepository.save(usuario).getCi();
        return String.format("Usuario %d, created", id);
    }

}
