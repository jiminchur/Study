## hadoop 설치 주소 (arm용)
```
wget https://dlcdn.apache.org/hadoop/common/hadoop-3.3.6/hadoop-3.3.6-aarch64.tar.gz
```

## OLAP 시스템

> Online Analytical Processing

## 맵리듀스

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

## 리눅스 편리하게 사용

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
