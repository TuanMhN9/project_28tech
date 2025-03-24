package com.javaweb.Repository;

import java.util.List;

import com.javaweb.Repository.Entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> FindAll(String name, Long district);
}
