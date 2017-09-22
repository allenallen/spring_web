package rewards.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RewardsMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	// TODO 02: Configure Apache Tiles
	// TODO 02a: Configure a bean that loads definitions for Tiles
	// Note that the following tile definitions have been provided:
	// - /WEB-INF/views/tiles.xml
	// - /WEB-INF/views/accounts/tiles.xml

	// TODO 02b: Configure a view resolver for Tiles

	/*
	 * Note that Spring Boot's default MVC configuration creates
	 * an InternalResourceViewResolver with bean id="defaultViewResolver".
	 * Even though it is not needed when using Apache Tiles,
	 * there's no practical way to remove the "defaultViewResolver"
	 * bean created by Spring Boot's default MVC configuration.
	 *
	 * Both TilesViewResolver and InternalResourceViewResolver use a
	 * default order Ordered.LOWEST_PRECEDENCE (or Integer.MAX_VALUE,
	 * meaning ordered as last). Because of this, it is unpredictable
	 * which one will resolve first. JSP? Or Tiles?
	 * 
	 * It would be best to order the TilesViewResolver just before
	 * the InternalResourceViewResolver by setting its order to
	 * Ordered.LOWEST_PRECEDENCE - 1.
	 */

	// TODO 02c: Run the web-app and see if Tiles views are used
	
}
