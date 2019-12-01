import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oGeneralNewsDao;
import dao.Sql2oUserDao;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.User;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        Sql2oDepartmentDao departmentDao;
        Sql2oDepartmentNewsDao departmentNewsDao;
        Sql2oGeneralNewsDao generalNewsDao;
        Sql2oUserDao userDao;
        Connection conn;
        Gson gson=new Gson();

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao=new Sql2oDepartmentDao(sql2o);
        departmentNewsDao=new Sql2oDepartmentNewsDao(sql2o);
        generalNewsDao=new Sql2oGeneralNewsDao(sql2o);
        userDao=new Sql2oUserDao(sql2o);

        get("/departments", "application/json", (req, res) -> {
            System.out.println(departmentDao.getAll());
            if(departmentDao.getAll().size() > 0){
                return gson.toJson(departmentDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies , no departments are available.\"}";
            }
        });
        get("/users", "application/json", (req, res) -> {
            System.out.println(userDao.getAll());
            if(userDao.getAll().size() > 0){
                return gson.toJson(userDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies , no users are available.\"}";
            }
        });
        get("/generalnews", "application/json", (req, res) -> {
            System.out.println(generalNewsDao.getAll());
            if(generalNewsDao.getAll().size() > 0){
                return gson.toJson(generalNewsDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies, no general news are available.\"}";
            }
        });
        get("/departmentnews", "application/json", (req, res) -> {
            System.out.println(generalNewsDao.getAll());
            if(generalNewsDao.getAll().size() > 0){
                return gson.toJson(generalNewsDao.getAll());
            }
            else {
                return "{\"message\":\"Apologies , no departmental news are available.\"}";
            }
        });

        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });
        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            return gson.toJson(user);
        });
        post("/users/:userId/generalnews/new", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("userId"));
            GeneralNews generalNews = gson.fromJson(req.body(), GeneralNews.class);
//            generalNews.setCreatedat();
//            generalNews.setFormattedCreatedAt();
            generalNews.setUserid(userId); //we need to set this separately because it comes from our route, not our JSON input.
            generalNewsDao.add(generalNews);
            res.status(201);
            return gson.toJson(generalNews);
        });
        post("/users/:userId/department/:departmentId/departmentnews/new", "application/json", (req, res) -> {
            int userId = Integer.parseInt(req.params("userId"));
            int departmentId = Integer.parseInt(req.params("departmentId"));
            DepartmentNews departmentNews = gson.fromJson(req.body(), DepartmentNews.class);
//            departmentNews.setCreatedat(); //I am new!
//            departmentNews.setFormattedCreatedAt();
            departmentNews.setUserid(userId);
            departmentNews.setDepartmentid(departmentId); //we need to set this separately because it comes from our route, not our JSON input.
            departmentNewsDao.add(departmentNews);
            res.status(201);
            return gson.toJson(departmentNews);
        });



        //filters
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
