package com.moni.itbooksapp.app.model;

//import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Monica Shopova
 * monika.shopova@gmail.com
 */
public class BookDetails {

    @SerializedName("ID")
    private String id;

    private String isbn;

    @SerializedName("Title")
    private String title;

    @SerializedName("SubTitle")
    private String subTitle;

    @SerializedName("Author")
    private String author;

    @SerializedName("Publisher")
    private String publisher;

    @SerializedName("Year")
    private String year;

    @SerializedName("Page")
    private String numberOfPages;

    @SerializedName("Description")
    private String description;

    @SerializedName("Image")
    private String bookCoverImageUrl;

    @SerializedName("Download")
    private String downloadUrl;

    public String getBookCoverImageUrl() {
        return bookCoverImageUrl;
    }

    public void setBookCoverImageUrl(String bookCoverImageUrl) {
        this.bookCoverImageUrl = bookCoverImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
