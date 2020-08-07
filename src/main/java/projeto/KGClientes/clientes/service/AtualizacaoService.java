package projeto.KGClientes.clientes.service;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.KGClientes.clientes.entity.Atualizacao;
import projeto.KGClientes.clientes.entity.Cliente;
import projeto.KGClientes.clientes.repository.AtualizacaoRepository;
import projeto.KGClientes.clientes.repository.ClienteRepository;



@Service
public class AtualizacaoService {

	@Autowired
	private AtualizacaoRepository atualizacaoRep;
	
	@Autowired
	private ClienteService clienteServ;
	
	@Transactional
	public Atualizacao salvar(Atualizacao atualizacao) {
		String modificadoTemp = atualizacao.getCliente().getModificado();
		
		Cliente c = clienteServ.buscarClienteCNPJ(atualizacao.getCliente().getCnpj());
		
		if(c == null) 
		{
			//Cliente não encontrado, cadastrar.
			c = clienteServ.salvar(c);			
			atualizacaoRep.save(atualizacao);
		}
		else 
		{
			//Setar o cliente ja cadastrado na atualização atual
			atualizacao.setCliente(c);
			
			if(c.getModificado().equals(modificadoTemp)) 
			{
				//Modificação igual, não salvar uma atualização
				
				//Throw Exception - Atualização não necessário, campo modificado igual!
				
			}
			else 
			{
				return atualizacaoRep.save(atualizacao);
			}
		}
		return atualizacao;
	}
	
	public List<Atualizacao> listar() {
		return atualizacaoRep.findAll();	
	}
	
	public void excluir(Atualizacao cliente) {
		atualizacaoRep.delete(cliente);
	}
	
	public Atualizacao buscarPorId(Integer id) {
		return atualizacaoRep.findById(id).get();
	}
	
	public void excluirPorId(Integer id) {
		atualizacaoRep.deleteById(id);
	}
	
	//public Cliente buscarClienteCNPJ(String cnpj) { //Busca exata, deve ter o cnpj completo
	//	return atualizacaoRep.findByCnpj(cnpj);
	//}
}
