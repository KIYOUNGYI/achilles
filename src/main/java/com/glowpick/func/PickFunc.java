package com.glowpick.func;

import com.glowpick.dto.PickListResponseDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Component;

@Component
public class PickFunc
{

    public static PickListResponseDTO getPicksAll()
    {
        PickListResponseDTO pickListResponseDTO = new PickListResponseDTO();
        return pickListResponseDTO;
    }
}
