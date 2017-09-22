package rewards.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_REWARD")
@Access(AccessType.FIELD)
public class Reward {
	
	@Id
	@Column(name="confirmation_number")
	private String confirmationNumber;

	@Embedded
	@AttributeOverride(name = "value", column=@Column(name = "reward_points"))
	private RewardPoints rewardPoints;

	@Column(name = "reward_date")
	private Date rewardDate;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "merchant_number")
	private String merchantNumber;
	
	@Column(name = "purchase_amount")
	private BigDecimal purchaseAmount;
	
	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	public Reward(RewardPoints rewardPoints, String confirmationNumber,
			String accountNumber, String cardNumber,
			String merchantNumber, BigDecimal purchaseAmount, Date purchaseDate) {
		super();
		this.rewardPoints = rewardPoints;
		this.confirmationNumber = confirmationNumber;
		this.accountNumber = accountNumber;
		this.cardNumber = cardNumber;
		this.merchantNumber = merchantNumber;
		this.purchaseAmount = purchaseAmount;
		this.purchaseDate = purchaseDate;
		this.rewardDate = new Date();
	}
	
	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public RewardPoints getRewardPoints() {
		return rewardPoints;
	}

	public Date getRewardDate() {
		return rewardDate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getMerchantNumber() {
		return merchantNumber;
	}

	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmationNumber == null) ? 0 : confirmationNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reward other = (Reward) obj;
		if (confirmationNumber == null) {
			if (other.confirmationNumber != null)
				return false;
		} else if (!confirmationNumber.equals(other.confirmationNumber))
			return false;
		return true;
	}
	
	protected Reward() {
		// required by persistence layer
	}

}
