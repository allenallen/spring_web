package rewards.infrastructure.jpa;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import common.infrastructure.persistence.jpa.JpaGenericRepository;
import rewards.domain.model.Merchant;
import rewards.domain.model.MerchantRepository;

@Repository
@Transactional
public class JpaMerchantRepository
		extends JpaGenericRepository<Merchant, Long>
		implements MerchantRepository {

	@Override
	protected Class<Merchant> getEntityClass() {
		return Merchant.class;
	}

	@Transactional(readOnly=true)
	@Override
	public Merchant findByNumber(String merchantNumber) {
		TypedQuery<Merchant> query = getEntityManager().createQuery(
				"SELECT m FROM Merchant m WHERE m.number = :merchantNumber", Merchant.class);
		query.setParameter("merchantNumber", merchantNumber);
		return query.getSingleResult();
	}

}
