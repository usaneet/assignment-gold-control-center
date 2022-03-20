package co.th.goldworld.goldtracking.cash.summary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashSummaryService {

    @Autowired
    CashSummaryRepository cashSummaryRepository;

    public CashSummary getCashSummary(){
        return cashSummaryRepository.findFirstByIdOrderByCreatedDateDesc();
    }
}
