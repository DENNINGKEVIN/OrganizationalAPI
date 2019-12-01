package dao;

import models.Department;
import models.DepartmentNews;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{

    private final Sql2o sql2o;

    public Sql2oDepartmentDao (Sql2o sql2o){
        this.sql2o=sql2o;
    }
    @Override
    public void add(Department department){
        String sql = "INSERT INTO departments(name,description) VALUES (:name,:description)";
        try (Connection con=sql2o.open()){
            int id=(int) con.createQuery(sql,true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<Department> getAll(){
        try(Connection con=sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }
    @Override
    public Department findById(int id){
        try (Connection con=sql2o.open()){
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Department.class);
        }
    }
    @Override
    public List<User> getAllUsersByDepartment(int id){
        ArrayList<User> users=new ArrayList<>();
        String sql="SELECT * FROM users WHERE id = :departmentid";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(User.class);
        }    catch (Sql2oException ex){
            System.out.println(ex);
        }
        return users;
    }

    @Override
    public List<DepartmentNews> getAllDepartmentNewsForDepartment(int id){
        ArrayList<DepartmentNews> departmentNews=new ArrayList<>();
        String sql="SELECT * FROM news WHERE id = :departmentid AND type='department' ";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetch(DepartmentNews.class);
        }    catch (Sql2oException ex){
            System.out.println(ex);
        }
        return departmentNews;
    }

    @Override
    public void deleteById(int id){
        String sql="DELETE FROM departments WHERE id=:id";
        try(Connection con=sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteAll(){
        try(Connection con=sql2o.open()){
            con.createQuery("DELETE FROM departments")
                    .executeUpdate();
        }
    }


}
