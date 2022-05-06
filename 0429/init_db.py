from datetime import datetime
from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.timeattack

def insert_memo():
    # 날짜 가져오기
    today = datetime.now()
    mytime = today.strftime('%Y.%m.%d %H:%M:%S')

    doc = {'idx' : 1,
            'title': '제목2',
            'content': '하하하',
            'pw': 1234,
            'reg_date': mytime}

    # db.memo.insert_one(doc)
    print('a')

    #인덱스 설정 어떻게 하는거냐
    # db.memo.ensureIndex({'idx': 1})
    # db.memo.create_index({'idx':1})
    print(db.memo.estimated_document_count())

insert_memo()






