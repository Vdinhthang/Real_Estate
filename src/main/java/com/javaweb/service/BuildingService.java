package com.javaweb.service;

import com.javaweb.Model.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll(String name, Long districtid);
}
