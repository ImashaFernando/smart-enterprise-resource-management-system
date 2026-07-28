package com.serms.service;

import com.serms.entity.Finance;

import java.util.List;

public interface ReportService {

    Double getTotalIncome();

    Double getTotalExpense();

    Double getNetBalance();

    Long getTotalTransactions();

    List<Finance> getRecentTransactions();

}