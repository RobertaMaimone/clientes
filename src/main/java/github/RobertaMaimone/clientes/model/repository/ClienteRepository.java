package github.RobertaMaimone.clientes.model.repository;

import github.RobertaMaimone.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
