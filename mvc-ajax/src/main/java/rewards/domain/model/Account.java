package rewards.domain.model;

import static javax.persistence.GenerationType.AUTO;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "T_ACCOUNT")
@Access(AccessType.FIELD)
@NamedEntityGraph(name = "graph.Account.cards",
	attributeNodes = @NamedAttributeNode(value = "cards", subgraph = "cards"))
public class Account {

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	private String number;

	@org.hibernate.validator.constraints.NotEmpty
	private String name;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}")
	private String email;

	@Column(name = "MONTHLY_EMAIL_UPDATE")
	private boolean receivingMonthlyEmailUpdate;

	@Column(name = "total_points")
	private BigDecimal totalPoints;
			
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "account_id", nullable=false, updatable=false)
	private Set<Card> cards = new HashSet<>();

	public Account(String number, String name) {
		this(number, name, BigDecimal.ZERO);
	}

	public Account(String number, String name, BigDecimal points) {
		super();
		this.number = number;
		this.name = name;
		this.totalPoints = points;
	}

	public Long getId() {
	  return id;
	}

	public void credit(RewardPoints points) {
		totalPoints = totalPoints.add(points.getValue());
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isReceivingMonthlyEmailUpdate() {
		return receivingMonthlyEmailUpdate;
	}
	
	public void setReceivingMonthlyEmailUpdate(boolean receivingMonthlyEmailUpdate) {
		this.receivingMonthlyEmailUpdate = receivingMonthlyEmailUpdate;
	}

	public BigDecimal getTotalPoints() {
		return totalPoints;
	}

	public boolean addCard(String cardNumber) {
		return cards.add(new Card(cardNumber));
	}
	
	public Set<Card> getCards() {
		return Collections.unmodifiableSet(cards);
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
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	protected Account() {
		// required by persistence layer
	}

}
