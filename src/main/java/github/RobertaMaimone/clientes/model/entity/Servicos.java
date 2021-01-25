package github.RobertaMaimone.clientes.model.entity;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn
    private  Cliente cliente;

    @Column
    private BigDecimal valor;

    public Servicos() {}

    public Servicos(Integer id, String descricao, Cliente cliente, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servicos servicos = (Servicos) o;
        return id.equals(servicos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Servicos{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", cliente=" + cliente +
                ", valor=" + valor +
                '}';
    }

}
