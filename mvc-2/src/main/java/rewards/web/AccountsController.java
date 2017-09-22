package rewards.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rewards.application.RewardsApplicationService;

// TODO 03: Implement account listing page
// TODO 03a: Annotate the class to be a controller in Spring MVC
@Controller
public class AccountsController {

	@SuppressWarnings("unused")
	private RewardsApplicationService rewardsApplicationService;

	@Autowired
	public AccountsController(RewardsApplicationService rewardsApplicationService) {
		this.rewardsApplicationService = rewardsApplicationService;
	}

	// TODO 03b: Define method that maps to GET "/accounts"
	// Since we've mapped the DispatcherServlet to "/", this controller
	// will be invoked when you use the "/accounts" URL.
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("accounts", rewardsApplicationService.findAllAccounts());
		return "accounts/list";
	}

	// TODO 03c: Delegate to a RewardsApplicationService to find the list of
	// accounts
	// Prepare the model attributes to be used by the view.
	// TODO 03d: Use the "list" view to render list of accounts
	// The JSP view /WEB-INF/views/accounts/list.jsp has already been created for
	// you.
	// TODO 03e: Run the web-app and see if accounts listing displays correctly

	/*
	 * TODO 03f: Pause before continuing After completing step 03, pause for a
	 * while. Some more lecture will be provided, after which you can continue with
	 * the step 04 and so on.
	 */

	// TODO 04 Implement account details page
	// TODO 04a: Define method that maps to GET "/accounts/{accountNumber}"
	// The {accountNumber} is a path variable.
	// TODO 04b: Delegate to a RewardsApplicationService to find the account
	// Prepare the model attributes to be used by the view.
	// TODO 04c: Use the "show" view to render list of accounts
	// The JSP view /WEB-INF/views/accounts/show.jsp has already been created for
	// you.
	// TODO 04d: Run the web-app and click on a specific account on the accounts
	// listing page
	@RequestMapping(value = "/accounts/{accountNumber}", method = RequestMethod.GET)
	public String getAccount(@PathVariable String accountNumber, Model model) {
		model.addAttribute("account", rewardsApplicationService.findAccountByNumber(accountNumber));
		return "accounts/show";
	}

}
