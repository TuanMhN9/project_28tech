package com.javaweb.Service.Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.Model.BuildingDTO;
import com.javaweb.Repository.BuildingRepository;
import com.javaweb.Repository.Entity.BuildingEntity;
import com.javaweb.Service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public List<BuildingDTO> findAll(Map<String, Object> params) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params);
		List<BuildingDTO> result = new ArrayList<>();
		for (BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setAdress(item.getStreet() + ", " + item.getWard());
//			building.setNOB(item.getNOB());
			result.add(building);
		}
		return result;
	}

}
