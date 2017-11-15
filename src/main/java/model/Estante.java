package model;

import java.util.List;

import javax.persistence.CascadeType;
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
	private Long id_estante;

	private String descricao;
	private String posicao_horizontal;

	private String posicao_vertical;

	@OneToMany(mappedBy = "estante", targetEntity = Livro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Livro> livros;

	public Long getId_estante() {
		return id_estante;
	}

	public void setId_estante(Long id_estante) {
		this.id_estante = id_estante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPosicao_horizontal() {
		return posicao_horizontal;
	}

	public void setPosicao_horizontal(String posicao_horizontal) {
		this.posicao_horizontal = posicao_horizontal;
	}

	public String getPosicao_vertical() {
		return posicao_vertical;
	}

	public void setPosicao_vertical(String posicao_vertical) {
		this.posicao_vertical = posicao_vertical;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
