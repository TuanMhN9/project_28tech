package com.javaweb.Repository.Implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.javaweb.Model.BuildingDTO;
import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.Entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic1";
	static final String USER = "root";
	static final String PASS = "tuancn04@";

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1");
//		if(name != null && name.equals("")) {
//			sql.append(" AND b.name like '%" + name + "%' ");
//		}
//		if(districtId != null) {
//			sql.append(" AND b.district = " + districtId + " ");
//		}
		List<BuildingEntity> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
//				building.setNOB(rs.getLong("NOB"));
				result.add(building);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
