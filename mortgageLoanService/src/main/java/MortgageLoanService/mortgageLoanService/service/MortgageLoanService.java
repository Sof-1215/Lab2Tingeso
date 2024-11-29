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
}
