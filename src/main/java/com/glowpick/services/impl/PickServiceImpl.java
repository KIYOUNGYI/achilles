package com.glowpick.services.impl;

import com.component.ServiceComponent;
import com.glowpick.data.repository.PickRepository;
import com.glowpick.dto.PickListResponseDTO;
import com.glowpick.func.PickFunc;
import com.glowpick.services.PickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PickServiceImpl extends ServiceComponent implements PickService {

    @Autowired
    PickRepository pickRepository;

    @Override
    public Map<String, Object> getPicksAll()
    {
        Map<String, Object> result = new HashMap<>();
        PickListResponseDTO pickListResponseDTO = PickFunc.getPicksAll();
        result.put("data",pickListResponseDTO);

        return result;
    }
}
