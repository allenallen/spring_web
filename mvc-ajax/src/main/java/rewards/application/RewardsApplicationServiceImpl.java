package rewards.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import rewards.domain.model.Account;
import rewards.domain.model.AccountRepository;
import rewards.domain.model.Merchant;
import rewards.domain.model.MerchantRepository;
import rewards.domain.model.RewardPoints;
import rewards.domain.model.RewardRepository;

@Component
@Transactional
public class RewardsApplicationServiceImpl implements RewardsApplicationService {

	private AccountRepository accountRepository;
	private MerchantRepository merchantRepository;
	private RewardRepository rewardRepository;

	@Autowired
	public RewardsApplicationServiceImpl(
			AccountRepository accountRepository,
			MerchantRepository merchantRepository,
			RewardRepository rewardRepository) {
		super();
		this.accountRepository = accountRepository;
		this.merchantRepository = merchantRepository;
		this.rewardRepository = rewardRepository;
	}

	@Override
	public RewardConfirmation rewardAccountFor(Purchase purchase) {
		// 1. Retrieve the account by cardNumber
		Account account = accountRepository.findByCardNumber(purchase.getCardNumber());
		// 2. Retrieve the merchant by number
		Merchant merchant = merchantRepository.findByNumber(purchase.getMerchantNumber());
		// 3. Calculate reward for purchase (based on merchant's policies)
		RewardPoints pointsEarned = merchant.calculateRewardPointsFor(purchase.getAmount());
		// 4. Credit the account
		account.credit(pointsEarned);
		String confirmationNumber = rewardRepository.confirmReward(
				account.getNumber(),
				purchase.getCardNumber(),
				purchase.getMerchantNumber(),
				purchase.getAmount(), purchase.getDate(),
				pointsEarned);
		return new RewardConfirmation(
				confirmationNumber,
				account.getNumber(),
				pointsEarned.getValue(),
				account.getTotalPoints());
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAllAccounts() {
		return findAllAccounts(false);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAllAccounts(boolean fetchCards) {
		return accountRepository.findAll(fetchCards);
	}

	@Transactional(readOnly=true)
	@Override
	public Account findAccountByNumber(String accountNumber) {
		return findAccountByNumber(accountNumber, false);
	}

	@Transactional(readOnly=true)
	@Override
	public Account findAccountByNumber(String accountNumber, boolean fetchCards) {
		return accountRepository.findByNumber(accountNumber, fetchCards);
	}

	@Override
	public void updateAccount(Account account) {
		accountRepository.update(account);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAccountsByName(String searchString) {
		return findAccountsByName(searchString, false);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAccountsByName(String searchString, boolean fetchCards) {
		return accountRepository.findAccountsByName(searchString, fetchCards);
	}

}
