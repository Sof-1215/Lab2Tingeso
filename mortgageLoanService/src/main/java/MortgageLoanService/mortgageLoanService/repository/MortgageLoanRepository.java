package MortgageLoanService.mortgageLoanService.repository;

import MortgageLoanService.mortgageLoanService.entity.MortgageLoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageLoanRepository extends JpaRepository<MortgageLoanEntity, Long> {
    MortgageLoanEntity findMortgageLoanEntitiesByType(int type);
}
