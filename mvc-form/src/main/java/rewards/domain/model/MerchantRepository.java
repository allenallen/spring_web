package rewards.domain.model;

import common.domain.model.GenericRepository;

public interface MerchantRepository extends GenericRepository<Merchant, Long> {

	Merchant findByNumber(String merchantNumber);

}
