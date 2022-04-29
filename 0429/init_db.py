import requests
from datetime import datetime
from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.test

def insert_tour():
    # 날짜 가져오기
    today = datetime.now()
    mytime = today.strftime('%Y.%m.%d %H:%M:%S')

    doc = {'idx' : 1,
            'title': '제목1',
            'content': '하하하',
            'pw': 1234,
            'reg_date': mytime}

    db.memotest.insert_one(doc)

insert_tour()