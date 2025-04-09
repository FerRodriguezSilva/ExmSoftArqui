package com.examen.demo.service;

import com.examen.demo.IUserRepository;
import com.examen.demo.Query;
import com.examen.demo.Model.Usuario;
import com.examen.demo.Model.UsuarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class GetUsuarioService implements Query<Integer, UsuarioDto> {


    private final IUserRepository iUserRepository;


    public GetUsuarioService(IUserRepository iUserRepository   ) {
        this.iUserRepository = iUserRepository;
    }


    @Override
    public ResponseEntity<UsuarioDto> execute(Integer id) {
        Optional<Usuario> product = this.iUserRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    product.map(UsuarioDto::new).get());
        }
        return null;
    }

}

