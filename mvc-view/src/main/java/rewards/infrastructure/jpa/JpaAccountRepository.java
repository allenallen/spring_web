package rewards.infrastructure.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.infrastructure.persistence.jpa.JpaGenericRepository;
import rewards.domain.model.Account;
import rewards.domain.model.AccountRepository;

@Repository
@Transactional
public class JpaAccountRepository
		extends JpaGenericRepository<Account, Long>
		implements AccountRepository {

	@Override
	protected Class<Account> getEntityClass() {
		return Account.class;
	}

	@Override
	public Account findByCardNumber(String cardNumber) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a JOIN a.cards c WHERE c.number = :cardNumber", Account.class);
	    query.setParameter("cardNumber", cardNumber);
	    return query.getSingleResult();
	}

	@Override
	public List<Account> findAll() {
		return findAll(false);
	}

	@Override
	public List<Account> findAllWithCards() {
		return findAll(true);
	}

	protected List<Account> findAll(boolean fetchCards) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a", Account.class);
		if (fetchCards) {
			query.setHint("javax.persistence.loadgraph",
					getEntityManager().getEntityGraph("graph.Account.cards"));
		}
		return query.getResultList();
	}

	@Override
	public Account findByNumber(String accountNumber) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a WHERE number = :accountNumber", Account.class);
		query.setParameter("accountNumber", accountNumber);
		return query.getSingleResult();
	}

	@Override
	public Account findAccountAndCardsByNumber(String accountNumber) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a WHERE number = :accountNumber", Account.class);
		query.setParameter("accountNumber", accountNumber);
		query.setHint("javax.persistence.loadgraph",
				getEntityManager().getEntityGraph("graph.Account.cards"));
		return query.getSingleResult();
	}

}
