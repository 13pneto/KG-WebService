package projeto.KGClientes.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.KGClientes.clientes.entity.Atualizacao;
import projeto.KGClientes.clientes.entity.Cliente;

public interface AtualizacaoRepository extends JpaRepository<Atualizacao, Integer> {

	//Encontra pela coluna "MODIFICADO"
	@Query(value = "SELECT * FROM tb_atualizacao a where a.modificado = :modificado", nativeQuery = true)
	public Atualizacao findByModificado(@Param("modificado") String modificado);
	
	//@Query(value = "SELECT * FROM tb_cliente c where c.cnpj = :cnpj", nativeQuery = true)
	//public Cliente findByCnpj(@Param("cnpj") String cnpj);
}
