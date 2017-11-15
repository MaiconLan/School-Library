package view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.AlunoDao;
import dao.EmailDao;
import dao.EnderecoDao;
import dao.TelefoneDao;
import model.Aluno;
import model.Email;
import model.Endereco;
import model.Telefone;

@ViewScoped
@ManagedBean(name = "alunoWebBean")
public class AlunoWebBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluno aluno;
	private Email email;
	private Telefone telefone;
	private Endereco endereco;
	@Inject
	private AlunoDao alunoDao;
	@Inject
	private EmailDao emailDao;
	@Inject
	private TelefoneDao telefoneDao;
	@Inject
	private EnderecoDao enderecoDao;

	@PostConstruct
	public void initialize() {
		aluno = new Aluno();
		email = new Email();
		telefone = new Telefone();
		endereco = new Endereco();
		alunoDao = new AlunoDao();
	}

	public void adicionarTelefone() {
		telefone.setAluno(aluno);
		aluno.getTelefones().add(telefone);
		telefone = new Telefone();
	}

	public void adicionarEmail() {
		email.setAluno(aluno);
		aluno.getEmails().add(email);
		email = new Email();
	}

	public void adicionarEndereco() {
		endereco.setAluno(aluno);
		aluno.getEnderecos().add(endereco);
		endereco = new Endereco();
	}

	public void salvar() {
		if (aluno.getId_aluno() == null) {
			alunoDao.save(aluno);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Aluno cadastrado com sucesso"));
		} else {
			alunoDao.update(aluno);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Aluno salvo com sucesso"));
		}

		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public final Email getEmail() {
		return email;
	}

	public final void setEmail(Email email) {
		this.email = email;
	}

	public final Telefone getTelefone() {
		return telefone;
	}

	public final void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public final Endereco getEndereco() {
		return endereco;
	}

	public final void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public final AlunoDao getAlunoDao() {
		return alunoDao;
	}

	public final void setAlunoDao(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

}
