package github.RobertaMaimone.clientes.model.repository;

import github.RobertaMaimone.clientes.model.entity.ServicosPrestados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicosPrestadosRepository extends JpaRepository<ServicosPrestados, Integer> {

    @Query(" select s from ServicosPrestados s join s.cliente c " +
            "where upper( c.nome ) like upper( :nome ) and MONTH(s.data) =:mes  ")
    List<ServicosPrestados> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);
}
