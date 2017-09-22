package rewards.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class InfrastructureConfig {
	
	/**
	 * Creates an in-memory "rewards" database populated 
	 * with test data for fast testing
	 */
	@Bean
	public DataSource dataSource(){
		return
			(new EmbeddedDatabaseBuilder())
			.addScript("classpath:rewards/schema.sql")
			.addScript("classpath:rewards/test-data.sql")
			.build();
	}	
	
	
	/**	
	 * LocalContainerEntityManagerFactoryBean. 
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabase(Database.HSQL);

		Properties props = new Properties();
		props.setProperty("hibernate.format_sql", "true");
		
		LocalContainerEntityManagerFactoryBean emfb = 
			new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource());
		emfb.setPackagesToScan("rewards.domain.model", "rewards.infrastructure.jpa");
		emfb.setJpaProperties(props);
		emfb.setJpaVendorAdapter(adapter);
		
		return emfb;
	}


	/**	
	 * JpaTransactionManager. 
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
