# linux 기초

## linux terminal를 iterm에 연동하기

'''ssh [사용자명]@[각 컴퓨터에 할당된 주소] '''
> 이걸 linux에서 실행 시킨뒤에 iterm에 입력해주면 연동이 가능하다.

## iterm에서 Jupyter 실행 시키기

## Linux컴퓨터 종료 하기

''' sudo shutdown -h now '''

## 현재 폴더 위치

''' pwd '''

## 현재 사용중인 계정

''' whoami '''

## 현재 폴더에 있는 파일을 숨겨진거 까지 모두 보여줘

''' ls -al '''
> ls만 하면 숨겨진 파일까진 보여주진 않는다 

## drwxrwxrwx의 의미

> 'd'는 폴더라는 의미 이고 'r' read ,'w' write, 'x' 실행이라는 뜻 이다.
> 3등분으로 나눌수가 있는데 "소유자/그룹/others"로 나눈다.
> 보통 숫자로 바꿔서 많이 부른다 r-4,w-2,x-1 이고 같이 있으면 더해서 부르면 된다.

1. drwxr-x--- : 폴더 750
2. -rw-r--r-- : 644

## 권한변경

> 위에를 이해 했다면 권한 변경이해도 금방 될거다 원래 750인걸 700으로 권한을 변경한다면 'chmod'를 사용하면 된다.

''' chmod 700 [바꿀 폴더명] '''

## vim

> Vim 설치하기 
''' vim/home/[계정]/.jupyter/jupyter_notebook_config.py '''

- 수정모드 : i
- 명령어모드 : ':q' 나가기 / ':q!' 강제로 나가기

## jupyter server password 설정하기

> 서버 jupyter에서 사용할 password설정하기

''' vim/home/[계정]/.jupyter/jupyter_notebook_config.py '''
> 들어가서 '수정모드' 927번째행으로 이동후 설정된 비밀번호 입력 'wq(저장하고 나오기)'입력 후 나가기

## workspace 폴더 생성

''' mkdir workspace '''

> 해당 폴더로 이동하기
''' cd workspace '''

> 현재위치 초기화(처음으로 되돌아가기)
''' cd ~ '''

## jupyter lab 실행

''' jupyter lab --ip=0.0.0.0 '''
> 설정은 0.0.0.0으로 하지만 사이트로 접속할떄는 "[고유아이피주소]:8888"으로 접속해야한다.

## 의미를 찾아봐야할 코드들

''' source ~/.bashrc '''
''' ls -al ~/ | grep bash '''