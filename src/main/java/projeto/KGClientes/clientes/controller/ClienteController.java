package projeto.KGClientes.clientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.KGClientes.clientes.entity.Cliente;
import projeto.KGClientes.clientes.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(consumes = "application/json")
	public Cliente cliente(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@GetMapping(produces = "application/json")
	public List<Cliente> listar(){
		return clienteService.listar();
	}
	
	@GetMapping (value = "/buscarporcnpj/{cnpj}", produces = "application/json")
	public Cliente buscarPorCnpj (@PathVariable String cnpj)
	{
		return clienteService.buscarClienteCNPJ(cnpj);
	}
	
	@GetMapping (value = "/verificaCadastro/{cnpj}", produces = "application/json")
	public Boolean verificaCadastro (@PathVariable String cnpj)
	{
		return clienteService.verificaCadastroCliente(cnpj);
	}
	

}
