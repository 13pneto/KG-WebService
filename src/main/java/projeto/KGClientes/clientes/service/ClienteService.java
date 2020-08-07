package projeto.KGClientes.clientes.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.KGClientes.clientes.entity.Atualizacao;
import projeto.KGClientes.clientes.entity.Cliente;
import projeto.KGClientes.clientes.repository.ClienteRepository;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRep;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		//if(cliente.getCpf() != null) {
		//	BusinessExceptionCode codigoErro = BusinessExceptionCode.ERR001;
		//	BusinessException b = new BusinessException(codigoErro);
		//	throw b;
		//}
		Cliente c = buscarClienteCNPJ(cliente.getCnpj());
		if(!(c == null)){ //Ja cadastrado (nao nulo)
			//CLIENTE JA CADASTRADO, EXCEPTION
			return null;
		}
		
		return clienteRep.save(cliente);
		
	}
	
	public List<Cliente> listar() {
		return clienteRep.findAll();	
	}
	
	public void excluir(Cliente cliente) {
		clienteRep.delete(cliente);
	}
	
	public Cliente buscarPorId(Integer id) {
		return clienteRep.findById(id).get();
	}
	
	public Cliente buscarClienteCNPJ(String cnpj) { //Busca exata, deve ter o cnpj completo
		return clienteRep.findByCnpj(cnpj);
	}
	
	public Boolean verificaCadastroCliente(String cnpj) {
		Integer retorno = clienteRep.VerificaCadastradoCNPJ(cnpj);
		
		if(retorno == 1) {
			return true;
		}
		return false;
	}
}
