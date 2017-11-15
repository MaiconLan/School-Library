package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.flywaydb.core.Flyway;

import utils.Constante;

public class IniciarAplicacaoListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Contexto Destruido");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Contexto Iniciado");
		iniciaFlyaway();
	}

	public void iniciaFlyaway() {
		try {
			Flyway flyway = new Flyway();
			flyway.setDataSource("jdbc:postgresql://" + Constante.IP_BASE_DADOS + "/" + Constante.NOME_BASE_DADOS,
					"postgres", "postgres");
			flyway.setLocations("classpath:flyway");
			flyway.setInstalledBy("sistema");
			flyway.setTable("versao_base");
			flyway.migrate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
