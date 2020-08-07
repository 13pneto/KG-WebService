package projeto.KGClientes.clientes.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "TB_Cliente")
public class Cliente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_clientes")
	@SequenceGenerator(name = "sequence_id_clientes", sequenceName = "sequence_cliente", allocationSize = 1)
	//allocationSize = força o id gerar de 1 em 1
	@Column(name = "IdCliente")
	private Integer IdCliente;
	
	@Column(name = "CNPJ", unique = true)
	private String Cnpj = "";
	
	@Column(name = "Filial")
	private String Filial = "";
		
	@Column(name = "RazaoSocial")
	private String RazaoSocial = "";

	@Column(name = "NomeFantasia")
	private String NomeFantasia = "";
	
	@Column(name = "CodClienteSG", unique = false)
	private String CodClienteSG = "";
	
	@Column(name = "Status")
	private Boolean Status = true;
	
	@Column(name = "CriadoEm")
	private String CriadoEm;
	
	//Atributo responsavel por armazenar o horario do arquivo 
	//Parame.ini, comando linux (stat -c %Y), caso o horario
	//gravado nesta variavel seja diferente do horario que o
	//script enviar, grava uma nova atualizacao.
	@Column(name = "Modificado")
	private String Modificado;
	
	public Cliente() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //Padrão da data
		Date data = new Date(); 
		CriadoEm = sdf.format(data); //Converte a data para String
	}
	
	
	//---------GETTERS AND SETTERS-------------//
	

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return RazaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return NomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	public String getCriadoEm() {
		return CriadoEm;
	}

	public void setCriadoEm(String criadoEm) {
		CriadoEm = criadoEm;
	}


	public String getFilial() {
		return Filial;
	}


	public void setFilial(String filial) {
		Filial = filial;
	}


	public String getCodClienteSG() {
		return CodClienteSG;
	}


	public void setCodClienteSG(String codClienteSG) {
		CodClienteSG = codClienteSG;
	}


	public String getModificado() {
		return Modificado;
	}


	public void setModificado(String modificado) {
		Modificado = modificado;
	}
	
	
	
	
}
