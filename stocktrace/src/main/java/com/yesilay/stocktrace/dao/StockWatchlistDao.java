package com.yesilay.stocktrace.dao;


import com.yesilay.stocktrace.model.Roles;
import com.yesilay.stocktrace.model.StockWatchList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockWatchlistDao extends JpaRepository<StockWatchList, Integer> {
}
