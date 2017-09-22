package rewards.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import rewards.application.RewardsApplicationService;
import rewards.domain.model.Account;

@Controller
@RequestMapping("/" + AccountsController.PATH + "/{number}")
public class AccountsOneController {

	public static final String PATH = AccountsController.PATH;

	private RewardsApplicationService rewardsApplicationService;

	@Autowired
	public AccountsOneController(RewardsApplicationService rewardsApplicationService) {
		this.rewardsApplicationService = rewardsApplicationService;
	}
	
	@RequestMapping(method=GET)
	public String show(@PathVariable("number") String number, Model model) {
		model.addAttribute("account",
				rewardsApplicationService.findAccountAndCardsByNumber(number));
		return PATH + "/show";
	}

	// TODO 01: Implement edit account feature
	// GET /accounts/{number} --> GET /accounts/{number}/edit
	// GET /accounts/{number}/edit --> POST /accounts/{number}

	// TODO 01a: Handle GET /{number}/edit and display the account in a <form>
	public String edit() {
		// TODO 01b7: Run and see if the edit form displays correctly
		return PATH + "/edit";
	}

	// TODO 01c: Handle POST /{number}, validate, and update the account
	@RequestMapping(method=POST)
	public String update(
			Account account, BindingResult bindingResult) {
		// For validation, make Spring use Bean Validation API (javax.validation.*).
		// TODO 01e: Show errors on edit page if there are any errors
		// Use <form:errors> tag in the JSP.

		// rewardsApplicationService.updateAccount(account);
		// TODO 01f: After successfully updating the account, *redirect* to show the given account
		return "notsupported";
	}

}
