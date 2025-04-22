package com.javaweb.Repository;

import java.util.List;
import java.util.Map;

import com.javaweb.Repository.Entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode);
}
