package com.javaweb.service.BuildingServiceImpl;


import com.javaweb.Model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<BuildingDTO> findAll(String name, Long districtid) {
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(name, districtid);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO building = new BuildingDTO();
            building.setName(item.getName());
            building.setNumberofbasement(item.getNumberofbasement());
            building.setAddress(item.getStreet() + "," + item.getWard());
            result.add(building);
        }
        return result;
    }
}
