# Hadoop

## hadoop id 생성하기
```
sudo adduser hadoop

# password는 관리하기 편하게 아이디와 동일하게 설정

# 비밀번호 변경은 
sudo password [계정이름]
```

## hadoop 계정으로 접속
```
su hadoop
```

## hadoop 계정에 권한 주기 (일반계정에서 진행)
```
sudo visudo

# 밑에 내리다 보면 root ALL...로 써있는곳 밑에다가 추가해서 계정만 hadoop으로 바꾸고 똑같이 적어주면 된다.
```

## hadoop 계정에 jdk 설치
```
sudo apt install openjdk-8jdk

/usr/lib/jvm/java-8-openjdk-arm64
```

## bashrc에서 Java_home export 추가하기
```
# bashrc 접속
vim ~/.bashrc

# 맨 밑에다가 아래코드 입력
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

# 저장하고 나오기

# 변경사항 저장
source ~/.bashrc

# 나오는지 확인하기
echo $JAVA_HOME
# 입력 후 잘나오면 된거임
```

## hadoop 설치 주소 (arm용)
```
wget https://dlcdn.apache.org/hadoop/common/hadoop-3.3.6/hadoop-3.3.6-aarch64.tar.gz
```

## hadoop 실행전 체크리스트
1. 자바설치 유무
> java
2. JAVA_HOME 설정 되어 있는지 확인
```
echo $JAVA_HOME
```

만약, 아무것도 뜨지 않으면

```
# 1
vim ~/.bashrc

# 2
export JAVA_HOME==/usr/lib/jvm/java-8-openjdk-arm64

# 3 변경사항 저장하기
source ~/.bashrc
```
## 방화벽

### 방화벽 확인
```
sudo service ufw status

-> active면 방화벽 동작
```

### 부팅할때부터 방화벽 데몬 정지
```
sudo systemctl disable ufw

sudo service ufw stop
```

## hostname 변경하기
- 기존 hadoop계정 이름을 client로 변경한다 hadoop@...-> hadoop@client
```
sudo hostnamectl set-hostname client
```
## hadoop 설치하기

1. hadoop 설치 주소 (arm용)
```
wget https://dlcdn.apache.org/hadoop/common/hadoop-3.3.6/hadoop-3.3.6-aarch64.tar.gz
```

2. 압축해제하기
```
tar xvfz hadoop-3.3.6-aarch64.tar.gz
```

3. hadoop으로 폴더 이름 변경하기
```
mv ./hadoop-3.3.6 ./hadoop
```
## hadoop 구성파일 변경하기
1. 하둡설정파일에서 workers파일에서 datanode3추가하기

2. filezilla에서 '/home/hadoop/hadoop/etc/hadoop'에 덮어 씌우기

3. 다시 리눅스로 돌아와서 아래 코드입력
```
cd /home/hadoop/hadoop/etc/hadoop
```

4. 아래 파일에서 1를 3으로 변경시키기
```
vim hdfs-site.xml

# 1 -> 3으로 수정하고 :wq

# 저장경로를 home 밑에 data폴더로 했기 떄문에 data폴더생성하기
mkdir ~/data
```

## ip주소 할당

## hadoop 3대 연결하기
- namenode(datanode1) : 000.00.000.000
- secondnode(datanode2) : 000.00.000.000
- datanode3 : 000.00.000.000

### 고정IP할당
1. ubuntu 서버 총 4개 띄우기

    1. main server shutdown
    2. /Users/사용자/Virtual Machines.localized 안에서 복제
    3. 총 복제 3번하면 된다.

2. 각각 마다 고정IP로 설정 및 이름 바꾸기
```
sudo hostnamectl set-hostname (변경할 이름)

# 변경할 이름 : namenode/secondnode/datanode3
```
변경 후 exit하고 다시 로그인하기 

3. etc/netplan 폴더로 이동
```
cd /etc/netplan/
```
4. 이름확인
```
cat /etc/hosts | grep name

# 현재 위에 ls
-> "00-installer-config.ymal"
```
5. vim "00-installer-config.ymal" 접속
```
sudo vim 00-installer-config.ymal
```
6. 고정 IP할당
```
dhc4p: true -> false # 변경
addresses: [000.00.000.000/00] # 고정IP로 할당
```
7. 고정IP 적용
```
sudo netplan apply
```
8. 제대로 바뀌었는지 확인
```
ip addr
```

### ssh로 이동확인
- ssh를 입력하고 해당 이름을 입력하면 바로바로 이동해야지 연동되었다고 할 수 있다.
```
ssh namenode
ssh secondnode
ssh datanode3
ssh client
```
## hadoop 실행하기위한 준비
1. namenode에서 초기화 실행
```
hadoop namenode -format
```

2. 실행하기
```
start-dfs.sh

# jps로 생성됬는지 확인하기 3개가 떠야함

# 멈추는 코드
stop-dfs.sh
```

3. secondnode로 이동후 yarn실행
```
start-yarn.sh

# jps로 생성됬는지 확인하기
```

4. 마지막으로 jps확인할떄는 총 5개가 떠야함 앞에 숫자들은 무시
```
2675 NodeManager
3606 DataNode
2841 JobHistoryServer
3499 NameNode
3884 Jps
```

5. 다시 namenode로 이동 후 아래코드 입력
```
mr-jobhistory-daemon.sh start historyserver
```

## 서버확인하기
1. 주소창에 아래 코드 입력
```
[namenode ip주소]:50070
```

2. datanodes로 이동해서 그래프에 3개가 뜨는지 확인

## 원격실행하기
```
ssh namenode start-dfs.sh

ssh secondnode start-yarn.sh

ssh namenode mr-jobhistory-daemon.sh start historyserver

ssh namenode jps

ssh namenode jps

ssh namenode jps

```
## alias 설정하기
```
# vim으로 bashrc 접속
vim ~/.bashrc

# alias 추가
alias start-dfs="ssh namenode start-dfs.sh"
alias start-yarn="ssh secondnode start-yarn.sh"
alias stop-dfs="ssh namenode stop-dfs.sh"
alias stop-yarn="ssh secondnode stop-yarn.sh"
alias start-mr="ssh namenode mr-jobhistory-daemon.sh start historyserver"
alias stop-mr="ssh namenode mr-jobhistory-daemon.sh stop historyserver"

# 변경사항 저장하기
source ~/.bashre
```

## 실습해보기
1. encore 폴더 만들기
```
# /(폴더이름)
hdfs dfs -mkdir /encore
```

2. 실습 할 폴더 만들기
```
wget https://gutenberg.org/cache/epub/100/pg100.txt 
```

3. pg100.txt 텍스트 파일을 encore폴더안에 집어넣기
```
hdfs dfs -put ./pg100.txt /encore
```

4. 밑에 폴더로 접속
```
cd /home/hadoop/hadoop/share/hadoop/mapreduce
```

5. grep으로 encore폴더에서 result파일에서 알파벳 문자 a-z 하나이상 연속으로 나오는 패턴을 찾을 것 ("a a" : x, "aaa" : o )
```
hadoop jar ./hadoop-mapreduce-examples-3.3.6.jar grep /encore /result/ '[a-z]+ '
```
> 파일을 보면 카운트가 되어있는데 이것들은 jar파일에 Java코드로 wordcount코드가 있기 때문이다.
6. result파일 밑에 있는 모든것들을 출력해라!
```
hdfs dfs -cat /result/*
```

### 실습한거 확인하기
1. namenode사이트로 이동

2. utilities/browse the file system으로 이동

3. result파일 생성되었는지 확인

4. result에 들어가서 part-r-00000생성되었는지 확인 후 들어가서 다운로드

5. 아래코드로 이동
```
[secondnode ip 주소]:8088
```

6. finalstatus가 succeeded인지확인 후 nodes로 이동해서 존재하는지 확인

## 하둡 실행 순서
- 실행하기 : HDFS -> YARN -> MR-History Server​
```
namenode   : start-dfs.sh
secondnode : start-yarn.sh
namenode   : mr-jobhistory-daemon.sh start historyserver​
```

- 종료하기 : YARN -> MR-History Server -> HDFS​
```
secondnode : stop-yarn.sh
namenode   : mr-jobhistory-daemon.sh stop historyserver​
namenode   : stop-dfs.sh
```

## 파일 백업하기
1. 데이터베이스 만들기
```
CREATE DATABASE mydata;
```

2. 데이터프레임 만들어둔 데이터베이스에 업로드 하기
```
pip install mysqlclient 

import sqlalchemy

user = "encore"
password = "1q2w3e!"
host = "172.21.116.192"
port = "3306"
database = "mydata"
engine = sqlalchemy.create_engine(f"mysql://{user}:{password}@{host}:{port}/{database}")

star_df.to_sql(name="star2", if_exists="replace", con=engine)
```

3. 백업하기
```
mysqldump -uroot -p123 hivedb > ~/workspace/hivedb.sql

# 백업한걸 다시 불러올때
mysql -uroot -p123 mydata < ~/workspace/mydata.sql
```
