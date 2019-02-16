package com.example.edon.bhis.Custom.Models;

public class Advices {

    public Integer Id;
    public String ImageUrl;
    public String Title;
    public String Content;
    public String Publisher;

    public Advices() {
    }

    public Advices(Integer id, String imageUrl, String title, String content, String publisher) {
        Id = id;
        ImageUrl = imageUrl;
        Title = title;
        Content = content;
        Publisher = publisher;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }
}
