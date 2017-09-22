package rewards.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// TODO 01b: Create a servlet/MVC configuration
// Hint: Use @Configuration
@Configuration
@ComponentScan("rewards.web")
public class RewardsMvcConfig {
	// TODO 01c: Load @Controller beans in the rewards.web package.
	// You'll create some controllers in the subsequent steps.
	// Hint: Use @ComponentScan

	// TODO 02f3: Configure an InternalResourceViewResolver bean
	// Specify the prefix as /WEB-INF/views/
	// and the suffix as .jsp
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	/*
	 * Run your web-app again, you should see your logical view name working
	 * properly.
	 */

	// TODO 02e: Configure messages by adding a ResourceBundleMessageSource bean
	// with an ID of messageSource.
	// Set the base name to "messages". This
	// will load classpath:/messages.properties,
	// classpath:/messages_fr.properties,
	// and so on.
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setBasename("messages");
		// rbms.setBasename("classpath:/messages_fr.properties");
		return rbms;
	}

	// TODO 05: Enable more modern set of MVC beans
	// TODO 05a: Add @EnableWebMvc on this configuration class
	// TODO 05b: Extend this class from WebMvcConfigurerAdapter
	/*
	 * In a previous step, we defined a ViewResolver bean. With @EnableWebMvc and
	 * WebMvcConfigurerAdapter, we can @Override the configureViewResolver(...)
	 * method to configure a InternalResourceViewResolver.
	 */
	// TODO 05c: Override configureViewResolvers() method
	// In the method override, use the registry to add an
	// InternalResourceViewResolver with the desired suffix and prefix.
	// TODO 05d: Remove the @Bean method that creates an
	// InternalResourceViewResolver
	// Now that the configureViewResolvers() method override takes care of creating
	// an InternalResourceViewResolver, we no longer need
	// the @Bean method. If you don't remove the @Bean method,
	// there will be two InternalResourceViewResolver beans configured.

	// TODO 05e: Run the web-app and see that it works.

	// TODO 06: Forward requests to the "default" Servlet
	/*
	 * When running your web-app, you may have noticed the following messages in the
	 * console log:
	 * 
	 * WARN No mapping found for HTTP request with URI
	 * [/mvc-1/webjars/bootstrap/x.y.z/css/bootstrap.min.css] in DispatcherServlet
	 * with name 'dispatcher'
	 * 
	 * WARN No mapping found for HTTP request with URI
	 * [/mvc-1/webjars/bootstrap/x.y.z/js/bootstrap.min.js] in DispatcherServlet
	 * with name 'dispatcher'
	 * 
	 * WARN No mapping found for HTTP request with URI
	 * [/mvc-1/webjars/jquery/a.b.c/jquery.min.js] in DispatcherServlet with name
	 * 'dispatcher'
	 *
	 * Requests for static resources, such as CSS and JS files, are not working.
	 * This is because Spring MVC {@link DispatcherServlet} is mapped to "/". This
	 * mapping overrides the Servlet container's default handling of static
	 * resources. To fix this, we'll need to tell Spring MVC to forward
	 * "not handled" requests to the Servlet container's "default" Servlet.
	 */
	// TODO 06a: Override configureDefaultServletHandling() method in
	// WebMvcConfigurerAdapter
	/*
	 * In the method override, invoke the #enable() method of the "configurer"
	 * parameter. This configures a handler mapping at the lowest precedence, which
	 * effectively allows all other handler mappings to handle the request, and if
	 * none of them do, this handler can forward it to the "default" Servlet.
	 */

	// TODO 06b: Run the web-app and see if the CSS and JS files are loaded

	// TODO 07: Use a view controller for the home page
	/*
	 * The HomePageController does not really do anything. It just forwards to a
	 * view. So, let's use a view controller for this.
	 */
	// TODO 07a: Remove the @Controller annotation from HomePageController class
	/*
	 * This will prevent it from being loaded as a bean. Make sure you don't have
	 * any @Bean methods that instantiate it. You can leave the @RequestMapping
	 * annotations as is. It will not be read (i.e. ignored), since the class is not
	 * a @Controller.
	 */
	// TODO 07b: Override addViewControllers() method in WebMvcConfigurerAdapter
	// sub-class
	/*
	 * In the method override, use the registry parameter to add a view controller
	 * for the "/" URL path, and set its view name to "index" so that it forwards to
	 * /WEB-INF/views/index.jsp (according to the configured view resolver).
	 */
	// TODO 07c: Run the web-app and see that everything works.

}