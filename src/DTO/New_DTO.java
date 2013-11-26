package DTO;

public class New_DTO {
	private int manew;
	private String news;
	public int getManew() {
		return manew;
	}
	public void setManew(int manew) {
		this.manew = manew;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public New_DTO(int manew){
		this.manew = manew;
	}
	public New_DTO(int manew,String news){
		this.manew = manew;
		this.news = news;
	}
	public New_DTO() {
		// TODO Auto-generated constructor stub
	}
	
}
