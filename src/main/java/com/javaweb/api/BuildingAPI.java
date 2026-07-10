package com.javaweb.api;


import com.javaweb.Model.BuildingDTO;
import com.javaweb.Model.ErrorResponse;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class BuildingAPI {
    @Autowired
    private BuildingService buildingService;

    @GetMapping(value="/api/building/")
    public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> params, @RequestParam List<String> typeCode) {
        List<BuildingDTO> buildingDTOList = new ArrayList<>();
        buildingDTOList = buildingService.findAll(params, typeCode);
        return buildingDTOList;
    }

}
