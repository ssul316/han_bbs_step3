package org.han.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PageMaker {
	
	private int page; 					// 현재 페이지 - 기준값
	private int cnt; 					// 현재 화면의 페이징을 구성하는데 필요한 데이터의 수 - 기준값
	private int lineCount; 				// 화면에서 보여주는 페이지 수 - 고정값
	private int perPage; 				// 한 페이지에서 보여줄 게시물의 수 - 고정값
	private int first; 					// lineCount의 첫 번호
	private int last; 					// lineCount의 마지막 번호
	private boolean hasNext = false;	// next버튼 표현여부
	private boolean hasPrev = false;	// prev버튼 표현여부
	private int rowNum;					// cnt를 생각하지 않은 페이징 구성에 필요한 데이터 값
	private String keyword;				// 검색 키워드
	private Map<String, String> criMap;	// 검색구분, 키워드
	private Map<String, String> colMap;	// 검색구분, 검색구분에 따른 sql문
	private List<String> values;		// criMap의 value값과 dummy의 배열
	private String[] types;				// 검색구분을 담아두는 배열
	
	public PageMaker(){
		this(1);
	}
	
	public PageMaker(int page){
		this(page,0);
	}
	
	public PageMaker(int page, int cnt) {
		this(page, cnt, 5,10);
	}
	
	public PageMaker(int page, int cnt, int lineCount, int perPage) {
		super();
		this.page = page;
		this.cnt = cnt;
		this.lineCount = lineCount;
		this.perPage = perPage;
		this.first = 1;
		this.last = 5;
		
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
		setPage();
	}
	public int getLineCount() {
		return lineCount;
	}
	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean isHasPrev() {
		return hasPrev;
	}
	public void setHasPrev(boolean hasPrev) {
		this.hasPrev = hasPrev;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Map<String, String> getCriMap() {
		return criMap;
	}
	public void setCriMap(Map<String, String> criMap) {
		this.criMap = criMap;
	}
	public Map<String, String> getColMap() {
		return colMap;
	}
	public void setColMap(Map<String, String> colMap) {
		this.colMap = colMap;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	
	public void setPage(){
		rowNum = ((int)(Math.ceil(page/(double)lineCount)))*(perPage*lineCount)+1;
		last = ((int)(Math.ceil(page/(double)lineCount)))*lineCount;
		first = last-(lineCount-1);
		
		if(cnt == rowNum){
			hasNext = true;
		}else{
			hasNext = false;
			last = last-((int)(Math.floor((rowNum-cnt)/10)));
		}
		
		if(((perPage*lineCount)+1) < cnt){
			hasPrev = true;
		}else{
			hasPrev = false;
		}
	}
	
	public String checked(String word){
		
		if(types == null || types.length == 0){
			return "";
		}
		
		for (String type : types) {
			if(word.equals(type)){
				return "checked";
			}
		}
		return "";
	}
	
	public String getSql(){
		if(keyword == null || keyword.length() == 0 || types == null){
			return "";
		}
		
		criMap = new HashMap<String, String>();
		colMap = new HashMap<String, String>();
		colMap.put("t", "title");
		colMap.put("w", "userid");
		colMap.put("c", "cont");
		
		for (String word : types) {
			criMap.put(word, keyword);
		}
		
		StringBuilder builder = new StringBuilder(" where ");
		
		Iterator<String> iter = criMap.keySet().iterator();
		
		values = new ArrayList<String>();
		
		for (int i = 0; i < criMap.size(); i++) {
			values.add("dummy");
		}
		
		while(iter.hasNext()){
			String key = iter.next();
			values.add(criMap.get(key));
			
			builder.append(colMap.get(key) + " like '%'||#{key}||'%' or ");
		}
		
		return builder.substring(0, builder.length()-3);
	}
	
	public String getKey() {
		return values.remove(0);
	}
	
	@Override
	public String toString() {
		return "PageMaker! [page=" + page + ", cnt=" + cnt + ", lineCount="
				+ lineCount + ", perPage=" + perPage + ", first=" + first
				+ ", last=" + last + ", hasNext=" + hasNext + ", hasPrev="
				+ hasPrev + ", rowNum=" + rowNum + ", keyword=" + keyword
				+ ", criMap=" + criMap + ", colMap=" + colMap + ", values="
				+ values + ", types=" + Arrays.toString(types) + "]";
	}
	
	
}
