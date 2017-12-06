package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "aluguel")
public class Aluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluguel")
	private Long idAluguel;

	private Double multa;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_retirada")
	private Date dataRetirada;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_devolucao")
	private Date dataDevolucao;

	@ManyToOne(fetch = FetchType.LAZY)
	private Aluno aluno;

	@ManyToOne(fetch = FetchType.LAZY)
	private Livro livro;

	public final Long getIdAluguel() {
		return idAluguel;
	}

	public final void setIdAluguel(Long idAluguel) {
		this.idAluguel = idAluguel;
	}

	public final Double getMulta() {
		return multa;
	}

	public final void setMulta(Double multa) {
		this.multa = multa;
	}

	public final Date getDataRetirada() {
		return dataRetirada;
	}

	public final void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public final Date getDataDevolucao() {
		return dataDevolucao;
	}

	public final void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public final Aluno getAluno() {
		return aluno;
	}

	public final void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public final Livro getLivro() {
		return livro;
	}

	public final void setLivro(Livro livro) {
		this.livro = livro;
	}

}
