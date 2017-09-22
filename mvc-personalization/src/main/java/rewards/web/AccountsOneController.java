package rewards.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	/**
	 * Note: Because this method is annotated with @ModelAttribute, Spring MVC
	 * will invoke it before every other request handling method. After
	 * invocation, the method return value will be placed in the model with name
	 * <code>account</code>.
	 */
	@ModelAttribute("account")
	protected Account findAccount(
			@PathVariable("number") String number) {
		// Note: A javax.persistence.NoResultException will be thrown if no account was found
		return rewardsApplicationService.findAccountAndCardsByNumber(number);
	}

	/**
	 * A request handling method for showing an account's details. This method
	 * does not need to find the account because the
	 * {@link #findAccount(String)} method has already done that.
	 */
	@RequestMapping(method=GET)
	public String show() {
		return PATH + "/show";
	}

	/**
	 * A request handling method for showing an account's details in edit mode.
	 * This method does not need to find the account because the
	 * {@link #findAccount(String)} method has already done that.
	 */
	@RequestMapping(method=GET, path="/edit")
	public String edit() {
		return PATH + "/edit";
	}

	@RequestMapping(method=POST)
	public String update(
			@Valid Account account, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return PATH + "/edit";
		}
		rewardsApplicationService.updateAccount(account);
		return "redirect:" + account.getNumber();
	}

}
