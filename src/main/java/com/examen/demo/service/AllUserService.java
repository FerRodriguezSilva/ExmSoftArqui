package com.examen.demo.service;
import com.examen.demo.IUserRepository;
import com.examen.demo.service.AllUserService;
import com.examen.demo.service.CreateUserService;
import com.examen.demo.Model.Usuario;
import com.examen.demo.Query;
import com.examen.demo.Model.UsuarioDto;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class AllUserService implements Query<Void, List<UsuarioDto>> {
    private final IUserRepository IUserRepository;


    AllUserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }
    @Override
    public List<UsuarioDto> execute(Void input) {
        List<Usuario> usuarios = IUserRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();
    }

}
