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

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAll() {
		return findAll(false);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAll(boolean fetchCards) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a", Account.class);
		if (fetchCards) {
			query.setHint("javax.persistence.loadgraph",
					getEntityManager().getEntityGraph("graph.Account.cards"));
		}
		return query.getResultList();
	}

	@Transactional(readOnly=true)
	@Override
	public Account findByNumber(String accountNumber) {
		return findByNumber(accountNumber, false);
	}

	@Transactional(readOnly=true)
	@Override
	public Account findByNumber(String accountNumber, boolean fetchCards) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a WHERE number = :accountNumber", Account.class);
		query.setParameter("accountNumber", accountNumber);
		if (fetchCards) {
			query.setHint("javax.persistence.loadgraph",
					getEntityManager().getEntityGraph("graph.Account.cards"));
		}
		return query.getSingleResult();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAccountsByName(String searchString) {
		return findAccountsByName(searchString, false);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAccountsByName(String searchString, boolean fetchCards) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a WHERE UPPER(a.name) LIKE :name ORDER BY a.name", Account.class);
		query.setParameter("name", 
				new StringBuilder("%").append(searchString.toUpperCase()).append("%").toString());
		if (fetchCards) {
			query.setHint("javax.persistence.loadgraph",
					getEntityManager().getEntityGraph("graph.Account.cards"));
		}
		return query.getResultList();
	}

}
