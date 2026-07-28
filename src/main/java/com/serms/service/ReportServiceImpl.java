package com.serms.service;

import com.serms.entity.Finance;
import com.serms.repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final FinanceRepository financeRepository;

    public ReportServiceImpl(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    @Override
    public Double getTotalIncome() {
        Double income = financeRepository.getTotalIncome();
        return income != null ? income : 0.0;
    }

    @Override
    public Double getTotalExpense() {
        Double expense = financeRepository.getTotalExpense();
        return expense != null ? expense : 0.0;
    }

    @Override
    public Double getNetBalance() {
        return getTotalIncome() - getTotalExpense();
    }

    @Override
    public Long getTotalTransactions() {
        Long total = financeRepository.getTotalTransactions();
        return total != null ? total : 0L;
    }

    @Override
    public List<Finance> getRecentTransactions() {
        return financeRepository.findTop5ByOrderByTransactionDateDesc();
    }
}