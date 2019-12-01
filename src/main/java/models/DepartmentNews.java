package models;

import java.util.Objects;

public class DepartmentNews extends News{
    private int id;
    private int departmentid;
    private static final String DATABASE_TYPE="DepartmentNews";

    public DepartmentNews(String content,String author,int rating,int userId,int departmentid){
        this.content=content;
        this.author=author;
        this.rating=rating;
        this.userId=userId;
        this.departmentid=departmentid;
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

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentNews that = (DepartmentNews) o;
        return id == that.id &&
                departmentid == that.departmentid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentid);
    }
}
