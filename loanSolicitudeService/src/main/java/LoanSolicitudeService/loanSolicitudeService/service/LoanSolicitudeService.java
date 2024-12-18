package LoanSolicitudeService.loanSolicitudeService.service;

import LoanSolicitudeService.loanSolicitudeService.entity.LoanSolicitudeEntity;
import LoanSolicitudeService.loanSolicitudeService.repository.LoanSolicitudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LoanSolicitudeService {
    @Autowired
    LoanSolicitudeRepository loanSolicitudeRepository;

    public LoanSolicitudeEntity create(String rutUser, Long idMortgageLoan,
                                       MultipartFile proofOfIncome, MultipartFile appraisalCertificate,
                                       MultipartFile creditHistory, MultipartFile houseDeed,
                                       MultipartFile businessFinancialStatus, MultipartFile businessPlan,
                                       MultipartFile remodelBudget) throws IOException {
        LoanSolicitudeEntity solicitudeNew = new LoanSolicitudeEntity();
        solicitudeNew.setRutUser(rutUser);
        solicitudeNew.setIdMortgageLoan(idMortgageLoan);

        if (proofOfIncome != null) {
            solicitudeNew.setProofOfIncome(proofOfIncome.getBytes());
        }
        if (appraisalCertificate != null) {
            solicitudeNew.setAppraisalCertificate(appraisalCertificate.getBytes());
        }
        if (creditHistory != null) {
            solicitudeNew.setCreditHistory(creditHistory.getBytes());
        }
        if (houseDeed != null) {
            solicitudeNew.setHouseDeed(houseDeed.getBytes());
        }
        if (businessFinancialStatus != null) {
            solicitudeNew.setBusinessFinancialStatus(businessFinancialStatus.getBytes());
        }
        if (businessPlan != null) {
            solicitudeNew.setBusinessPlan(businessPlan.getBytes());
        }
        if (remodelBudget != null) {
            solicitudeNew.setRemodelBudget(remodelBudget.getBytes());
        }

        return loanSolicitudeRepository.save(solicitudeNew);
    }

    public List<LoanSolicitudeEntity> getLoanSolicitude(String rutUser) {
        return loanSolicitudeRepository.findByRutUser(rutUser);
    }
}
