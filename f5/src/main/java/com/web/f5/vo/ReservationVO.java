package com.web.f5.vo;

public class ReservationVO {
	String reservation_idx,store_idx,member_id,reservation_date,reservation_count;
	
	int reservation_num;

	public String getReservation_idx() {
		return reservation_idx;
	}

	public void setReservation_idx(String reservation_idx) {
		this.reservation_idx = reservation_idx;
	}

	public String getStore_idx() {
		return store_idx;
	}

	public void setStore_idx(String store_idx) {
		this.store_idx = store_idx;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getReservation_date() {
		return reservation_date;
	}

	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}

	public int getReservation_num() {
		return reservation_num;
	}

	public void setReservation_num(int reservation_num) {
		this.reservation_num = reservation_num;
	}

	public String getReservation_count() {
		return reservation_count;
	}

	public void setReservation_count(String reservation_count) {
		this.reservation_count = reservation_count;
	}
	
	
	
}