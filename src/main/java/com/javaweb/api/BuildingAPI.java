package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.CustomException.FieldRequiredException;
import com.javaweb.Model.BuildingDTO;
import com.javaweb.Model.ErrorResponseDTO;
import com.javaweb.Service.BuildingService;

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;//ko duoc goi truc tiep ma phai su dung annotation @Autowired
	
	@GetMapping(value="/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params,
										@RequestParam(value="typeCode", required = false) List<String> typeCode) {
		List<BuildingDTO> result = buildingService.findAll(params, typeCode);
		return result;
	}

	// su dung @RequestMapping

//	@RequestMapping(value = "api/building", method = RequestMethod.GET)
//	public void getBuilding(@RequestParam(value = "name") String nameBuilding,
//							@RequestParam(value = "ward") String wardBuilding) {
//		System.out.println(nameBuilding + " " + wardBuilding);
//	}

	// su dung @RequestBody

//	@GetMapping(value = "api/building/")
//	public List<BuildingDTO> getBuilding2(@RequestParam(value = "name", required = false) String nameBuilding,
//									@RequestParam(value = "NOB", required = false) Integer NOB,
//									@RequestParam(value = "street", required = false) String street,
//									@RequestParam(value = "ward", required = false) String ward){
//		List<BuildingDTO> listBuilding = new ArrayList<>();
//		BuildingDTO bd1 = new BuildingDTO();
//		bd1.setName("KangNam");
//		bd1.setNOB(1);
//		bd1.setStreet("Pham Hung");
//		bd1.setWard("Ha Noi");
//		BuildingDTO bd2 = new BuildingDTO();
//		bd2.setName("LandMark72");
//		bd2.setNOB(2);
//		bd2.setStreet("Pham Hung");
//		bd2.setWard("Ha Noi");
//		listBuilding.add(bd1);
//		listBuilding.add(bd2);
//		return listBuilding;
//	}

//	@PostMapping(value = "api/building/")
//	public List<BuildingDTO> postBuilding(@RequestBody BuildingDTO buidingDTO) {
//		List<BuildingDTO> listBuilding = new ArrayList<>();
//		BuildingDTO bd1 = new BuildingDTO();
//		bd1.setName("KangNam");
//		bd1.setNOB(1);
//		bd1.setStreet("Pham Hung");
//		bd1.setWard("Ha Noi");
//		BuildingDTO bd2 = new BuildingDTO();
//		bd2.setName("LandMark72");
//		bd2.setNOB(2);
//		bd2.setStreet("Pham Hung");
//		bd2.setWard("Ha Noi");
//		listBuilding.add(bd1);
//		listBuilding.add(bd2);
//		return listBuilding;
//	}

//	@RequestMapping(value = "api/building", method = RequestMethod.POST)
//	@ResponseBody
//	public BuildingDTO getBuilding2(@RequestBody BuildingDTO buildingDTO) {
//		System.out.println("Chay roi nhe!");
//		return buildingDTO;
//	}

//	@GetMapping(value = "/api/building/")
//	public Object getBuilding(@RequestParam(value = "name", required = false) String nameBuilding,
//			@RequestParam(value = "NOB", required = false) Integer numberOfBasement,
//			@RequestParam(value = "ward", required = false) String ward) {
//		xu ly duoi DB xong roi
//		try {
//			System.out.println(5 / 1);
//		} catch (Exception e) {
//			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//			errorResponseDTO.setError(e.getMessage());
//			List<String> details = new ArrayList<String>();
//			details.add("So nguyen lam sao chia cho so 0 duoc?");
//			errorResponseDTO.setDetails(details);
//			return errorResponseDTO;
//		}
//
//		BuildingDTO result = new BuildingDTO();
//		result.setName(nameBuilding);
//		result.setNOB(numberOfBasement);
//		result.setWard(ward);
//		return result;
//	}
	
//	@PostMapping(value = "/api/building/")
//	public Object getBuilding(@RequestBody BuildingDTO buildingDTO) {
////		xu ly duoi DB xong roi
//		try {
//			validDate(buildingDTO);
//		} catch (FieldRequiredException e) {
//			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//			errorResponseDTO.setError(e.getMessage());
//			List<String> details = new ArrayList<String>();
//			details.add("So nguyen lam sao chia cho so 0 duoc?");
//			errorResponseDTO.setDetails(details);
//			return errorResponseDTO;
//		}
//		return null;
//	}
	
//	public void validDate(BuildingDTO buildingDTO) throws FieldRequiredException  {
//		if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNOB() == null) {
//			throw new FieldRequiredException("name or numberofbasement is null!");
//		}
//	}
	
	
	//Khi chưa xử lý HTTP status
//	@PostMapping(value="/api/building/")
//	public Object postBuilding(@RequestBody BuildingDTO buildingDTO) {
//		try {
////			System.out.print(5/0);
//			validDate(buildingDTO);
//		} catch (FieldRequiredException e) {
//			ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//			List<String> details = new ArrayList<String>();
////			details.add("So nguyen khong chia het duoc cho 0!");
//			details.add("check lai name hoac numberofbasement!");
//			errorResponseDTO.setError(e.getMessage());
//			errorResponseDTO.setDetails(details);
//			return errorResponseDTO;
//			// TODO: handle exception
//		}
//		
//		return null;
//	}
	
//	public void validDate(BuildingDTO buildingDTO) throws FieldRequiredException{
//		if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNOB() == null) {
//			throw new FieldRequiredException("name or numberofbasement is null!");
//		}
//	}

	// Khi đã xử lý HTTP status ở ControllerAdvice
//	@PostMapping(value = "/api/building/")
//	public Object postBuilding(@RequestBody BuildingDTO buildingDTO) {
////		System.out.println(5/0);
//		validDate(buildingDTO);
//		return null;
//	}
//	
//	public void validDate(BuildingDTO buildingDTO) {
//		if(buildingDTO.getName() == null || buildingDTO.getName().equals("") || buildingDTO.getNOB() == null) {
//			throw new FieldRequiredException("name or numberofbasement is null!");
//		}
//	}

}
