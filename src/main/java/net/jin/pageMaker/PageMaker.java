/*
 * This is a Jin-gamma Project
 * File name : PageMaker.java
 * Created by : Jinhyun
 * Created on : Feb 2020
 * Contents : Class for paging
 */
package net.jin.pageMaker;

public class PageMaker {
	private int totalcount;//전체 게시물 갯수
	private int pagenum;//현재 페이지 번호
	private int contentnum=5;//한 페이지에 몇개 표시할지 10->5 : 아래주석들은 한페이지에 10개 표시할때 기준
	private int startPage=1;//현재 페이지 블록의 시작 페이지
	private int endPage=10;//현재 페이지 블록의 마지막 페이지 5->10 : 아래주석들은 편재 블록의 마지막 페이지가 5일때 기준
	private boolean prev=false;//이전 페이지로 가는 화살표
	private boolean next;//다음 페이지로 가는 화살표
	private int currentblock;//현재 페이지 블록
	private int lastblock;//마지막 페이지 블록
	
	public void prevNext(int pagenum) {
		if(pagenum > 0 && pagenum < 11) {
			setPrev(false);
			setNext(true);
		}
		else if(getLastblock() == getCurrentblock()) {//5개씩 페이지의 그룹번호를 지정한다.
            //그룹 번호가 3이라는 것은 해당 페이지 그룹이 마지막이라는 것이기에 이전 화살표만 활성화한다 
            //이 두개가 같다면 마지막 블록이므로 이전만 있고 이후가 없다.
			setPrev(true);
			setNext(false);
		}
		else {
			setPrev(true);
			setNext(true);
		}
	}
	
	public int calcpage(int totalcount, int contentnum) { //전체 몇페이지까지 있을지 함수로 계산한다
        int totalpage = totalcount/contentnum;//전체 게시물 수를 한 페이지당 몇개 보이는지로 나눈다
        if (totalcount % contentnum>0) {//그리고 나머지가 있다면 1을 더해서 한 페이지 증가 시킨다
			totalpage++;
		}
		return totalpage;//페이지 갯수를 리턴한다
	}
	
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getContentnum() {
		return contentnum;
	}
	public void setContentnum(int contentnum) {
		this.contentnum = contentnum;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int currentblock) { //Setting currentBlock's Start page
		this.startPage = (currentblock*10)-9;
        //한 페이지에 5개씩 보여지므로
        //현재 페이지 블록의 번호 * 블록당 페이지의 개수(5) - 4를 하면 시작 페이지 번호를 정할 수 있다
		//1/1 2 3 4 5 --> 1
		//2/6 7 8 9 10 --> 6
		//3/11 12 13 14 15 ->11
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int getlastblock, int getcurrentblock) {//Setting currentBlock's End page
		if (getlastblock == getcurrentblock) {
			this.endPage = calcpage(getTotalcount(), getContentnum());
		} 
		else {
			this.endPage = getStartPage()+9;
		}
        //기본 시작페이지 +4
        //조건 , 마지막 페이지 블록이면 마지막 페이지 번호
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getCurrentblock() {
		return currentblock;
	}
	public void setCurrentblock(int pagenum) {//현재 페이지 블록의 번호가 몇번인지 지정해주는 함수
//      페이지번호 / 페이지 그룹 안의 페이지 개수(5)
//      ->나머지 있으면 더하기 1한다. -> 이 결과를 현재 블록 번호라고 부른다. cblock
		//현재 페이지 번호를 통해 구한다
		//1/5=0.2 -> 0.2 > 0 -> 0+1 = 1
		//10/5=0 -> 0 == 0 -> 2+0 = 2
		//11/5=0.2 -> 0.2 > 0 -> 2+1 = 3
		this.currentblock = pagenum/10;
		if(pagenum%10>0) {
			this.currentblock++;
		}
	}
	public int getLastblock() {
		return lastblock;
	}
	public void setLastblock(int totalcount) {//마지막 페이지 블록의 번호가 뭔지 지정해주는 함수
        //전체 글 개수를 사용해서 지정한다
		//페이지당 10개 게시물, 블록당 5페이지 그러므로 10*5=50개 게시물
		//totalcount = 125, contnum=10 일때  this.lastblock = 125/(5*10) = 2.5 -> (int)2.5 = 2
		//totalcount%(5*this.contentnum)= 0.25 > 0 -> this.lastblock++ ->< 2+1 = 3 
		this.lastblock = totalcount/(10*this.contentnum);
		if(totalcount%(10*this.contentnum)>0) {
			this.lastblock++;
		}
//      전체 글 개수(128) / 페이지 그룹 안의 페이지 개수(5) * 한페이지당 글 개수(10)
//      ->나머지 있으면 더하기 1한다. -> 이 결과를 마지막 블록 번호라고 부른다. last block
	}
	
	
}
