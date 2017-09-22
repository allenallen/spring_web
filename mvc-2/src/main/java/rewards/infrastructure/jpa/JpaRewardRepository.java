package rewards.infrastructure.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import common.Money;
import rewards.domain.model.Reward;
import rewards.domain.model.RewardPoints;
import rewards.domain.model.RewardRepository;

@Repository
public class JpaRewardRepository implements RewardRepository {
	
	private static final String SQL_NEXT_CONFIRMATION_NUMBER =
			"select next value for S_REWARD_CONFIRMATION_NUMBER from DUAL_REWARD_CONFIRMATION_NUMBER";

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public String confirmReward(String accountNumber, String cardNumber,
			String merchantNumber, Money purchaseAmount, Date purchaseDate,
			RewardPoints pointsEarned) {
		String confirmationNumber = nextConfirmationNumber();
		Reward reward = new Reward(
				pointsEarned, confirmationNumber,
				accountNumber, cardNumber, merchantNumber,
				purchaseAmount.getValue(), purchaseDate);
		entityManager.persist(reward);
		return confirmationNumber;
	}

	private String nextConfirmationNumber() {
		Query query = entityManager.createNativeQuery(SQL_NEXT_CONFIRMATION_NUMBER);
		return query.getSingleResult().toString();
	}

}
