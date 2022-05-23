package com.web.f5.member.vo;

public class MemberVO {
String memberId,memberPass,memberName,memberBirth,memberTel,memberEmail,memberDate,memberAuthority,memberAgree,memberPassHint,memberPassRand,memberGender,memberAddress;
String memberPassHintAnswer;
String memberBirthYear,memberBirthMonth,memberBirthDate;



public String getMemberBirthYear() {
	return memberBirthYear;
}

public void setMemberBirthYear(String memberBirthYear) {
	this.memberBirthYear = memberBirthYear;
}

public String getMemberBirthMonth() {
	return memberBirthMonth;
}

public void setMemberBirthMonth(String memberBirthMonth) {
	this.memberBirthMonth = memberBirthMonth;
}

public String getMemberBirthDate() {
	return memberBirthDate;
}

public void setMemberBirthDate(String memberBirthDate) {
	this.memberBirthDate = memberBirthDate;
}

public String getMemberGender() {
	return memberGender;
}

public void setMemberGender(String memberGender) {
	this.memberGender = memberGender;
}

public String getMemberAddress() {
	return memberAddress;
}

public void setMemberAddress(String memberAddress) {
	this.memberAddress = memberAddress;
}

public String getMemberId() {
	return memberId;
}

public void setMemberId(String memberId) {
	this.memberId = memberId;
}

public String getMemberPass() {
	return memberPass;
}

public void setMemberPass(String memberPass) {
	this.memberPass = memberPass;
}

public String getMemberName() {
	return memberName;
}

public void setMemberName(String memberName) {
	this.memberName = memberName;
}

public String getMemberBirth() {
	return memberBirthYear+"년"+memberBirthMonth+"월"+memberBirthDate+"일";
}

public void setMemberBirth(String memberBirth) {
	this.memberBirth = memberBirth;
}

public String getMemberTel() {
	return memberTel;
}

public void setMemberTel(String memberTel) {
	this.memberTel = memberTel;
}

public String getMemberEmail() {
	return memberEmail;
}

public void setMemberEmail(String memberEmail) {
	this.memberEmail = memberEmail;
}

public String getMemberDate() {
	return memberDate;
}

public void setMemberDate(String memberDate) {
	this.memberDate = memberDate;
}

public String getMemberAuthority() {
	return memberAuthority;
}

public void setMemberAuthority(String memberAuthority) {
	this.memberAuthority = memberAuthority;
}

public String getMemberAgree() {
	return memberAgree;
}

public void setMemberAgree(String memberAgree) {
	this.memberAgree = memberAgree;
}

public String getMemberPassHint() {
	return memberPassHint;
}

public void setMemberPassHint(String memberPassHint) {
	this.memberPassHint = memberPassHint;
}

public String getMemberPassRand() {
	return memberPassRand;
}

public void setMemberPassRand(String memberPassRand) {
	this.memberPassRand = memberPassRand;
}


}
