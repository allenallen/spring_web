package rewards.domain.model;

import java.util.List;

import common.domain.model.GenericRepository;

public interface AccountRepository extends GenericRepository<Account, Long> {

	Account findByCardNumber(String cardNumber);
	
	List<Account> findAll();

	List<Account> findAll(boolean fetchCards);

	Account findByNumber(String accountNumber);
	
	Account findByNumber(String accountNumber, boolean fetchCards);

	List<Account> findAccountsByName(String searchString);

	List<Account> findAccountsByName(String searchString, boolean fetchCards);

}
