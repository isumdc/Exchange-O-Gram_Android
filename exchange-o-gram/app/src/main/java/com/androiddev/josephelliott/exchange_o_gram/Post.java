package com.androiddev.josephelliott.exchange_o_gram;

import java.util.Date;

/**
 * Created by Joseph Elliott on 1/12/2016.
 */
public class Post {
    private String url, caption, author;
    private Date date;

    public Post() {
        url = "";
        caption = "";
        author = "";
        date = null;
    }
    public Post(String u, String c, String a, Date d) {
        this.url = u;
        this.caption = c;
        this.author = a;
        this.date = d;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
