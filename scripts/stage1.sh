hdfs dfs -rm -r project/*
url="https://disk.yandex.com/d/tRfYZ381mRvXVw"


wget "$(yadisk-direct $url)" -O data/data.zip

unzip data/data.zip -d data/
cp data/Data/*.csv data/
rm -rf data/Data
rm data/data.zip

python3 scripts/build_projectdb.py

password=$(head -n 1 secrets/psql.pass)
cd output/
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team37_projectdb --username team37 --password $password --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse --m 1