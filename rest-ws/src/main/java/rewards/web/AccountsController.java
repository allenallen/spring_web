package rewards.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import rewards.application.RewardsApplicationService;
import rewards.domain.model.Account;

@Controller
@RequestMapping("/" + AccountsController.PATH)
public class AccountsController {

	public static final String PATH = "accounts";

	private RewardsApplicationService rewardsApplicationService;

	@Autowired
	public AccountsController(RewardsApplicationService rewardsApplicationService) {
		this.rewardsApplicationService = rewardsApplicationService;
	}

	@ModelAttribute
	protected AccountSearchCriteria getSearchCriteria() {
		return new AccountSearchCriteria();
	}

	@RequestMapping(method=GET)
	public String index(Model model) {
		model.addAttribute("accounts",
				rewardsApplicationService.findAllAccounts());
		return PATH + "/list";
	}

	@RequestMapping(method=GET, params={ "searchString" })
	public String search(
			AccountSearchCriteria searchCriteria, BindingResult result, Model model) {
		if (searchCriteria.getSearchString().isEmpty()) {
			return "redirect:" + PATH;
		}
		List<Account> accounts = rewardsApplicationService.findAccountsByName(
				searchCriteria.getSearchString());
		if (accounts.size() == 1) {
			return "redirect:" + PATH + "/" + accounts.get(0).getNumber();
		} else {
			model.addAttribute("accounts", accounts);
			return PATH + "/list";
		}
	}

	// TODO 01b: Add method to return all accounts for RESTful client expecting JSON
	/*
	 * When doing so, note that the #index() method already handles "GET /accounts".
	 */

	// TODO 03b: Add method to POST to /accounts containing a marshalled Account
	//           and return a 201 Created status
	// Use accountRepository#save(Account) to save the account.
	// TODO 03c: Include "Location" header with URI of created resource in the response

	// TODO 06 (BONUS): Return 409 Conflict when creating an account with an existing number
	// Edit AccountClientTests#createAccount so that it uses a fixed account number like "123123123".
	// The first time you run #createAccount it will succeed.
	// The second time you run #createAccount it will fail with a 500 Internal Server Error.
	// This is caused by a DataIntegrityViolationException.
	// This is not really a server error. This is caused by the client trying to create an
	// account with a number that already exists.
	// To properly indicate this to the client, a 409 Conflict should be returned.
	// Modify AccountsController to do so.

}
