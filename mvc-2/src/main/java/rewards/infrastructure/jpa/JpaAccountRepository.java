package rewards.infrastructure.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import rewards.domain.model.Account;
import rewards.domain.model.AccountRepository;

@Repository
public class JpaAccountRepository implements AccountRepository {

	/*
	private static final String SQL_FINDBY_CARDNUMBER =
			"SELECT a.ID AS ID, a.NUMBER AS NUMBER, a.NAME AS NAME, a.TOTAL_POINTS AS TOTAL_POINTS,"
					+ " b.NUMBER AS CARD_NUMBER, b.ID AS CARD_ID"
					+ " FROM T_ACCOUNT a, T_ACCOUNT_CARD c"
					+ " LEFT OUTER JOIN T_ACCOUNT_CARD b ON a.ID = b.ACCOUNT_ID"
					+ " WHERE c.NUMBER = :cardNumber AND c.ACCOUNT_ID = a.ID";
	*/
	
    private EntityManager entityManager;
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
    	this.entityManager = entityManager;
    }

	@Override
	public Account findByCardNumber(String cardNumber) {
		TypedQuery<Account> query = entityManager.createQuery(
				"SELECT a FROM Account a JOIN a.cards c WHERE c.number = :cardNumber", Account.class);
	    query.setParameter("cardNumber", cardNumber);
	    return query.getSingleResult();
	}

	@Override
	public List<Account> findAll() {
		TypedQuery<Account> query = entityManager.createQuery(
				"SELECT a FROM Account a", Account.class);
		return query.getResultList();
	}

	@Override
	public Account findByNumber(String accountNumber) {
		TypedQuery<Account> query = entityManager.createQuery(
				"SELECT a FROM Account a WHERE number = :accountNumber", Account.class);
		query.setParameter("accountNumber", accountNumber);
		return query.getSingleResult();
	}

	@Override
	public Account findAccountAndCardsByNumber(String accountNumber) {
		TypedQuery<Account> query = entityManager.createQuery(
				"SELECT a FROM Account a WHERE number = :accountNumber", Account.class);
		query.setParameter("accountNumber", accountNumber);
		query.setHint("javax.persistence.loadgraph",
				entityManager.getEntityGraph("graph.Account.cards"));
		return query.getSingleResult();
	}

}
