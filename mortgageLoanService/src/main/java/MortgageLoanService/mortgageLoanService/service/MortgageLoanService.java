package MortgageLoanService.mortgageLoanService.service;

import MortgageLoanService.mortgageLoanService.entity.MortgageLoanEntity;
import MortgageLoanService.mortgageLoanService.repository.MortgageLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MortgageLoanService {
    @Autowired
    MortgageLoanRepository mortgageLoanRepository;

    public ArrayList<MortgageLoanEntity> getMortgageLoans(){
        return (ArrayList<MortgageLoanEntity>) mortgageLoanRepository.findAll();
    }

    public MortgageLoanEntity getMortgageLoanById(Long id){
        return mortgageLoanRepository.findById(id).get();
    }

    public int simulator(float amount, float interestRate, int termYears, float propertyValue, int loanType) {
        if (loanType == 0) {
            throw new IllegalArgumentException("loanType cannot be null");
        }

        float P = amount; // Loan amount
        float r = (interestRate / 100) / 12; // Monthly interest rate
        int n = termYears * 12; // Total number of payments in months
        float maxAmount;

        Long LoanType = (long) loanType;
        MortgageLoanEntity loan = getMortgageLoanById(LoanType);
        long loanId = LoanType;

        maxAmount = propertyValue * loan.getMaxAmount();
        if (termYears > loan.getMaxTerm() || r * 12 < loan.getMinInterestRate() || r * 12 > loan.getMaxInterestRate() || P > maxAmount) {
            throw new IllegalArgumentException("Invalid values.");
        }

        /*
        switch ((int)loanId) { // Convert Long to int for the switch
            case 1: // First home loan
                maxAmount = propertyValue * loan.getMaxAmount();
                if (termYears > loan.getMaxTerm() || r * 12 < loan.getMinInterestRate() || r * 12 > loan.getMaxInterestRate() || P > maxAmount) {
                    throw new IllegalArgumentException("Invalid values: For first home loans, max 30 years, 3.5%-5.0% interest, 80% of property value.");
                }
                break;
            case 2: // Second home loan
                maxAmount = propertyValue * loan.getMaxAmount();
                if (termYears > loan.getMaxTerm() || r * 12 < loan.getMinInterestRate() || r * 12 > loan.getMaxInterestRate() || P > maxAmount) {
                    throw new IllegalArgumentException("Invalid values: For second home loans, max 20 years, 4.0%-6.0% interest, 70% of property value.");
                }
                break;
            case 3: // Commercial property loan
                maxAmount = propertyValue * loan.getMaxAmount();
                if (termYears > loan.getMaxTerm() || r * 12 < loan.getMinInterestRate() || r * 12 > loan.getMaxInterestRate() || P > maxAmount) {
                    throw new IllegalArgumentException("Invalid values: For commercial property loans, max 25 years, 5.0%-7.0% interest, 60% of property value.");
                }
                break;
            case 4: // Remodeling loan
                maxAmount = propertyValue * loan.getMaxAmount();
                if (termYears > loan.getMaxTerm() || r * 12 < loan.getMinInterestRate() || r * 12 > loan.getMaxInterestRate() || P > maxAmount) {
                    throw new IllegalArgumentException("Invalid values: For remodeling loans, max 15 years, 4.5%-6.0% interest, 50% of property value.");
                }
                break;
            default:
                throw new IllegalArgumentException("Please select a valid loan type.");
        }

         */

        // Handle zero interest rate case
        if (r == 0) {
            return (int) P / n;
        }

        // Calculate monthly payment using the formula
        double M = P * ((r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1));
        return (int) M;
    }
}