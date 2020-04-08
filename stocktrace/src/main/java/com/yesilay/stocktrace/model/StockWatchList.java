package com.yesilay.stocktrace.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "stock_watchlist")
public class StockWatchList {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="usst_stock_Id", nullable = false)
    private int usstStockId;
    @Column(name="usst_notes")
    private String usstNotes;
    @Column(name="usst_number_of_item")
    private int usstNumberOfItem;
    @Column(name="usst_buying_price")
    private int usstBuyingPrice;
    @Column(name="usst_buying_commission")
    private int usstBuyingCommission;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="usst_date_created", nullable = false, updatable = false)
    private Date usstDateCreated;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="usst_buying_date")
    private Date usstBuyingDate;
    @Column(name="usst_visiblity")
    private Boolean usstVisiblity;
    @Column(name="usst_active", nullable = false)
    private Boolean usstActive;


    @Override
    public String toString() {
        return "StockWatchList{" +
                "usstStockId=" + usstStockId +
                ", usstNotes='" + usstNotes + '\'' +
                ", usstNumberOfItem=" + usstNumberOfItem +
                ", usstBuyingPrice=" + usstBuyingPrice +
                ", usstBuyingCommission=" + usstBuyingCommission +
                ", usstDateCreated=" + usstDateCreated +
                ", usstBuyingDate=" + usstBuyingDate +
                ", usstVisiblity=" + usstVisiblity +
                ", usstActive=" + usstActive +
                '}';
    }

    public int getUsstStockId() {
        return usstStockId;
    }

    public void setUsstStockId(int usstStockId) {
        this.usstStockId = usstStockId;
    }

    public String getUsstNotes() {
        return usstNotes;
    }

    public void setUsstNotes(String usstNotes) {
        this.usstNotes = usstNotes;
    }

    public int getUsstNumberOfItem() {
        return usstNumberOfItem;
    }

    public void setUsstNumberOfItem(int usstNumberOfItem) {
        this.usstNumberOfItem = usstNumberOfItem;
    }

    public int getUsstBuyingPrice() {
        return usstBuyingPrice;
    }

    public void setUsstBuyingPrice(int usstBuyingPrice) {
        this.usstBuyingPrice = usstBuyingPrice;
    }

    public int getUsstBuyingCommission() {
        return usstBuyingCommission;
    }

    public void setUsstBuyingCommission(int usstBuyingCommission) {
        this.usstBuyingCommission = usstBuyingCommission;
    }

    public Date getUsstDateCreated() {
        return usstDateCreated;
    }

    public void setUsstDateCreated(Date usstDateCreated) {
        this.usstDateCreated = usstDateCreated;
    }

    public Date getUsstBuyingDate() {
        return usstBuyingDate;
    }

    public void setUsstBuyingDate(Date usstBuyingDate) {
        this.usstBuyingDate = usstBuyingDate;
    }

    public Boolean getUsstVisiblity() {
        return usstVisiblity;
    }

    public void setUsstVisiblity(Boolean usstVisiblity) {
        this.usstVisiblity = usstVisiblity;
    }

    public Boolean getUsstActive() {
        return usstActive;
    }

    public void setUsstActive(Boolean usstActive) {
        this.usstActive = usstActive;
    }

}
