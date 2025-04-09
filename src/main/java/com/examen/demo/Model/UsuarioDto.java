package com.examen.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data

@AllArgsConstructor
public class UsuarioDto {

    private int ci;
    private String name;
    private int telefono;

    public UsuarioDto (Usuario usuario) {
        this.ci = usuario.getCi();
        this.name = usuario.getName();
        this.telefono = usuario.getTelefono();

    }
    public Usuario toUsuario() {
        var usuario = new Usuario();
        usuario.setCi(this.ci);
        usuario.setName(this.name);
        usuario.setTelefono(this.telefono);
        return usuario;
    }

}

