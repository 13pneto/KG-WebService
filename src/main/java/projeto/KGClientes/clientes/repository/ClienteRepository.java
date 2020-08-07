package projeto.KGClientes.clientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.KGClientes.clientes.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(value = "SELECT * FROM tb_cliente c where c.cnpj = :cnpj", nativeQuery = true)
	public Cliente findByCnpj(@Param("cnpj") String cnpj);
	
	@Query(value = "SELECT * FROM tb_cliente c where c.idCliente = :id", nativeQuery = true)
	public Cliente findByIdCliente(@Param("id") Integer id);
	
	@Query(value = "SELECT COUNT(*) FROM tb_cliente c where c.cnpj = :cnpj", nativeQuery = true)
	public Integer VerificaCadastradoCNPJ(@Param("cnpj") String cnpj);
}
