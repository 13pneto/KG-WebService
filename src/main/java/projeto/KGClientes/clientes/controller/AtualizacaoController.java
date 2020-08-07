package projeto.KGClientes.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.KGClientes.clientes.entity.Atualizacao;
import projeto.KGClientes.clientes.service.AtualizacaoService;

@RestController
@RequestMapping("/atualizacao")
public class AtualizacaoController {
	
	@Autowired
	private AtualizacaoService atualizacaoService;
	
	@PostMapping(consumes = "application/json")
	public Atualizacao atualizacao(@RequestBody Atualizacao atualizacao) {
		return atualizacaoService.salvar(atualizacao);
	}
	
	@GetMapping(produces = "application/json")
	public List<Atualizacao> listar(){
		return atualizacaoService.listar();
	}
	
	//@GetMapping (value = "/buscarporid/{id}", produces = "application/json")
	//public Atualizacao buscarPorId (@PathVariable Integer id)
	//{
	//	return atualizacaoService.buscarPorId (id);
	//}
	
	@GetMapping (value = "/{id}", produces = "application/json")
	public Atualizacao buscarPorId (@PathVariable Integer id)
	{
		return atualizacaoService.buscarPorId (id);
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")	
	public void excluir(@PathVariable Integer id) {
		atualizacaoService.excluirPorId(id);
	}
}
