package MortgageLoanService.mortgageLoanService.controller;

import MortgageLoanService.mortgageLoanService.entity.MortgageLoanEntity;
import MortgageLoanService.mortgageLoanService.service.MortgageLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/mortgageloan")
public class MortgageLoanController {
    @Autowired
    MortgageLoanService mortgageLoanService;

    @GetMapping("/")
    public ResponseEntity<List<MortgageLoanEntity>> listAllMortgageLoans() {
        List<MortgageLoanEntity> mortgageLoans = mortgageLoanService.getMortgageLoans();
        return ResponseEntity.ok(mortgageLoans);
    }
}
