package com.glowpick.services.impl;

import com.glowpick.data.repository.PickRepository;
import com.glowpick.dto.PickListResponseDTO;
import com.glowpick.services.PickService;
import com.glowpick.view.PickController;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PickServiceImpl implements PickService {


    private Logger logger = LoggerFactory.getLogger(PickServiceImpl.class);

    @Autowired
    PickRepository pickRepository;

//    @Autowired
//    JPAQueryFactory jpaQueryFactory;

    /**
     *
     * input: category_id
     * {
     *   "picks": [
     *     {
     *       "pick_id": 0
     *     }
     *   ],
     *   "categories": [
     *     {
     *       "category_id": 0,
     *       "name": "string",
     *       "is_new": true
     *     }
     *   ],
     *   "total_count": 0,
     *   "paging": {
     *     "next": "string"
     *   }
     * }
     * */
    @Override
    public Map<String, Object> getPicksAll()
    {
        logger.debug("PickServiceImpl getPicksAll");
        Map<String, Object> result = new HashMap<>();
        PickListResponseDTO pickListResponseDTO = new PickListResponseDTO();

        List<Map<String,Object>> picks = new ArrayList<>();
        Map<String,Object> pickOne = new HashMap<>();
        pickOne.put("pick_id",0);
        List<Map<String,Object>> categories = new ArrayList<>();
        Map<String,Object> category = new HashMap<>();
        category.put("category_id",0);
        category.put("name","name");
        category.put("is_new",true);



        result.put("data",pickListResponseDTO);
        return result;
    }
}
