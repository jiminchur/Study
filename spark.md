## spark 설치하기
```
wget https://dlcdn.apache.org/spark/spark-3.3.4/spark-3.3.4-bin-hadoop3.tgz

# 압축해제
tar xvzf ./spark-3.3.4/spark-3.3.4-bin-hadoop3.tgz

# 폴더이름 변경
mv ./spark-3.3.4-bin-hadoop3 ./spark
```

## 선생님이 주신 spark 파일 아래 경로로 이동
```
/home/hadoop/spark/conf
```

## bashrc 설정
```
vim ~/.bashrc

export SPARK_HOME=/home/hadoop/spark/
export PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin:$HIVE_HOME/bin:$SPARK_HOME/bin

source ~/.bashrc
```

## jupyter 연동
```
pip install jupyter 

jupyter notebook --generate-config
vim /home/hadoop/.jupyter/jupyter_notebook_config.py


c.NotebookApp.allow_origin = '*'
c.NotebookApp.open_browser = False
c.NotebookApp.password = "argon2:$argon2id$v=19$m=10240,t=10,p=8$JjOUUl+PkMyaeVWz34kP7g$gH7h20sz6D/JmgVtCUKm3RquEAcdCnbDQ4jRL2eFskI"


# password -> 123

vim ~/.bashrc

export PYSPARK_DRIVER_PYTHON=jupyter
export PYSPARK_DRIVER_PYTHON_OPTS='notebook --ip=0.0.0.0'

source ~/.bashrc
```

## pyspark으로 실행
```
pysparks
```

## 연습용 데이터 받기
```
git clone https://github.com/FVBros/Spark-The-Definitive-Guide.git

hdfs dfs -mkdir -p /data/flight

cd /home/hadoop/Spark-The-Definitive-Guide/data/flight-data/csv

hdfs dfs -put *.csv /data/flight/
```