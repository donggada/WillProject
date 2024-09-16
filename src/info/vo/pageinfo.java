package info.vo;

public class pageinfo {
	private int page;
	private int maxpage;
	private int startpage;
	private int endpage;
	private int listcount;
	
	
	public pageinfo() {}

	
	public pageinfo(int page, int maxpage, int startpage, int endpage, int listcount) {
		super();
		this.page = page;
		this.maxpage = maxpage;
		this.startpage = startpage;
		this.endpage = endpage;
		this.listcount = listcount;
	}

	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxpage() {
		return maxpage;
	}
	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}
	public int getStartpage() {
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getEndpage() {
		return endpage;
	}
	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	public int getListcount() {
		return listcount;
	}
	public void setListcount(int listcount) {
		this.listcount = listcount;
	}
	
	
	
	
	
	
}
