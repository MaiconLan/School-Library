package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estante")
public class Estante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estante")
	private Long idEstante;

	private String descricao;

	@Column(name = "posicao_horizontal")
	private String posicaoHorizontal;

	@Column(name = "posicao_vertical")
	private String posicaoVertical;

	@OneToMany(mappedBy = "estante", targetEntity = Livro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Livro> livros;

	public final Long getIdEstante() {
		return idEstante;
	}

	public final void setIdEstante(Long idEstante) {
		this.idEstante = idEstante;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public final String getPosicaoHorizontal() {
		return posicaoHorizontal;
	}

	public final void setPosicaoHorizontal(String posicaoHorizontal) {
		this.posicaoHorizontal = posicaoHorizontal;
	}

	public final String getPosicaoVertical() {
		return posicaoVertical;
	}

	public final void setPosicaoVertical(String posicaoVertical) {
		this.posicaoVertical = posicaoVertical;
	}

	public final List<Livro> getLivros() {
		return livros;
	}

	public final void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
