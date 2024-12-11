package EvaluationService.evaluationService.service;

import EvaluationService.evaluationService.model.LoanSolicitude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EvaluationService {
    @Autowired
    RestTemplate restTemplate;

    public List<LoanSolicitude> search(String rutUser) {
        return restTemplate.getForObject("http://localhost:8088/api/v1/loansolicitude/solicitude/" + rutUser, List.class);
    }

    public int cuota_income(float cuota, float income) {
        float result = (cuota / income) * 100;
        if (result > 0.0 && result <= 100) {
            return 1;
        }
        return 0;
    }

    public int maxAmount(int loanType, float propertyValue, float loanAmount) {
        float max;
        if (loanType == 1) {
            max = propertyValue * 0.8F;
            if (loanAmount > max) {
                return 0;
            }
        } else if (loanType == 2) {
            max = propertyValue * 0.7F;
            if (loanAmount > max) {
                return 0;
            }
        } else if (loanType == 3) {
            max = propertyValue * 0.6F;
            if (loanAmount > max) {
                return 0;
            }
        } else if (loanType == 4) {
            max = propertyValue * 0.5F;
            if (loanAmount > max) {
                return 0;
            }
        }
        return 1;
    }

}
