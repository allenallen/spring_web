package rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

// TODO 01: Run this webapp and see that everything is in order.
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
