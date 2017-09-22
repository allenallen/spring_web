package rewards.infrastructure.jpa;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan({ "rewards.application", "rewards.domain.model", "rewards.infrastructure.jpa" })
@EnableAutoConfiguration(exclude={
		WebMvcAutoConfiguration.class, DispatcherServletAutoConfiguration.class })
@EntityScan(basePackages={ "rewards.domain.model", "rewards.infrastructure.jpa" })
public class JpaRepositoryTestsConfig {

}
