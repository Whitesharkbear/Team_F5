package com.web.f5.vo;

public class ReviewVO {
	String reviewIdx,storeIdx,memberId,reviewContent;
	float reviewScore;
	public String getReviewIdx() {
		return reviewIdx;
	}
	public void setReviewIdx(String reviewIdx) {
		this.reviewIdx = reviewIdx;
	}
	public String getStoreIdx() {
		return storeIdx;
	}
	public void setStoreIdx(String storeIdx) {
		this.storeIdx = storeIdx;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public float getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(float reviewScore) {
		this.reviewScore = reviewScore;
	}
	
	
}