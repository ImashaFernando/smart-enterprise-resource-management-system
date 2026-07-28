package com.serms.repository;

import com.serms.entity.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FinanceRepository extends JpaRepository<Finance, Long> {

    List<Finance> findByTransactionCodeContainingIgnoreCaseOrTransactionTypeContainingIgnoreCaseOrCategoryContainingIgnoreCaseOrPaymentMethodContainingIgnoreCase(
            String code,
            String type,
            String category,
            String payment
    );

    @Query("SELECT COALESCE(SUM(f.amount),0) FROM Finance f WHERE LOWER(f.transactionType)='income'")
    Double getTotalIncome();

    @Query("SELECT COALESCE(SUM(f.amount),0) FROM Finance f WHERE LOWER(f.transactionType)='expense'")
    Double getTotalExpense();

    @Query("SELECT COUNT(f) FROM Finance f")
    Long getTotalTransactions();

    List<Finance> findTop5ByOrderByTransactionDateDesc();
}