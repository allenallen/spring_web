package rewards.infrastructure.jpa;

import java.util.Date;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.Money;
import common.infrastructure.persistence.jpa.JpaGenericRepository;
import rewards.domain.model.Reward;
import rewards.domain.model.RewardPoints;
import rewards.domain.model.RewardRepository;

@Repository
@Transactional
public class JpaRewardRepository
		extends JpaGenericRepository<Reward, String>
		implements RewardRepository {
	
	private static final String SQL_NEXT_CONFIRMATION_NUMBER =
			"select next value for S_REWARD_CONFIRMATION_NUMBER from DUAL_REWARD_CONFIRMATION_NUMBER";

	@Override
	protected Class<Reward> getEntityClass() {
		return Reward.class;
	}

	@Override
	public String confirmReward(String accountNumber, String cardNumber,
			String merchantNumber, Money purchaseAmount, Date purchaseDate,
			RewardPoints pointsEarned) {
		String confirmationNumber = nextConfirmationNumber();
		Reward reward = new Reward(
				pointsEarned, confirmationNumber,
				accountNumber, cardNumber, merchantNumber,
				purchaseAmount.getValue(), purchaseDate);
		getEntityManager().persist(reward);
		return confirmationNumber;
	}

	private String nextConfirmationNumber() {
		Query query = getEntityManager().createNativeQuery(SQL_NEXT_CONFIRMATION_NUMBER);
		return query.getSingleResult().toString();
	}

}
