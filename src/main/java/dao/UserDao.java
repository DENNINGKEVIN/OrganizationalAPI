package dao;

import models.*;

import java.util.List;

public interface UserDao {
    //CREATE
    void add(User user);
    void addUserToDepartment(User user, Department department);

    //READ
    List<User> getAll();
    User findById(int id);
    List<GeneralNews> getAllGerneralNewsForUser (int id);
    List<DepartmentNews> getAllDepartmentNewsForUser (int id);

    //UPDATE


    //DELETE
    void deleteById(int id);
    void deleteAll();
}
