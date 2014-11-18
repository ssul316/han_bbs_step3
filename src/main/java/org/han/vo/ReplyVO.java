package org.han.vo;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class ReplyVO {
	
	private Integer rno;
	private Integer bno;
	private String userid;
	private String cont;
	private Date regdate;
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", userid=" + userid
				+ ", cont=" + cont + ", regdate=" + regdate + "]";
	}
	
	

}
