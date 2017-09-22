package rewards.domain.model;

import java.util.List;

public interface AccountRepository {

	Account findByCardNumber(String cardNumber);
	
	List<Account> findAll();

	Account findByNumber(String accountNumber);
	
	Account findAccountAndCardsByNumber(String accountNumber);
	
}
