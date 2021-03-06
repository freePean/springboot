package com.dx.springboot.service;

import com.dx.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> getList(){
        String sql = "SELECT ID, NAME, AGE, SCORE_SUM, SCORE_AVG FROM STUDENT";

        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student stu = new Student();
                stu.setId(rs.getInt("ID"));
                stu.setName(rs.getString("NAME"));
                stu.setAge(rs.getInt("AGE"));
                stu.setAvgScore(rs.getString("SCORE_AVG"));
                stu.setSumScore(rs.getString("SCORE_SUM"));

                return stu;
            }
        });
    }

}
