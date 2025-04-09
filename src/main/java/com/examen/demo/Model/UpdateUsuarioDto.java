package com.examen.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UpdateUsuarioDto {
    private final Integer id;
    private UsuarioDto productDto;
}

