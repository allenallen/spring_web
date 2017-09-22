package rewards.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import rewards.application.RewardsApplicationService;

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

	// TODO 02: Implement search account (by name) feature
	// GET /accounts?searchString=xxx
	/*
	 * Use the AccountSearchCriteria bean and bind the form to it.
	 * Note that one method should handle a request where there is
	 * no "searchString" parameter, while the new method you are
	 * going to add should handle a request with a "searchString"
	 * parameter.
	 * 
	 * The new method will use the same "list" view.
	 * 
	 * Some snippets have been commented out in list.jsp. Uncomment
	 * them to have the search form displayed. Note that the form
	 * will expect an AccountSearchCriteria model attribute.
	 */
	
		// TODO 02a: If the returned matches contains only one account, redirect to display it, rather than rendering a list
	
}
