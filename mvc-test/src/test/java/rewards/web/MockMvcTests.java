package rewards.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Tests using Spring's MockMVC framework. This drives an MVC application in a
 * test, as if it was running in a container, so far more checks are possible
 * than with the simple {@link AccountsControllerTests}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest // finds and uses RewardsApplication as the context configuration
// TODO 01: Make this test load a WebApplicationContext
@SuppressWarnings("unused")
public class MockMvcTests {

	// TODO 02: Pull in the application context created by @ContextConfiguration
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		// TODO 03: Setup MockMVC to use our Spring Configuration
	}

	/**
	 * Test a GET to /accounts (note the URL is relative to the servlet
	 * context - hence /accounts instead of /mvc-test/accounts). We
	 * tell the request that we will accept HTML then run the request by calling
	 * {@link MockMvc#perform(org.springframework.test.web.servlet.RequestBuilder)}.
	 * <p>
	 * We can tell MockMVC what we expect in the response: status OK, a model
	 * containing one attribute that should be called "accounts" and rendered by
	 * forwarding to "/WEB-INF/views/accounts/list.jsp" (note that this is always
	 * the full path to the JSP, even when using a View Resolver).
	 * 
	 * @throws Exception
	 *             If anything fails.
	 */
	@Test
	public void getAccountsTest() throws Exception {
		// TODO 04: Use Spring Mock MVC to perform the test and expect a response
		// See javadoc of this test method
		
		// this.mockMvc.perform(...).andExpect(...)

		// When done, run this test and see it pass.
	}

	/**
	 * Test a GET to /accounts/{id} (note the URL is relative to the servlet
	 * context - hence /accounts/{id} instead of /mvc-test/accounts/{id}).
	 * <p>
	 * We tell the request that we will accept HTML and specify the {id}
	 * URI path variable to be set to "123456003". Finally we run the request by
	 * invoking
	 * {@link MockMvc#perform(org.springframework.test.web.servlet.RequestBuilder)}.
	 * <p>
	 * We can tell MockMVC what we expect in the response: status OK, a model
	 * containing one attribute that should be called "account" and rendered by
	 * forwarding to "/WEB-INF/views/accountDetails.jsp" (note that this is
	 * always the full path to the JSP, even when using a View Resolver).
	 * 
	 * @throws Exception
	 *             If anything fails.
	 */
	@Test
	public void getAccountTest() throws Exception {
		// TODO 05: Use Spring Mock MVC to perform the test and expect a response
		// See javadoc of this test method

		// When done, run this test and see it pass.
	}

}
