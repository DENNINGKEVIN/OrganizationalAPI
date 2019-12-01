package models;

import models.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
public class DepartmentTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
//helper
    public Department setUpDepartment(){
        return new Department("Animations","Where animations come to life");
    }

    @Test
    public void instanciatesCorrectly_true(){
        Department testDepartment=setUpDepartment();
        assertEquals(true,testDepartment instanceof Department);
    }

    @Test
    public void getName_instanciatesWithName_true(){
        Department testDepartment=setUpDepartment();
        assertEquals("Animations",testDepartment.getName());
    }
    @Test
    public void setName_setAName_true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setName("Dundaing");
        assertEquals("Dundaing",testDepartment.getName());
    }
    @Test
    public void getDescription_instanciatesWithDescription_true(){
        Department testDepartment=setUpDepartment();
        assertEquals("Where animations come to life",testDepartment.getDescription());
    }
    @Test
    public void setDescription_setADescription_true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setDescription("Where Animations are made");
        assertEquals("Where Animations are made",testDepartment.getDescription());
    }
    @Test
    public void setId_setAnId_true(){
        Department testDepartment=setUpDepartment();
        testDepartment.setId(4);
        assertEquals(4,testDepartment.getId());
    }



}

