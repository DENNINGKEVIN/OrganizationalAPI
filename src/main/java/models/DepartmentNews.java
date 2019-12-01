package models;

import java.util.Objects;

public class DepartmentNews extends News{
    private int departmentid;
    private static final String DATABASE_TYPE="department";

    public DepartmentNews(String content,int userid,int departmentid){
        this.content=content;
        this.userid=userid;
        this.departmentid=departmentid;
        type = DATABASE_TYPE;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getDatabaseType() {return DATABASE_TYPE;}

    public int getDepartmentid() {return departmentid;}

    public void setDepartmentid(int departmentid) {this.departmentid = departmentid;}

    public String getType() { return type; }

    public void setType(String type) { type = DATABASE_TYPE;}

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
