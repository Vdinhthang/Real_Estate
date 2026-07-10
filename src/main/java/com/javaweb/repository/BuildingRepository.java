package com.javaweb.repository;

import com.javaweb.repository.entity.BuildingEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface BuildingRepository {
    List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode);
}
