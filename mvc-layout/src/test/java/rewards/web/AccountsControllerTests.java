package rewards.web;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.support.BindingAwareModelMap;

import rewards.application.RewardsApplicationService;
import rewards.domain.model.Account;

@RunWith(MockitoJUnitRunner.class)
public class AccountsControllerTests {

	@Mock
	private RewardsApplicationService rewardsApplicationService;
	private AccountsController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new AccountsController(rewardsApplicationService);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void indexFindsAllAccountsAndUsesListView() throws Exception {
		List<Account> accounts = new ArrayList<>();
		when(rewardsApplicationService.findAllAccounts())
			.thenReturn(accounts);
		BindingAwareModelMap model = new BindingAwareModelMap();
		assertEquals("accounts/list", controller.index(model));
		assertTrue(model.containsAttribute("accounts"));
		assertSame(accounts, model.get("accounts"));
	}

}
