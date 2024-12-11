package EvaluationService.evaluationService.controller;

import EvaluationService.evaluationService.model.LoanSolicitude;
import EvaluationService.evaluationService.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/evaluation")
public class EvaluationController {
    @Autowired
    EvaluationService evaluationService;

    @GetMapping("/listloans/{rutUser}")
    public List<LoanSolicitude> listLoans(@PathVariable String rutUser) {
        return evaluationService.search(rutUser);
    }
}
