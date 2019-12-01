package models;

public class GeneralNews extends News{

    public static final String DATABASE_TYPE="GeneralNews";

    public GeneralNews(String content,String author,int rating,int userId,int departmentid){
        this.content=content;
        this.author=author;
        this.rating=rating;
        this.userId=userId;
        type=DATABASE_TYPE;
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

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }
}
