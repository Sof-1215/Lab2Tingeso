package EvaluationService.evaluationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanSolicitude {
    private Long id;
    private String rutUser;
    private Long idMortgageLoan;
    private Integer state;
    private Integer monthlyInstallments;

    //Required documents
    private byte[] proofOfIncome;
    private byte[] appraisalCertificate;
    private byte[] creditHistory;
    private byte[] houseDeed;
    private byte[] businessFinancialStatus;
    private byte[] businessPlan;
    private byte[] remodelBudget;
}
