package com.javaweb.repository.impl;

import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String DB_URL ="jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";

    public static StringBuilder joinSQL(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
        if (typeCode != null && typeCode.size() != 0) {
            sql.append(" INNER JOIN buildingrenttype t ON b.id = t.buildingid INNER JOIN renttype r ON r.id = b.id ");
        }
        for (Map.Entry<String, Object> item: params.entrySet()) {
            if (item.getKey().equals("staffid")) {
                sql.append(" INNER JOIN assignmentbuilding a ON b.id = a.buildingid ");
            }
        }
        return sql;
    }
    public static StringBuilder WhereAdapter(Map<String, Object> params, List<String> typeCode, StringBuilder sql){
        for (Map.Entry<String, Object> item : params.entrySet()) {
            if (item.getKey().equals("RentAreaFrom")) {
                String RentAreaFrom = item.getValue().toString();
                sql.append(" AND b.floorarea >=" + RentAreaFrom + " ");
            }
            else if (item.getKey().equals("RentAreaTo")) {
                String RentAreaTo = item.getValue().toString();
                sql.append(" AND b.floorarea <=" + RentAreaTo + " ");
            }
            else {
                if (!item.getKey().equals("typeCode")) {
                    sql.append(" AND " + item.getKey() + " LIKE '%" + item.getValue() + "%' ");
                }
            }
        }
        if (typeCode != null && typeCode.size() != 0) {
            List<String> typeCodenew = new ArrayList<>();
            for (int i = 0; i < typeCode.size(); i++) {
                String s = "'" + typeCode.get(i) + "'";
                typeCodenew.add(s);
            }
            sql.append(" AND code IN (").append(String.join(",",typeCodenew)).append(")");
        }

        return sql;
    }

    @Override
    public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building b");
        sql = joinSQL(params, typeCode, sql);
        StringBuilder where = new StringBuilder("WHERE 1=1 ");
        where = WhereAdapter(params, typeCode, where);
        sql.append(where);
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
