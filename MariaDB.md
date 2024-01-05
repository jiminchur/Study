# MariaDB

## 설치하기
```
sudo apt install mariadb-server
```

## 연결상태,실행,멈춤,재시작
```
# 연결상태 확인
sudo service mysql status

# 실행
sudo service mysql start

# 멈춤
sudo service mysql stop

# 재시작
sudo service mysql restart
```

## 데이터베이스 서버 보안설정
```
sudo mysql_secure_installation

# 실행하게 되면 아래와 같이 진행해 주면 된다.
...
Switch to unix_socket authentication [Y/n] Y
...
Change the root password? [Y/n] Y
# 이후에 모두 enter
...
Remove anonymous users? [Y/n] Y
...
Disallow root login remotely? [Y/n] n
...
Remove test database and access to it? [Y/n] Y
...
Reload privilege tables now? [Y/n] Y
...
```

## 연결상태 확인
```
sudo service mysql status 

# -> active 상태 인거 확인
```

## 서버에서 mysql 콘솔 접속하기
```
mysql -uroot -p
```

- 쿼리문으로 새로운 계정 생성
```
# 계정 생성 쿼리
CREATE USER 'encore'@'%' IDENTIFIED BY '1q2w3e!';
# 권한부여 쿼리
GRANT ALL PRIVILEGES ON *.* TO 'encore'@'%';
```