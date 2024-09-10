package board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class Pagination {
    
    private String display; // 화면에 보여지는것
    private int pageNo;  // 페이지번호
    private boolean curPage; // 현재 페이지인지 아닌지 여부
	@Override
	public String toString() {
		return "Pagination [display=" + display + ", pageNo=" + pageNo + ", curPage=" + curPage + "]";
	}
	public Pagination(String display, int pageNo, boolean curPage) {
		super();
		this.display = display;
		this.pageNo = pageNo;
		this.curPage = curPage;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public boolean isCurPage() {
		return curPage;
	}
	public void setCurPage(boolean curPage) {
		this.curPage = curPage;
	}
    
}
