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
	
}
