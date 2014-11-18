package org.han.vo;

import java.sql.Date;

import org.springframework.stereotype.Service;

@Service
public class BbsVO {
	
	private Integer bno; 		// 게시글 번호
	private String title; 		// 게시글 제목
	private String userid; 		// 글쓴이 id
	private String cont; 		// 글 내용
	private Date regdate; 		// 작성일
	private Integer vcount; 	// 뷰 카운트
	private Integer rcount; 	// 덧글 카운트
	private String contfile;	// 첨부파일
	private Integer cnt;		// 페이징 구성에 필요한 총 데이터 수

	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Integer getVcount() {
		return vcount;
	}
	public void setVcount(Integer vcount) {
		this.vcount = vcount;
	}
	public Integer getRcount() {
		return rcount;
	}
	public void setRcount(Integer rcount) {
		this.rcount = rcount;
	}
	public String getContfile() {
		return contfile;
	}
	public void setContfile(String contfile) {
		this.contfile = contfile;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "BbsVO [bno=" + bno + ", title=" + title + ", userid=" + userid
				+ ", cont=" + cont + ", regdate=" + regdate + ", vcount="
				+ vcount + ", rcount=" + rcount + ", contfile=" + contfile
				+ "]";
	}
}
