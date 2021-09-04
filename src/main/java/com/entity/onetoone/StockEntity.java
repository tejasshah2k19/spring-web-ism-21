package com.entity.onetoone;

public class StockEntity {

	int stockId;
	String stockName;
	String sector;


	StockDetailEntity stockDetail;
	

	public StockDetailEntity getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetailEntity stockDetail) {
		this.stockDetail = stockDetail;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	
}
