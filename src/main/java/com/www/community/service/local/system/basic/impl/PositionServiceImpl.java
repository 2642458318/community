package com.www.community.service.local.system.basic.impl;

import com.www.community.dao.mapper.system.basic.PositionMapper;
import com.www.community.model.entity.hr.Position;
import com.www.community.service.local.system.basic.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionMapper positionMapper;

    @Override
    public List<Position> getAllPosition() {

        return positionMapper.getAllPositions();
    }
}
