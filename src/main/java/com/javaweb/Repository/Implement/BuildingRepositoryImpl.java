package com.javaweb.Repository.Implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.NumberUp;

import org.springframework.stereotype.Repository;

import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.Entity.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic1";
	static final String USER = "root";
	static final String PASS = "tuancn04@";

	public static void joinTable(Map<String, Object> params, List<String> typeCode, StringBuilder sql) {
		String staffId = (String)params.get("staffId");
		if(StringUtil.checkString(staffId)) {
			sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		if(typeCode != null && typeCode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
		}
		String rentAreaFrom = (String)params.get("areaFrom");
		String rentAreaTo = (String)params.get("areaTo");
		
		if(StringUtil.checkString(rentAreaTo) || StringUtil.checkString(rentAreaFrom)) {
			sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
		}
	}
	

	public static void queryNormal(Map<String, Object> params, StringBuilder where) {
		for(Map.Entry<String, Object> it : params.entrySet()) {
			if(!it.getKey().equals("staffId") && !it.getKey().equals("typeCode") && !it.getKey().startsWith("area") && !it.getKey().startsWith("rentPrice")) {
				String value = it.getValue().toString();
				if(StringUtil.checkString(value)) {
					if(NumberUtil.isNumber(value)) {
						where.append(" AND b." + it.getKey() + " = " + value + " ");
					}
					else {
						where.append(" AND b." + it.getKey() + " LIKE '%" + value + "%' ");
					}
				}
			}
		}
	}
	

	public static void querySpecial(Map<String, Object> params, List<String> typeCode, StringBuilder where) {
		String staffId = (String)params.get("staffId");
		if(StringUtil.checkString(staffId)) {
			where.append(" AND assignmentbuilding.staffId = " + staffId);
		}
		
		String rentAreaFrom = (String)params.get("areaFrom");
		String rentAreaTo = (String)params.get("areaTo");
		if(StringUtil.checkString(rentAreaFrom) || StringUtil.checkString(rentAreaTo)) {
			if(StringUtil.checkString(rentAreaFrom)) {
				where.append(" AND rentarea.value >= " + rentAreaFrom);
			}
			if(StringUtil.checkString(rentAreaTo)) {
				where.append(" AND rentarea.value <= " + rentAreaTo);
			}
		}
		
		if(typeCode != null && typeCode.size() != 0) {
			where.append(" AND rentype.code IN(" + String.join(",", typeCode) + ") ");
		}
	}
	
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode) {
		StringBuilder sql = new StringBuilder(" SELECT b.id, b.name, b.districtid, b.street, b.ward, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphone, b.servicefee, b.brokeragefee\r\n"
				+ "FROM building b ");
		joinTable(params, typeCode, sql);
		StringBuilder where = new StringBuilder(" WHERE 1=1 ");
		queryNormal(params, where);
		querySpecial(params, typeCode, where);
		sql.append(where);
		System.out.println(sql);
		List<BuildingEntity> result = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("id"));
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setDistrictId(rs.getLong("districtId"));
				building.setFloorArea(rs.getLong("floorarea"));
				building.setRentPrice(rs.getLong("rentprice"));
				building.setManagerName(rs.getString("managername"));
				building.setManagerPhone(rs.getString("managerphone"));
				building.setServicefee(rs.getString("servicefee"));
				building.setBrokeragefee(rs.getLong("brokeragefee"));
				
				result.add(building);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
