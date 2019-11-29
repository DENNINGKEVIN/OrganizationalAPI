package models;

import java.util.Objects;

public class News {
    private String content;
    private String author;
    private int rating;
    private int userId;
    private int id;

    public News(String content,String author,int rating,int userId){
        this.content=content;
        this.author=author;
        this.rating=rating;
        this.userId=userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return rating == news.rating &&
                userId == news.userId &&
                id == news.id &&
                Objects.equals(content, news.content) &&
                Objects.equals(author, news.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, author, rating, userId, id);
    }
}
