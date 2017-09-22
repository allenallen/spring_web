package rewards.domain.model;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ACCOUNT_CARD")
@Access(AccessType.FIELD)
public class Card {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	
	private String number;

	public Card(String number) {
		if (number == null || number.isEmpty()) {
			throw new IllegalArgumentException("Card number cannot be null");
		}
		// To keep things simple, no MOD-10 check is done.
		this.number = number;
	}

	public Long getId() {
	  return id;
	}
	
	public String getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Card other = (Card) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	protected Card() {
		// required by persistence layer
	}

}
