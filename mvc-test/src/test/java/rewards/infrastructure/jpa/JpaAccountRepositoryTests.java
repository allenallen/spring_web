package rewards.infrastructure.jpa;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import rewards.domain.model.Account;
import rewards.domain.model.AccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class JpaAccountRepositoryTests {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void testFindAccountByCard() throws Exception {
		Account account = accountRepository.findByCardNumber("1234567890");
		assertNotNull(account);
		assertEquals("8861888", account.getNumber());
		assertEquals("Juan Dela Cruz", account.getName());
		assertEquals(1, account.getCards().size());
		assertEquals(BigDecimal.ZERO, account.getTotalPoints());
	}

	@Test(expected=EmptyResultDataAccessException.class)
	public void throwsExceptionWhenCardNumberNotFound() throws Exception {
		accountRepository.findByCardNumber("NON-EXISTENT CARD");
	} 
	
	@Test
	public void testFindByAccountNumber() throws Exception {
		Account account = accountRepository.findByNumber("8861888");
		assertNotNull(account);
		assertEquals("8861888", account.getNumber());
	}

	@Test(expected=EmptyResultDataAccessException.class)
	public void throwsExceptionWhenAccountNumberNotFound() throws Exception {
		accountRepository.findByNumber("NON-EXISTENT ACCOUNT");
	} 
	
}
