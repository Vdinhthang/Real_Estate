package com.javaweb.api;


import com.javaweb.Model.BuildingDTO;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @GetMapping(value="/api/building/")
    public List<BuildingDTO> getBuilding(@RequestParam(value="name", required = false) String name, @RequestParam(value="districtid", required = false) Long districtid ) {
        List<BuildingDTO> result = buildingService.findAll(name, districtid);
        return result;
    }
//    public void validate(BuildingDTO buildingDTO) throws FieldRequiredException {
//        if (buildingDTO.getName() == null ) {
//            throw new FieldRequiredException("Name or Number is invalid");
//        }
//    }
}
