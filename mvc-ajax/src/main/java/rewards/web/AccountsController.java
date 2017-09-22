package rewards.web;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	protected List<Account> findAllAccounts(boolean fetchCards) {
		return rewardsApplicationService.findAllAccounts(fetchCards);
	}

	@RequestMapping(method=GET)
	public String index(Model model) {
		model.addAttribute("accounts", findAllAccounts(false));
		return PATH + "/list";
	}

	protected List<Account> findAccountsByName(String searchString, boolean fetchCards) {
		return rewardsApplicationService.findAccountsByName(searchString, fetchCards);
	}

	@RequestMapping(method=GET, params={ "searchString" })
	public String search(
			AccountSearchCriteria searchCriteria, BindingResult result, Model model) {
		if (searchCriteria.getSearchString().isEmpty()) {
			return "redirect:" + PATH;
		}
		List<Account> accounts = findAccountsByName(searchCriteria.getSearchString(), false);
		if (accounts.size() == 1) {
			return "redirect:" + PATH + "/" + accounts.get(0).getNumber();
		} else {
			model.addAttribute("accounts", accounts);
			return PATH + "/list";
		}
	}

	@RequestMapping(method=GET, params={ "searchString" }, produces={ APPLICATION_JSON_VALUE })
	public @ResponseBody List<Account> findAccountsByName(
			AccountSearchCriteria searchCriteria, BindingResult result) {
		return findAccountsByName(searchCriteria.getSearchString(), true);
	}

}
