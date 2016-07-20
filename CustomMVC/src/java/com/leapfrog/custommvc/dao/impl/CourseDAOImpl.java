/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.custommvc.dao.impl;

import com.leapfrog.custommvc.constant.SQLConstant;
import com.leapfrog.custommvc.dao.CourseDAO;
import com.leapfrog.custommvc.dbutil.DBConnection;
import com.leapfrog.custommvc.entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CourseDAOImpl implements CourseDAO {
        private DBConnection db = new DBConnection();
    @Override
    public List<Course> getAll() throws ClassNotFoundException,SQLException {
        List<Course> courseList = new ArrayList<>();
      // String sql = "SELECT * FROM tbl_courses";
        db.open();
        db.initsStatement(SQLConstant.COURSE_GETALL);
        ResultSet rs = db.executeQuery();
        while(rs.next()){
            Course c=new Course();
            c.setId(rs.getInt("course_id"));
            c.setName(rs.getString("course_name"));
            c.setDescreption(rs.getString("course_description"));
            c.setFees(rs.getDouble("fees"));
            c.setStatus(rs.getBoolean("status"));
            courseList.add(c);
        }
        db.close();
        return courseList;
    }

    @Override
    public int insert(Course c) throws ClassNotFoundException, SQLException {
        //String sql = "INSERT INTO tbl_courses (course_name,course_description,fees,status) VALUES(?,?,?,?)";
        db.open();
        PreparedStatement stmt = db.initsStatement(SQLConstant.COURSE_INSERT);
        stmt.setString(1, c.getName());
        stmt.setString(2, c.getDescreption());
        stmt.setDouble(3, c.getFees());
        stmt.setBoolean(4, c.isStatus());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    
    
}
