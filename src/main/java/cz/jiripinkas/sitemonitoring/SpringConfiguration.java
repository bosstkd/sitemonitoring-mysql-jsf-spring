package cz.jiripinkas.sitemonitoring;

import com.zaxxer.hikari.HikariConfig;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
@ComponentScan
@EnableTransactionManagement
@EnableJpaRepositories
public class SpringConfiguration {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");
		jpaProperties.put("hibernate.show_sql", "true");
		// jpaProperties.put("hibernate.format_sql", "true");
		entityManagerFactory.setJpaProperties(jpaProperties);
		entityManagerFactory.setPackagesToScan("cz.jiripinkas.sitemonitoring.entity");
		entityManagerFactory
				.setPersistenceProvider(new HibernatePersistenceProvider());
		return entityManagerFactory;
	}

	@Bean
	public JpaTransactionManager transactionManager(DataSource dataSource,
			EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(
				entityManagerFactory);
		transactionManager.setDataSource(dataSource);
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
            
              // String configFile = "src/main/resources/db.properties";
                HikariConfig cfg = new HikariConfig();
                
                cfg.setJdbcUrl("jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
                cfg.setUsername("Amine");
                cfg.setPassword("S2flvjj333@123");
                
                
		HikariDataSource dataSource = new HikariDataSource(cfg);
               
                /*
		dataSource.setJdbcUrl("jdbc:hsqldb:mem:test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
                */
		return dataSource;
	}

}
