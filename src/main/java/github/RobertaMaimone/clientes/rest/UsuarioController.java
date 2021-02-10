package github.RobertaMaimone.clientes.rest;

import github.RobertaMaimone.clientes.exception.UsuarioCadastradoException;
import github.RobertaMaimone.clientes.model.entity.Usuario;
import github.RobertaMaimone.clientes.model.repository.UsuarioRepository;
import github.RobertaMaimone.clientes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try {
            usuarioService.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
