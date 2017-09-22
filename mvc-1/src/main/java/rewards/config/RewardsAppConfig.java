package rewards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "rewards.application", "rewards.domain.model", "rewards.infrastructure.jpa" })
@EnableTransactionManagement
public class RewardsAppConfig {

	/**
	 * Adds a bean post processor that enables automatic
	 * persistence exception translation to classes marked
	 * with @Repository annotation.
	 *
	 * @return persistence exception translation
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor
			persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
