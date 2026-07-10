package com.javaweb.service;

import com.javaweb.Model.BuildingDTO;
import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode);
}
