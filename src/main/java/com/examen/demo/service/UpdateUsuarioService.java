package com.examen.demo.service;

import com.examen.demo.Command;
import com.examen.demo.IUserRepository;
import com.examen.demo.Model.Usuario;
import com.examen.demo.Model.UsuarioDto;
import com.examen.demo.Model.UpdateUsuarioDto;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class UpdateUsuarioService implements Command<UpdateUsuarioDto, UsuarioDto> {


    private final IUserRepository iUserRepository;


    UpdateUsuarioService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    @Override
    public UsuarioDto execute(UpdateUsuarioDto input) {
        Optional<Usuario> product = iUserRepository.findById(input.getId());


        if(product.isPresent()) {
            product.get().setTelefono(input.getUsuarioDto().getTelefono());
            product.get().setName(input.getProductDto().getName());
            return new UsuarioDto(iUserRepository.save(usuario.get()));
        }
        return  null;


    }
}
