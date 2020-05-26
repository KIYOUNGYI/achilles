package com.glowpick.view;

import com.glowpick.dto.PickListResponseDTO;
import com.glowpick.handler.ResultHandler;
import com.glowpick.services.PickService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Api(tags="PickController",description = "캐스트 관리")
@RestController
@RequestMapping("/api/v2/picks")
public class PickController
{
    private Logger logger = LoggerFactory.getLogger(PickController.class);

    @Autowired
    PickService pickService;
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
     * @return
     */
    @ApiOperation(value = "구 카테고리 단순 검색")
    @GetMapping("")
    private ResponseEntity<?> picksAll()
    {
        logger.debug("GET /api/v2/picks");
        Map<String, Object> result = pickService.getPicksAll();
        logger.debug("result:",result);
        return new ResultHandler().handle(result);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> picksOne()
    {
        logger.debug("GET /api/v2/picks/{pick_id}");
        return null;
    }

    @GetMapping("/{id}/banners")
    private ResponseEntity<?> bannersOne()
    {
        logger.debug("GET /api/v2/picks/{pick_id}/banners픽 ");
        return null;
    }

    @GetMapping("/{id}/comments")
    private ResponseEntity<?> commentsAll()
    {
        logger.debug("GET /api/v2/picks/{pick_id}/comments");
        return null;
    }

    @PostMapping("/{id}/comments")
    private Object comment(@RequestBody Object obj)
    {
        logger.debug("GET /api/v2/picks/{pick_id}/products");
        return  null;
    }

    @DeleteMapping("/comments/{id}")
    private Object comment()
    {
        logger.debug("GET /api/v2/picks/{pick_id}/products");
        return null;
    }

    @DeleteMapping("/{pick_id}/like")
    private Object like()
    {
        logger.debug("DELETE /api/v2/picks/{pick_id}/like");
        return null;
    }

    @GetMapping("/{pick_id}/like")
    private Object likeAll()
    {
        logger.debug("GET /api/v2/picks/{pick_id}/like");
        return null;
    }
    @PostMapping("/{pick_id}/like")
    private Object like(@RequestBody Object object)
    {
        logger.debug("POST /api/v2/picks/{pick_id}/like");
        return null;
    }

    @GetMapping("/{pick_id}/products")
    private Object productOne()
    {
        logger.debug("GET /api/v2/picks/{pick_id}/products");
        return null;
    }
}
