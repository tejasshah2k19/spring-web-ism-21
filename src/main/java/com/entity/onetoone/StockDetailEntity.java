package com.entity.onetoone;

public class StockDetailEntity {

	int stockDetailId;
	float price;
	float allTimeHighPrice;
	float allTimeLowPrice;

	StockEntity stock;

	public StockEntity getStock() {
		return stock;
	}
	public void setStock(StockEntity stock) {
		this.stock = stock;
	}
	public int getStockDetailId() {
		return stockDetailId;
	}
	public void setStockDetailId(int stockDetailId) {
		this.stockDetailId = stockDetailId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getAllTimeHighPrice() {
		return allTimeHighPrice;
	}
	public void setAllTimeHighPrice(float allTimeHighPrice) {
		this.allTimeHighPrice = allTimeHighPrice;
	}
	public float getAllTimeLowPrice() {
		return allTimeLowPrice;
	}
	public void setAllTimeLowPrice(float allTimeLowPrice) {
		this.allTimeLowPrice = allTimeLowPrice;
	}
 
}
