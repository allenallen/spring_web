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

	@Transactional(readOnly=true)
	@Override
	public Account findByNumber(String accountNumber) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a WHERE number = :accountNumber", Account.class);
		query.setParameter("accountNumber", accountNumber);
		return query.getSingleResult();
	}

	@Transactional(readOnly=true)
	@Override
	public Account findAccountAndCardsByNumber(String accountNumber) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a WHERE number = :accountNumber", Account.class);
		query.setParameter("accountNumber", accountNumber);
		query.setHint("javax.persistence.loadgraph",
				getEntityManager().getEntityGraph("graph.Account.cards"));
		return query.getSingleResult();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAccountsByName(String searchString) {
		TypedQuery<Account> query = getEntityManager().createQuery(
				"SELECT a FROM Account a WHERE UPPER(a.name) LIKE :name ORDER BY a.name", Account.class);
		query.setParameter("name", 
				new StringBuilder("%").append(searchString.toUpperCase()).append("%").toString());
		return query.getResultList();
	}

}
