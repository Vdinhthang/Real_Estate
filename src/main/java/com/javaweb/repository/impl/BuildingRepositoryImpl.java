package com.javaweb.repository.impl;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL ="jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";
    @Override
    public List<BuildingEntity> findAll(String name, Long districtid) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building where 1 = 1 ");
        if (name == null || !name.equals("")) {
            sql.append("And building.name like '%" + name + "%' " );
        }
        if (districtid == null) {
            sql.append("AND building.districtid = " + districtid + " ");
        }
        List<BuildingEntity> result = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql.toString())) {
            while (rs.next()) {
                BuildingEntity building = new BuildingEntity();
                building.setName(rs.getString("name"));
                building.setNumberofbasement(rs.getInt("numberofbasement"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                result.add(building);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connected database failed ... ");
        }
        return  result;
    }
}
