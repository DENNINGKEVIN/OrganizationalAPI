package models;

public abstract class News {
    public String content;
    public String author;
    public int rating;
    public int userId;
    public int id;

//    public News(String content,String author,int rating,int userId){
//        this.content=content;
//        this.author=author;
//        this.rating=rating;
//        this.userId=userId;
//    }

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

}
