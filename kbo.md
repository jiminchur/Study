## 필수 설치
```
pip install selenium
```

```
pip install lxml
```

## 필수 임포트
```
from selenium import webdriver
from selenium.webdriver.common.by import By
import time
import re
import requests
import os
from tqdm import tqdm
```

### web드라이버로 크롬 연결
```
driver = webdriver.Chrome()
```

### kbo 사이트 접속
```
driver.get("https://www.koreabaseball.com/Default.aspx")
```

### 이벤트창 뜨는거 지우는버튼 클릭
```
driver.find_element(By.CSS_SELECTOR, "#popupVideo > img").click()
```
 
```
driver.find_element(By.CSS_SELECTOR, "#lnb > li:nth-child(3) > a").click()
```

```
driver.find_element(By.CSS_SELECTOR,"#cphContents_cphContents_cphContents_ddlTeam").click()
```

## 선수 id 가져오기
```
import time
import re
pattern = re.compile("playerId=([0-9]+)")
playid = []
select_team = "#cphContents_cphContents_cphContents_ddlTeam > option:nth-child({})"
select_page = "#cphContents_cphContents_cphContents_ucPager_btnNo{}"
for x in range(2,12):
    for_1 = select_team.format(x)
    driver.find_element(By.CSS_SELECTOR, for_1).click()
    time.sleep(2)
    #playid.extend(pattern.findall(driver.page_source))
    for y in range(1,6):
        f2 = select_page.format(y)
        try:
            driver.find_element(By.CSS_SELECTOR, f2).click()
            time.sleep(1)
            playid.extend(pattern.findall(driver.page_source))
        except Exception as e:
            print (e)
        time.sleep(2)
```

## 환율정보 가져오기
```
import requests 
url = "https://finance.naver.com/marketindex/exchangeDailyQuote.naver?marketindexCd=FX_USDKRW&page={}"
usd = pd.concat([pd.read_html(requests.get(url.format(x)).text)[0] for x in range(1,101)])
dollar = usd['매매기준율']['매매기준율'].iloc[0]
```

## 선수 id정보로 선수정보 가져오기
```
for id in tqdm(playid):
    driver.get(f"https://www.koreabaseball.com/Record/Player/PitcherDetail/Basic.aspx?playerId={id}")
    df = driver.find_element(By.CSS_SELECTOR, "#contents > div.sub-content > div.player_info > div.player_basic > ul").text
    df2 = df.split("\n")
    lst = {}

    for i in range(df2.__len__()):
        a,b = df2[i].split(":")  
        lst[a] = b
    
    dff = pd.DataFrame([lst])

    dff['신장'] = dff['신장/체중'][0][1:4]
    dff['체중'] = dff['신장/체중'][0][7:][:-2]
    dff['현재 소속팀'] = driver.find_element(By.CSS_SELECTOR, "#h4Team").text
    if "달러" in dff["연봉"][0]:
        dff["연봉(만원)"] = int(dff["연봉"][0][1:-2])*(int(dollar)/10000)
        if dff["입단 계약금"][0] != "" :
            dff["입단 계약금(만원)"] = int(dff["입단 계약금"][0][1:-2])*(int(dollar)/10000)
        else :
            dff["입단 계약금(만원)"] = 0
    else :
        if dff["연봉"][0] != "" :
            dff["연봉(만원)"] = int(dff["연봉"][0][1:-2])
        elif dff["연봉"][0] == "" :
            dff["연봉(만원)"] = 0
        if dff["입단 계약금"][0] != "" :
            dff["입단 계약금(만원)"] = int(dff["입단 계약금"][0][1:-2])
        elif dff["입단 계약금"][0] == "" :
            dff["입단 계약금(만원)"] = 0
    dff = dff.drop(['신장/체중','연봉','입단 계약금'], axis=1)
    dff.to_csv(f"./KBO_player/{id}.csv",index=False,encoding="utf-8-sig")
```

## hadoop에 넣기

### filezila or scp로 파일 이동
- workspace/kbo_player에 넣는다.

### hadoop에 넣을 폴더 생성
```
# 폴더 생성
hdfs dfs -mkdir /kbo

# 폴더 삭제
hdfs dfs -rm -r /kbo
```

### hadoop에 넣기
- 데이터가 있는 위치로 이동 
```
cd workspace/kbo_player
```

- hadoop에 넣기
```
hdfs dfs -put *.csv /kbo
```

- hadoop namenode에 접속 들어갔는지 확인

### hive로 테이블 생성
```
CREATE EXTERNAL TABLE IF NOT EXISTS KBO(
    PlayerName STRING,
    UniformNumber STRING,
    DateOfBirth STRING,
    Position STRING,
    Career STRING,
    Designation STRING,
    JoiningYear STRING,
    Height FLOAT,
    Weight FLOAT,
    CurrentTeam STRING,
    Salary FLOAT,
    Contraction FLOAT)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION '/kbo_player'
tblproperties ("skip.header.line.count"="1");
```

### hive로 쿼리문 작성하여 데이터 조회