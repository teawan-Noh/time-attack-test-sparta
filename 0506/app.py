from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/detail/<idx>')
def detail(idx):
    article = db.memo.find_one({'idx': int(idx)})

    return render_template('detail.html', article=article)

@app.route('/articleList', methods=['GET'])
def get_article_list():
    article_list = 0
    # todo
    order = request.args.get('order')
    if order == 'asc':
        article_list = list(db.memo.find({}, {'_id': False}).sort('read_count', 1))
    elif order == 'desc':
        article_list = list(db.memo.find({}, {'_id': False}).sort('read_count', -1))

    # article_list = list(db.memo.find({}, {'_id': False}))
    # for article in article_list:
    #     article['reg_date'] = article['reg_date'].strftime('%Y.%m.%d %H:%M:%S')

    print(article_list)
    return jsonify({"article_list": article_list})

# Create
@app.route('/article', methods=['POST'])
def create_article():
    # // todo
    title_receive = request.form['title']
    pw_receive = request.form['pw']
    content_receive = request.form['content']
    print(title_receive, pw_receive, content_receive)
    # 날짜 가져오기
    today = datetime.now()
    # 데이터 수 가져오기
    count = db.memo.estimated_document_count()
    next_index = count + 1

    doc = {'idx': next_index,
           'title': title_receive,
           'content': content_receive,
           'pw': pw_receive,
           'read_count': 0,
           'reg_date': today.strftime('%Y.%m.%d %H:%M:%S')}

    db.memo.insert_one(doc)
    return {"result": "success"}

# Read
@app.route('/article', methods=['GET'])
def read_article():
    article = 0
    idx = request.args.get('idx')

    # article = db.memo.find_one({'idx': int(idx)})
    article = db.memo.find_one({'idx': int(idx)})

    current_read_count = article['read_count']
    new_read_count = current_read_count + 1
    db.memo.update_one({'idx': int(idx)}, {'$set': {'read_count': new_read_count}})

    return jsonify({"article": article})

# Update
@app.route('/article', methods=['PUT'])
def update_article():
    # todo
    return {"result": "success"}

# Delete
@app.route('/article', methods=['DELETE'])
def delete_article():
    # todo
    return {"result": "success"}

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)