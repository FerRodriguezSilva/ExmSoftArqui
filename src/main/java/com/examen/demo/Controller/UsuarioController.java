package com.examen.demo.Controller;

import com.examen.demo.Model.UsuarioDto;
import com.examen.demo.Model.UpdateUsuarioDto;
import com.examen.demo.service.AllUserService;
import com.examen.demo.service.CreateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping()
public class UsuarioController {

    private final AllUserService allUserService;
    private final CreateUserService createUserService;

    public UsuarioController(AllUserService allUserService,
                             CreateUserService createUserService) {
        this.allUserService = allUserService;
        this.createUserService = createUserService;
    }

    @PostMapping
    @Operation(
            summary = "Crear usuario",
            description = "Registra un nuevo usuario en el sistema con CI, nombre, y telefono.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Usuario agregado",
                            content = @Content(schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "credenciales incorrectas o duplicadas",
                            content = @Content(schema = @Schema(implementation = String.class))
                    )
            }
    )

    @GetMapping
    public ResponseEntity<String> obtain() {
        return ResponseEntity.status(HttpStatus.OK).body("The user");
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.updateUsuarioService.execute(new UpdateUsuarioDto(id, usuarioDto))
        );

    }

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(allUserService.execute(null));
    }
}
