package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "email")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_email")
	private Long idEmail;

	private String email;

	@ManyToOne(fetch = FetchType.LAZY)  
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	public final Long getIdEmail() {
		return idEmail;
	}

	public final void setIdEmail(Long idEmail) {
		this.idEmail = idEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return email;
	}

}
