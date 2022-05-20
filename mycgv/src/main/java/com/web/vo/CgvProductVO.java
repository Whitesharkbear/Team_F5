package com.web.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class CgvProductVO {
	int  rno, price;
	String pid, pcategory,pname,pinfo,pdate;
	String pfile1,pfile2,pfile3,pfile4,pfile5,psfile1,psfile2,psfile3,psfile4,psfile5;
	CommonsMultipartFile[] files;	//폼에서 넘어오는 멀티파일 저장배열
	List<String> pfiles = new ArrayList();	//DB에 저장되는 pfile 목록
	List<String> psfiles = new ArrayList();	//DB에 저장되는 psfile 목록
	

	public String getPfile1() {
		return pfile1;
	}
	public void setPfile1(String pfile1) {
		this.pfile1 = pfile1;
	}
	public String getPfile2() {
		return pfile2;
	}
	public void setPfile2(String pfile2) {
		this.pfile2 = pfile2;
	}
	public String getPfile3() {
		return pfile3;
	}
	public void setPfile3(String pfile3) {
		this.pfile3 = pfile3;
	}
	public String getPfile4() {
		return pfile4;
	}
	public void setPfile4(String pfile4) {
		this.pfile4 = pfile4;
	}
	public String getPfile5() {
		return pfile5;
	}
	public void setPfile5(String pfile5) {
		this.pfile5 = pfile5;
	}
	public String getPsfile1() {
		return psfile1;
	}
	public void setPsfile1(String psfile1) {
		this.psfile1 = psfile1;
	}
	public String getPsfile2() {
		return psfile2;
	}
	public void setPsfile2(String psfile2) {
		this.psfile2 = psfile2;
	}
	public String getPsfile3() {
		return psfile3;
	}
	public void setPsfile3(String psfile3) {
		this.psfile3 = psfile3;
	}
	public String getPsfile4() {
		return psfile4;
	}
	public void setPsfile4(String psfile4) {
		this.psfile4 = psfile4;
	}
	public String getPsfile5() {
		return psfile5;
	}
	public void setPsfile5(String psfile5) {
		this.psfile5 = psfile5;
	}
	public List<String> getPfiles() {
		return pfiles;
	}
	public void setPfiles(List<String> pfiles) {
		this.pfiles = pfiles;
	}
	public List<String> getPsfiles() {
		return psfiles;
	}
	public void setPsfiles(List<String> psfiles) {
		this.psfiles = psfiles;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public CommonsMultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(CommonsMultipartFile[] files) {
		this.files = files;
	}	
	
}
