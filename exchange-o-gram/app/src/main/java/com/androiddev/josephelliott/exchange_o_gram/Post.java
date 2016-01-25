package com.androiddev.josephelliott.exchange_o_gram;

import java.util.Date;

/**
 * Created by Joseph Elliott on 1/12/2016.
 */
public class Post {
    private static final String API_URL = "http://exchangeogram.web.ianmcdowell.net/";

    private String id, url, caption, author;
    private Date date;

    public Post() {
        url = "";
        caption = "";
        author = "";
        date = null;
    }
    public Post(String id, String u, String c, String a, Date d) {
        this.url = u;
        this.caption = c;
        this.author = a;
        this.date = d;
    }

    public String getId() { return id; }
    public long getIdAsLong() { return Long.parseLong(id);}

    public void setId(String id) { this.id = id; }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullImageUrl() {
        return API_URL.concat(url);
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
