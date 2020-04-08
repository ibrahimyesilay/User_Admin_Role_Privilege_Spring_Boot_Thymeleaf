package com.yesilay.stocktrace.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity(name = "stocks")
@Table(name = "stocks")
public class Stocks {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="st_id", nullable = false)
    private int stId;
    @Column(name="st_symbol", nullable = false, length = 10)
    private String stSymbol;
    @Column(name="st_wkn", nullable = false, length = 10)
    private String stWKN;
    @Column(name="st_name", nullable = false, length = 25)
    private String stName;
    @Column(name="st_market", nullable = false, length = 20)
    private String stMarket;
    @Column(name="st_cur", nullable = false, length = 5)
    private String stCur;
    @Column(name="st_last_price")
    private int stLastPrice;
    @Column(name="st_highest")
    private int stHighest;
    @Column(name="st_lowest")
    private int stLowest;
    @Column(name="st_change")
    private int stChange;
    @Column(name="st_change_percent")
    private int stChangePercent;
    @Column(name="st_buy_target")
    private int stBuyTarget;
    @Column(name="st_sell_target")
    private int stSellTarget;
    @Column(name="st_strong_buy_target")
    private int stStrongBuyTarget;
    @Column(name="st_strong_sell_target")
    private int stStrongSellTarget;
    @Column(name="st_type", length = 10)
    private String stType;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="st_date_created", nullable = false, updatable = false)
    private Date stDateCreated;
    @Column(name="st_active", nullable = false)
    private Boolean stActive;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "jointable_stock",
            joinColumns = @JoinColumn(
                    name = "st_id", referencedColumnName = "st_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "usst_stock_id", referencedColumnName = "usst_stock_id"))
    private Collection< StockWatchList > fakeStockList;




//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "jointable_stock",
//            joinColumns = @JoinColumn(name =  "sti_id"),
//            inverseJoinColumns = @JoinColumn(name = "usst_stock_id"))
//    private List<StockWatchList> fakeStockList = new ArrayList<>();


    @Override
    public String toString() {
        return "Stocks{" +
                "stId=" + stId +
                ", stSymbol='" + stSymbol + '\'' +
                ", stWKN='" + stWKN + '\'' +
                ", stName='" + stName + '\'' +
                ", stMarket='" + stMarket + '\'' +
                ", stCur='" + stCur + '\'' +
                ", stLastPrice=" + stLastPrice +
                ", stHighest=" + stHighest +
                ", stLowest=" + stLowest +
                ", stChange=" + stChange +
                ", stChangePercent=" + stChangePercent +
                ", stBuyTarget=" + stBuyTarget +
                ", stSellTarget=" + stSellTarget +
                ", stStrongBuyTarget=" + stStrongBuyTarget +
                ", stStrongSellTarget=" + stStrongSellTarget +
                ", stType='" + stType + '\'' +
                ", stDateCreated=" + stDateCreated +
                ", stActive=" + stActive +
                ", fakeStockList=" + fakeStockList +
                '}';
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public String getStSymbol() {
        return stSymbol;
    }

    public void setStSymbol(String stSymbol) {
        this.stSymbol = stSymbol;
    }

    public String getStWKN() {
        return stWKN;
    }

    public void setStWKN(String stWKN) {
        this.stWKN = stWKN;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStMarket() {
        return stMarket;
    }

    public void setStMarket(String stMarket) {
        this.stMarket = stMarket;
    }

    public String getStCur() {
        return stCur;
    }

    public void setStCur(String stCur) {
        this.stCur = stCur;
    }

    public int getStLastPrice() {
        return stLastPrice;
    }

    public void setStLastPrice(int stLastPrice) {
        this.stLastPrice = stLastPrice;
    }

    public int getStHighest() {
        return stHighest;
    }

    public void setStHighest(int stHighest) {
        this.stHighest = stHighest;
    }

    public int getStLowest() {
        return stLowest;
    }

    public void setStLowest(int stLowest) {
        this.stLowest = stLowest;
    }

    public int getStChange() {
        return stChange;
    }

    public void setStChange(int stChange) {
        this.stChange = stChange;
    }

    public int getStChangePercent() {
        return stChangePercent;
    }

    public void setStChangePercent(int stChangePercent) {
        this.stChangePercent = stChangePercent;
    }

    public int getStBuyTarget() {
        return stBuyTarget;
    }

    public void setStBuyTarget(int stBuyTarget) {
        this.stBuyTarget = stBuyTarget;
    }

    public int getStSellTarget() {
        return stSellTarget;
    }

    public void setStSellTarget(int stSellTarget) {
        this.stSellTarget = stSellTarget;
    }

    public int getStStrongBuyTarget() {
        return stStrongBuyTarget;
    }

    public void setStStrongBuyTarget(int stStrongBuyTarget) {
        this.stStrongBuyTarget = stStrongBuyTarget;
    }

    public int getStStrongSellTarget() {
        return stStrongSellTarget;
    }

    public void setStStrongSellTarget(int stStrongSellTarget) {
        this.stStrongSellTarget = stStrongSellTarget;
    }

    public String getStType() {
        return stType;
    }

    public void setStType(String stType) {
        this.stType = stType;
    }

    public Date getStDateCreated() {
        return stDateCreated;
    }

    public void setStDateCreated(Date stDateCreated) {
        this.stDateCreated = stDateCreated;
    }

    public Boolean getStActive() {
        return stActive;
    }

    public void setStActive(Boolean stActive) {
        this.stActive = stActive;
    }

    public Collection<StockWatchList> getFakeStockList() {
        return fakeStockList;
    }

    public void setFakeStockList(Collection<StockWatchList> fakeStockList) {
        this.fakeStockList = fakeStockList;
    }
}
