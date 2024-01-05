## 그룹별 조건에 맞는 식당 목록 출력하기 (Lv.4)

> MEMBER_PROFILE와 REST_REVIEW 테이블에서 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회하는 SQL문을 작성해주세요. 회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성해주시고, 결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬해주세요.

```
SELECT
m.MEMBER_NAME
,r.REVIEW_TEXT
,date_format(r.REVIEW_DATE,"%Y-%m-%d") as REVIEW_DATE
from REST_REVIEW r
join MEMBER_PROFILE m on m.MEMBER_ID=r.MEMBER_ID
WHERE m.member_id = (
    SELECT member_id
    FROM REST_REVIEW
    GROUP BY member_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
ORDER BY r.review_date ASC, r.review_text ASC;
```

## 보호소에서 중성화한 동물 (Lv.4)

> 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다. 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.

```
SELECT
i.ANIMAL_ID
,i.ANIMAL_TYPE
,i.NAME
from ANIMAL_INS i
join ANIMAL_OUTS o on o.ANIMAL_ID=i.ANIMAL_ID
where 1=1
and i.SEX_UPON_INTAKE like "Intact%"
and (o.SEX_UPON_OUTCOME like "Spayed%" or o.SEX_UPON_OUTCOME like "Neutered%")
order by i.ANIMAL_ID 
```