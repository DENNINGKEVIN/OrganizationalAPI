package models;

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
}
