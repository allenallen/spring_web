package rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * TODO 01: Launch this web app.
 * </p>
 * Go to the "View Account List" page. You should reach the list of accounts. If
 * the application is not working, please ask your instructor for help.
 */

// TODO 02: Let Spring Boot enable Spring Security for you.
// This is done by removing "exclude=SecurityAutoConfiguration.class" below!
/*
 * Remember that the single `@SpringBootApplication` annotation is a
 * meta-annotation combining the: `@Configuration`, `@EnableAutoConfiguration`,
 * and `@ComponentScan` annotations.
 */
// @EnableAutoConfiguration
// @Configuration
// @ComponentScan
@SpringBootApplication
public class RewardsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RewardsApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RewardsApplication.class);
	}

}
