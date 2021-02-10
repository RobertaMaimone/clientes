package github.RobertaMaimone.clientes.rest;

import github.RobertaMaimone.clientes.model.entity.Cliente;
import github.RobertaMaimone.clientes.model.entity.ServicosPrestados;
import github.RobertaMaimone.clientes.model.repository.ClienteRepository;
import github.RobertaMaimone.clientes.model.repository.ServicosPrestadosRepository;
import github.RobertaMaimone.clientes.rest.dto.ServicosPrestadosDTO;
import github.RobertaMaimone.clientes.ultil.BigDecimalConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicosPrestadosController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ServicosPrestadosRepository servicosPrestadosRepository;
    @Autowired
    private BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicosPrestados salvar(@RequestBody @Valid ServicosPrestadosDTO dto) {
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository.findById(idCliente).
                                                orElseThrow(() ->
                                                    new ResponseStatusException(
                                                            HttpStatus.BAD_REQUEST, "Cliente não existe"));
        ServicosPrestados servicosPrestados = new ServicosPrestados();
        servicosPrestados.setDescricao(dto.getDescricao());
        servicosPrestados.setData(data);
        servicosPrestados.setCliente(cliente);
        servicosPrestados.setValor(bigDecimalConverter.converter(dto.getPreco()));
        return servicosPrestadosRepository.save(servicosPrestados);
    }

    @GetMapping
    public List<ServicosPrestados> pesquisar(@RequestParam(value = "nome", required = false, defaultValue = "")
                                                            String nome,
                                             @RequestParam(value = "mes", required = false) Integer mes){
        return servicosPrestadosRepository.findByNomeClienteAndMes("%" + nome + "%", mes);

    }


}
