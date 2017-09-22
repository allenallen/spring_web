package rewards.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import rewards.application.RewardsApplicationService;

@Controller
@RequestMapping(AccountsController.REQUEST_PATH)
public class AccountsController {

	public static final String REQUEST_PATH = "/accounts";
	public static final String VIEW_NAME_BASE = "accounts/";

	private RewardsApplicationService rewardsApplicationService;

	@Autowired
	public AccountsController(RewardsApplicationService rewardsApplicationService) {
		this.rewardsApplicationService = rewardsApplicationService;
	}

	@RequestMapping(method=GET)
	public String index(Model model) {
		model.addAttribute("accounts",
				rewardsApplicationService.findAllAccounts());
		return VIEW_NAME_BASE + "list";
	}

	@RequestMapping(method=GET, path="/{accountNumber}")
	public String show(@PathVariable("accountNumber") String accountNumber, Model model) {
		model.addAttribute("account",
				rewardsApplicationService.findAccountAndCardsByNumber(accountNumber));
		return VIEW_NAME_BASE + "show";
	}

}
