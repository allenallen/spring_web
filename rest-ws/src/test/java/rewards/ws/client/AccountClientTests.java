package rewards.ws.client;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import rewards.domain.model.Account;

// TODO 00a: Study the tests here.
/*
 * The tests here will require the webapp to be running.
 * The webapp will provide the web services that the
 * client here will consume.
 */
// TODO 00b: Use TCP/IP Monitor to see actual JSON when running tests.
/*
 * Whether your test ran OK or not, there's not much to see when you run it.
 * When writing web services or web services clients, it's useful to see what
 * JSON is actually sent from the client to the server and vice versa. Eclipse
 * has a built-in tool called TCP/IP Monitor (part of Eclipe's Web Tools
 * Plugin). It is a view that you can add to your perspective.
 * 
 * To show the view, go to "Window" > "Show View" > "Other...". Search for
 * "TCP/IP" and select "TCP/IP Monitor".
 * 
 * In the said view, click the small arrow pointing downwards and choose
 * "Properties".
 * 
 * Choose "Add..." to add a new monitor. As local monitoring port, enter 8081
 * since this port is probably unused. As host name, enter "localhost" and as
 * port enter 8080 since this it the port that Tomcat is running on. Press OK
 * and then press "Start" to start the newly defined monitor.
 * 
 * Now open the configuration and change the port number in the request URL from
 * 8080 to 8081. This ensures that the request will go through our monitor,
 * which will log and forward it to the server. The response will follow the
 * same route back from the server to the client. Run the test again. Now switch
 * to the Monitor view: you should see one request and response passing by. If
 * you change the pulldowns from "Byte" to "XML", the view will render the
 * messages in a more readable way.
 * 
 * This is an excellent tool to help you to debug your web services: if there
 * was an error when running your test, try to fix it now using the monitor as a
 * tool to see what the actual request and response are holding.
 */
public class AccountClientTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * server URL ending with the servlet mapping on which the application can be reached.
	 */
	private static final String BASE_URL = "http://localhost:8080/rest-ws/accounts";

	private RestTemplate restTemplate = new RestTemplate();
	private Random random = new Random();
	
	@SuppressWarnings("unused")
	@Test
	public void listAccounts() {
		// TODO 01: Retrieve a list of accounts
		// TODO 01a: Use the restTemplate to retrieve an array containing all Account instances
		Account[] accounts = null;
		/*
		 * After doing so, start the webapp and run this test.
		 * You will see that since the server is *not* yet returning JSON,
		 * you will get an error.
		 *
		 * Proceed to the next step (01b) to enable the server to return JSON.
		 */

		assertNotNull(accounts);
		assertTrue(accounts.length > 1);
	}

	@SuppressWarnings("unused")
	@Test
	public void getAccount() {
		// TODO 02: Retrieve a single account
		// TODO 02a: Use the restTemplate to retrieve the Account with accountNumber 8861888 using a URI template
		Account account = null;
		/*
		 * After doing so, check to see if the webapp is started, and run this test.
		 * You will see that since the server is *not* yet returning JSON,
		 * you will get an error.
		 *
		 * Proceed to the next step (02b) to enable the server to return JSON.
		 */

		assertNotNull(account);
		assertEquals("Juan Dela Cruz", account.getName());
		assertEquals(1, account.getCards().size());
		assertEquals(BigDecimal.ZERO, account.getTotalPoints());
	}

	@Test
	public void createAccount() {
		// use a unique number to avoid conflicts
		String number = String.format("22345%4d", random.nextInt(10000));
		Account account = new Account(number, "John Doe");
		account.setDateOfBirth(new GregorianCalendar(1989, Calendar.MARCH, 15).getTime());
		account.addCard("555588889999");

		// TODO 03a: Create a new Account by POSTing to the right URL and store its location in a variable

		// TODO 03d: Retrieve the Account you just created from the location that was returned
		Account retrievedAccount = null;

		assertNotNull(retrievedAccount);
	}

	@Test
	public void getNonExistingAccount() throws Exception {
		// TODO 05a (BONUS): Try to retrieve a non-existing account. This should give a 404 Not Found.
		// Proceed to next step (05b) to have server handle this and return a 404.
		try {
			String url = BASE_URL + "/{accountNumber}";
			restTemplate.getForObject(url, Account.class, "8861xxx");
			fail("Should have received 404 Not Found");
		} catch (HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
	}
	
	@Test
	public void createAndDeleteAccount() throws Exception {
		// TODO 04: Create and delete an account (proceed to next step, 04a)

		Account account = new Account("98765432x", "Jane Doe");
		account.setDateOfBirth(new GregorianCalendar(1989, Calendar.MARCH, 15).getTime());
		// TODO 04a: Create a new account with number "98765432x" and store its location in a variable
		
		// TODO 04b: Retrieve the account you just created from the location that was returned
		// Account retrievedAccount = null;

		// TODO 04c: Delete the new account

		// TODO 05c (BONUS): Try to retrieve the deleted account again. This should give a 404 Not Found
	}

}
