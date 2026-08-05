package com.serms.service;

import com.serms.entity.Finance;
import com.serms.repository.FinanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {

    private final FinanceRepository financeRepository;

    public FinanceServiceImpl(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    @Override
    public List<Finance> getAllFinance() {
        return financeRepository.findAll();
    }

    @Override
    public Finance saveFinance(Finance finance) {
        return financeRepository.save(finance);
    }

    @Override
    public Finance getFinanceById(Long id) {
        return financeRepository.findById(id).orElse(null);
    }

    @Override
    public Finance updateFinance(Finance finance) {
        return financeRepository.save(finance);
    }

    @Override
    public void deleteFinance(Long id) {
        financeRepository.deleteById(id);
    }

    @Override
    public List<Finance> searchFinance(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return financeRepository.findAll();
        }

        return financeRepository
                .findByTransactionCodeContainingIgnoreCaseOrTransactionTypeContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrPaymentMethodContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        keyword
                );
    }
    @Override
    public Double getTotalIncome() {
        return financeRepository.getTotalIncome();
    }
}