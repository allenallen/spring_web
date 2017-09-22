package rewards.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class RewardsMvcConfig extends WebMvcConfigurerAdapter {

	// TODO 01: Run the web-app and see the links to change locale/language and theme
	/*
	 * These links won't work yet, since there are no interceptors that detect
	 * changes to either theme or locale/language. Go ahead, and proceed with
	 * next steps.
	 */


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(
				"/WEB-INF/views/tiles.xml",
				"/WEB-INF/views/accounts/tiles.xml");
		return configurer;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		// This allows access to ${requestContext.theme.name} from a Tiles view
		viewResolver.setRequestContextAttribute("requestContext");
		viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE - 1);
		return viewResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO 02: Add configuration for a ThemeChangeInterceptor
		/*
		 * After adding a ThemeChangeInterceptor and redeploying your changes,
		 * try switching to the "blue" theme. This time you will get an
		 * exception. Verify the exception occurred because the new interceptor
		 * detected the theme and tried to store it but failed to do so. This is
		 * because the default FixedThemeResolver *does not* support storing and
		 * hence switching themes.
		 * 
		 * Go ahead, and proceed to 02a to add a ThemeResolver that *supports*
		 * storing changes.
		 */

		// TODO 03: Add configuration for a LocaleChangeInterceptor
		/*
		 * The configuration required for changing locales is very similar to
		 * themes. Spring Boot, based on some properties, adds a CharacterEncodingFilter. This
		 * filter ensures the response is encoded as UTF-8 enabling the display
		 * of international characters. The application.properties has been
		 * modified to enable HTTP encoding. Please check it out.
		 *
		 * Now proceed with adding a LocaleChangeInterceptor.
		 */
	}

	// TODO 02a: Add configuration for a CookieThemeResolver
	/*
	 * Set the default theme name to "orange".
	 * 
	 * When done, redeploy your changes, and try switching themes. You won't see
	 * much visual changes, since we have *not* made our views use "theme"
	 * properties. That's what you will do in the next step (02b).
	 */

	// TODO 03a: Add configuration for a CookieLocaleResolver
	/*
	 * Set the default locale to "en".
	 * 
	 * Remember that this bean must have a specific id for it to be discovered
	 * by the DispatcherServlet. When the changes have published, test the
	 * language link at the top. You should be able to successfully switch
	 * between English and French.
	 * 
	 * The I18N is made possible due to the presence of messages*.properties (in
	 * src/main/resources). These have been provided for you.
	 */

}
