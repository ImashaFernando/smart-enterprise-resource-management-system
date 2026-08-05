package com.serms.service;

import com.serms.entity.Finance;

import java.util.List;

public interface FinanceService {

    List<Finance> getAllFinance();

    Finance saveFinance(Finance finance);

    Finance getFinanceById(Long id);

    Finance updateFinance(Finance finance);

    void deleteFinance(Long id);

    List<Finance> searchFinance(String keyword);

    Double getTotalIncome();

}