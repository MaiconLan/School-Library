package jpautil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class PersistenceUtil {
	private static final String UNIT_NAME = "SchoolLibrary";
	private static final String DATABASE_NAME = "school-library";
	private static EntityManagerFactory FACTORY;
	public static final ThreadLocal<EntityManager> SESSION = new ThreadLocal<EntityManager>();

	public static EntityManager currentEntityManager() {
		EntityManager manager = (EntityManager) SESSION.get();
		if (manager == null) {
			loadInstance();
			manager = FACTORY.createEntityManager();
			SESSION.set(manager);
		}
		return manager;
	}

	public static void closeEntityManager() {
		EntityManager manager = (EntityManager) SESSION.get();
		if (manager != null) {
			manager.close();
		}
		SESSION.set(null);
	}

	private static synchronized void loadInstance() {
		if (FACTORY == null) {
			try {
//				Properties properties = new Properties();
//				FileInputStream fis = new FileInputStream(
//						System.getenv("homepath") + "/schoollibrary/servidor.properties");
//				properties.load(fis);

				// String ip = "jdbc:postgresql://" + properties.getProperty("IP_SERVIDOR") +
				// ":5432/" + DATABASE_NAME;
				String ip = "jdbc:postgresql://localhost:5432/" + DATABASE_NAME;

				Map<String, String> map = new HashMap<String, String>();
				map.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
				map.put("javax.persistence.jdbc.user", "postgres");
				map.put("javax.persistence.jdbc.password", "postgres");
				map.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
				map.put("hibernate.show_sql", "true");

				// if
				// (properties.getProperty("IP_SERVIDOR").equalsIgnoreCase("localhost")
				// ||
				// properties.getProperty("IP_SERVIDOR").equalsIgnoreCase("127.0.0.1"))
				// {
				// map.put("hibernate.hbm2ddl.auto", "update");
				// }

				map.put("hibernate.show_sql", "true");
				map.put("javax.persistence.jdbc.url", ip);

				FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME, map);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}