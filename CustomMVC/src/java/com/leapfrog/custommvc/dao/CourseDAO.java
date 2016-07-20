/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.custommvc.dao;

import com.leapfrog.custommvc.entity.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public interface CourseDAO {
    List<Course> getAll()throws ClassNotFoundException,SQLException;
    int insert(Course c)throws ClassNotFoundException,SQLException;
}
