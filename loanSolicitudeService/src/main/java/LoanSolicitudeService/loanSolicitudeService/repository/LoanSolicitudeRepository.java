package LoanSolicitudeService.loanSolicitudeService.repository;

import LoanSolicitudeService.loanSolicitudeService.entity.LoanSolicitudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanSolicitudeRepository extends JpaRepository<LoanSolicitudeEntity, Long> {
}
