package com.glowpick.dto;

import lombok.Data;

import java.util.List;

/**
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
 */
@Data
public class PickListResponseDTO
{
    private List<Pick> picks;
    private List<Categories> categories;
    private int totalCount;
    private List<?> paging;

    @Data
    public class Pick
    {
        private int pick_id;
        private String pick_image;
    }

    @Data
    public class Categories
    {
        private int category_id;
        private String name;
        private boolean is_new;
    }

}


/**
 * "graph_review": { ___"scoreboard": { ______"blinded": 59, ______"ratings": { ______"point_1": 17, ______"point_2": 42, ______"point_3": 202, ______"point_4": 526, ______"point_5": 443 ___} },
 * "total_count": 1230, "positive_review": { ___"review_id": 3269871, ___"rating": 4, ___"is_evaluation": false, ___"like_count": 34, ___"contents": ":star: 필자의 사용 당시 피부 유형은 ' 유수분부족형건성 ' 입니다.\n:star:
 * 사용한 기간은 ' 12월 1일 ~1월 26일 ' 입니다.\n\n:heavy_check_mark: 보습 : 겨울에 사용하기 적합한 훌륭한 보습력 입니다. 확실히 보습에 치중한 스킨이 아니였나 싶습니다.\n\n:heavy_check_mark: 피지 제거 : 무난하게 잘 닦여나갑니다. \n\n:heavy_check_mark: 피부결 정돈 : 정돈 되는
 * 느낌은 실감하지 못했습니다.\n\n:heavy_check_mark: 향 : 사용하기 부담없는 편안한 향입니다. \n\n:heavy_check_mark: 가용비, 가성비 : 가용비는 1ml당 90원으로서 괜찮은 편에 속한다 생각합니다. 가성비는 저에게 무난하였으나, 속당김이 고민이신 분들은 좋지 않을까 예상합니다.
 * \n\n:heavy_check_mark: 용기 : 용기에 어느정도 압력을 가해야만 내용물이 자연스럽게 나오는것이 조금 불편하였으나 거슬릴 정도는 아니였습니다.\n\n:heavy_check_mark: 추천, 비추천 : 속당김이 심하신 분과 7스킨법을 애용하시는 보습력을 중요시하는 분들께 추천드립니다. 또한 건성 겨울 스킨, 민감성 스킨 으로 적합한거
 * 같습니다. 피부결 정돈을 중요시하는 분들, 중성 여름스킨, 지성 스킨 으로선 적합하지 않습니다.\n\n:heavy_check_mark: 총평 : 겨울에 사용하기 훌륭한 스킨이지만, 스킨에 보습을 크게 치중하지 않는 저로선 별도의 장점요인이 보이지 않았던 스킨이였던것 같아 아쉬웠습니다.\n\n#보습스킨 #보습토너 #속당김해결스킨 #속당김해결토너
 * #건성겨울스킨 #건성겨울토너 #민감성스킨 #민감성토너", ___"state": "N", ___"created_at": "2017-02-01T04:44:50Z", ___"editor": { ______"user_id": 557181, ______"email": "f_you_b@naver.com", ______"nickname": "푸스",
 * ______"age": 21, ______"birth_year": 2000, ______"gender": "m", ______"skin_type": "지성", ______"review_count": 21, ______"profile_image": null, ______"rank": 4735, ______"is_blinded": 0 ___} },
 * "positive_review_count": 969, "negative_review": { ___"review_id": 5254981, ___"rating": 3, ___"is_evaluation": false, ___"like_count": 1, ___"contents": "평범한것같아요 토너 유목민인데 아직도 맞는 토너 찾기가 힘들지만 그냥 이건
 * 평범 하게̌̈ 썼던것같아요 저는 진짜 지성에다가 기름 좔좔 흐르는 트러블도 많아서 맞는 화장품 쓰면 여드름이 쏙 들어가는데 이건 그럼제품은 아니였던걸로 기억해요,,,그냥 평범한 토너입니당 딱히 또쓰고꙼̈ 싶지는 않고꙼̈ 주면 쓰거나 없으면 쓰는 정도 그냥 거쳐 갔던것 같아요 완전 지성이라 딴로션이랑 같이바르면 땡기지도 않고꙼̈ 그냥 완전 액체고꙼̈
 * 무난템 이였어요 순하다는 느낌은 못받았고꙼̈,,그래도 이거바르고꙼̈ 과다로 기름분비는 되지않았어여 평범한 토너 찾으면 사는거 추천￼", ___"state": "N", ___"created_at": "2020-02-07T11:03:26Z", ___"editor": { ______"user_id": 1035624, ______"email":
 * "yunalee335@gmail.com", ______"nickname": "이줄라", ______"age": 18, ______"birth_year": 2003, ______"gender": "f", ______"skin_type": "지성", ______"review_count": 23, ______"profile_image":
 * "https://d9vmi5fxk1gsw.cloudfront.net/prod/register/1035624/1532324311887.jpg", ______"rank": 41031, ______"is_blinded": 0 ___} }, "negative_review_count": 261 }
 */