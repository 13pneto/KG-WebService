package projeto.KGClientes.clientes.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Atualizacao")
public class Atualizacao{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_atualizacao")
	@SequenceGenerator(name = "sequence_id_atualizacao", sequenceName = "sequence_id_atualizacao", allocationSize = 1)
	@Column(name = "IdAtualizacao")
	private Integer IdAtualizacao;
	
	@JoinColumn(name = "FK_Cliente")
	@ManyToOne
	private Cliente Cliente;
		
	@Column(name = "Revisao")
	private String Revisao;

	@Column(name = "UltimaAtualizacao")
	private String Ultatuali;
	
	@Column(name = "DataVersao")
	private String Dataversao;
	
	@Column(name = "NomeVersao")
	private String Nomeversao;
	
	@Column(name = "DataCompilacao")
	private String Datacompilacao;
	
	@Column(name = "HoraCompilacao")
	private String Horacompilacao;
	
	@Column(name = "RevisaoIndiceTabelas")
	private String Revisaoindicestabelas;
	
	@Column(name = "CriadoEm")
	private String CriadoEm;
	
	public Atualizacao() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //Padrão da data
		Date data = new Date(); 
		CriadoEm = sdf.format(data); //Converte a data para String
	}
	
	
	//---------GETTERS AND SETTERS-------------//

	public Integer getIdCliente() {
		return IdAtualizacao;
	}

	public void setIdCliente(Integer idCliente) {
		IdAtualizacao = idCliente;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	public String getRevisao() {
		return Revisao;
	}

	public void setRevisao(String revisao) {
		Revisao = revisao;
	}

	public String getUltatuali() {
		return Ultatuali;
	}

	public void setUltatuali(String ultatuali) {
		Ultatuali = ultatuali;
	}

	public String getDataversao() {
		return Dataversao;
	}

	public void setDataversao(String dataversao) {
		Dataversao = dataversao;
	}

	public String getNomeversao() {
		return Nomeversao;
	}

	public void setNomeversao(String nomeversao) {
		Nomeversao = nomeversao;
	}

	public String getDatacompilacao() {
		return Datacompilacao;
	}

	public void setDatacompilacao(String datacompilacao) {
		Datacompilacao = datacompilacao;
	}

	public String getHoracompilacao() {
		return Horacompilacao;
	}

	public void setHoracompilacao(String horacompilacao) {
		Horacompilacao = horacompilacao;
	}

	public String getRevisaoindicestabelas() {
		return Revisaoindicestabelas;
	}

	public void setRevisaoindicestabelas(String revisaoindicestabelas) {
		Revisaoindicestabelas = revisaoindicestabelas;
	}

	public String getCriadoEm() {
		return CriadoEm;
	}

	public void setCriadoEm(String criadoEm) {
		CriadoEm = criadoEm;
	}


	public Integer getIdAtualizacao() {
		return IdAtualizacao;
	}


	public void setIdAtualizacao(Integer idAtualizacao) {
		IdAtualizacao = idAtualizacao;
	}
}
	
	