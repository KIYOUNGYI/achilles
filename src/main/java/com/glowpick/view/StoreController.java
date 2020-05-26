package com.glowpick.view;

import com.glowpick.dto.ProductRankListByStoreDto;
import com.glowpick.dto.StoreListDto;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "스토어 API", tags = "StoreController")
public class StoreController {

    private Logger logger = LoggerFactory.getLogger(StoreController.class);

    @GetMapping("/api/v2/stores/hello")
    public String hello()
    {
        logger.debug(">>> hello from the other side");
        return "hello";
    }

    @GetMapping("/api/v2/stores")
    public StoreListDto store()
    {
        return null;
    }

    @GetMapping("/api/v2/stores/{id}/products")
    public ProductRankListByStoreDto productRankListByStore()
    {
        return null;
    }
}
