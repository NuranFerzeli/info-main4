package com.firstnews.info.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class NewsModel {
	public NewsModel() {
	}
    public NewsModel(Long id, Date newsDate, String newsTitle, String newsName, String imageName) {
		super();
		this.id = id;
		this.newsDate = newsDate;
		this.newsTitle = newsTitle;
		this.newsName = newsName;
		this.imageName = imageName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	private Long id;
    private Date newsDate;
    private String newsTitle;
    private String newsName;
    private String imageName;
}
