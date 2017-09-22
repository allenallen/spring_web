package rewards.application;

import java.util.List;

import rewards.domain.model.Account;

public interface RewardsApplicationService {
	
	RewardConfirmation rewardAccountFor(Purchase purchase);

	List<Account> findAllAccounts();

	List<Account> findAllAccounts(boolean fetchCards);

	Account findAccountByNumber(String accountNumber);

	Account findAccountByNumber(String accountNumber, boolean fetchCards);

	void updateAccount(Account account);

	List<Account> findAccountsByName(String searchString);

	List<Account> findAccountsByName(String searchString, boolean fetchCards);

}
