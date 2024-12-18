package LoanSolicitudeService.loanSolicitudeService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loansolicitudeentity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanSolicitudeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "rutuser")
    private String rutUser;

    @Column(name = "idmortgageloan")
    private Long idMortgageLoan;

    @Column(name = "state")
    private Integer state;

    @Column(name = "monthlyinstallments")
    private Integer monthlyInstallments;

    //Required documents
    @Column(name = "proofofincome")
    private byte[] proofOfIncome;

    @Column(name = "appraisalcertificate")
    private byte[] appraisalCertificate;

    @Column(name = "credithistory")
    private byte[] creditHistory;

    @Column(name = "housedeed")
    private byte[] houseDeed;

    @Column(name = "businessfinancialstatus")
    private byte[] businessFinancialStatus;

    @Column(name = "businessplan")
    private byte[] businessPlan;

    @Column(name = "remodelbudget")
    private byte[] remodelBudget;
}
