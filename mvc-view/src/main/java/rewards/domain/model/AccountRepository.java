package rewards.domain.model;

import java.util.List;

import common.domain.model.GenericRepository;

public interface AccountRepository extends GenericRepository<Account, Long> {

	Account findByCardNumber(String cardNumber);
	
	List<Account> findAll();

	List<Account> findAllWithCards();

	Account findByNumber(String accountNumber);
	
	Account findAccountAndCardsByNumber(String accountNumber);
	
}
