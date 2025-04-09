package com.examen.demo.Controller;

import com.examen.demo.Model.UsuarioDto;
import com.examen.demo.Model.UpdateUsuarioDto;
import com.examen.demo.service.AllUserService;
import com.examen.demo.service.CreateUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> create(
            @RequestBody UsuarioDto usuarioDto
    ) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUserService.execute(usuarioDto));
    }

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
