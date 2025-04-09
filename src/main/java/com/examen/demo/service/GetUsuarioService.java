package com.examen.demo.service;

import com.examen.demo.IUserRepository;
import com.examen.demo.Query;
import com.examen.demo.Model.Usuario;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class GetUsuarioService implements Query<Integer, Usuario> {


    private final IUserRepository iUserRepository;


    public GetUsuarioService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }


    @Override
    public Usuario execute(Integer id) {
        Optional<Usuario> usuario = this.iUserRepository.findById(id);
        return usuario.orElse(null);
    }
}

