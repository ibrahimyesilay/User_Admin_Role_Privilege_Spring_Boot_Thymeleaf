package com.yesilay.stocktrace.dao;


import com.yesilay.stocktrace.model.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDao extends JpaRepository<Stocks, Integer> {
}
