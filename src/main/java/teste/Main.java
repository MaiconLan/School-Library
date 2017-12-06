package teste;

import business.AlunoBusiness;
import model.Aluno;

public class Main {

	public static void main(String[] args) {

		AlunoBusiness a = new AlunoBusiness();
		Aluno filtro = new Aluno();
		filtro.setIdAluno(1L);
		
		for (Aluno aa : a.listaAluno(filtro)) {
			System.out.println("------------------ID------------------");
			System.out.println(aa);
			System.out.println("--------------------------------------");
		}
		
		filtro = new Aluno();
		filtro.setNome("Maicon");
		for (Aluno aa : a.listaAluno(filtro)) {
			System.out.println("-----------------NOME----------------");
			System.out.println(aa);
			System.out.println("--------------------------------------");
		}

	}

}
