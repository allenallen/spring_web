package rewards.application;

import java.util.List;

import rewards.domain.model.Account;

public interface RewardsApplicationService {
	
	RewardConfirmation rewardAccountFor(Purchase purchase);

	List<Account> findAllAccounts();

	List<Account> findAllAccounts(boolean fetchCards);

	Account findAccountByNumber(String accountNumber);

	Account findAccountAndCardsByNumber(String accountNumber);
	
	void updateAccount(Account account);

}
