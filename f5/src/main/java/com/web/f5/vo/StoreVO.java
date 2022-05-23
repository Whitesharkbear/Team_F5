package com.web.f5.vo;

public class StoreVO {
	
	String storeIdx,storeName,storePlace,storeContent,storeTel,storeEvent,storeBenefit,storeCategory,storeParking,storeWebSite,storePrice
			,storeMinPrice,storeMaxPrice,storeMinPriceWon,storeMaxPriceWon;
	int storeMaxCount,rno;
	
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getStoreMinPrice() {
		return storeMinPrice;
	}
	public void setStoreMinPrice(String storeMinPrice) {
		this.storeMinPrice = storeMinPrice;
	}
	public String getStoreMaxPrice() {
		return storeMaxPrice;
	}
	public void setStoreMaxPrice(String storeMaxPrice) {
		this.storeMaxPrice = storeMaxPrice;
	}
	public String getStoreMinPriceWon() {
		return storeMinPriceWon;
	}
	public void setStoreMinPriceWon(String storeMinPriceWon) {
		this.storeMinPriceWon = storeMinPriceWon;
	}
	public String getStoreMaxPriceWon() {
		return storeMaxPriceWon;
	}
	public void setStoreMaxPriceWon(String storeMaxPriceWon) {
		this.storeMaxPriceWon = storeMaxPriceWon;
	}
	public String getStoreParking() {
		return storeParking;
	}
	public void setStoreParking(String storeParking) {
		this.storeParking = storeParking;
	}
	public String getStoreWebSite() {
		return storeWebSite;
	}
	public void setStoreWebSite(String storeWebSite) {
		this.storeWebSite = storeWebSite;
	}
	public String getStorePrice() {
		if(storePrice != null) {
			return storePrice;
		}else {
			return storeMinPrice  + "원    ~   "+storeMaxPrice + "원";
		}
	}
	public void setStorePrice(String storePrice) {
		this.storePrice = storePrice;
	}
	public int getStoreMaxCount() {
		return storeMaxCount;
	}
	public void setStoreMaxCount(int storeMaxCount) {
		this.storeMaxCount = storeMaxCount;
	}
	public String getStoreIdx() {
		return storeIdx;
	}
	public void setStoreIdx(String storeIdx) {
		this.storeIdx = storeIdx;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStorePlace() {
		return storePlace;
	}

	public void setStorePlace(String storePlace) {
		this.storePlace = storePlace;
	}

	public String getStoreContent() {
		return storeContent;
	}

	public void setStoreContent(String storeContent) {
		this.storeContent = storeContent;
	}

	public String getStoreTel() {
		return storeTel;
	}

	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}

	public String getStoreEvent() {
		return storeEvent;
	}

	public void setStoreEvent(String storeEvent) {
		this.storeEvent = storeEvent;
	}

	public String getStoreBenefit() {
		return storeBenefit;
	}

	public void setStoreBenefit(String storeBenefit) {
		this.storeBenefit = storeBenefit;
	}

	public String getStoreCategory() {
		return storeCategory;
	}

	public void setStoreCategory(String storeCategory) {
		this.storeCategory = storeCategory;
	}

	
}
