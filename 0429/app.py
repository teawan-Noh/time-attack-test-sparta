from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.timeattack

@app.route('/')
def index():

    return render_template('index.html')

@app.route('/detail/<idx>')
def detail(idx):
    post = db.memo.find_one({'idx': int(idx)})

    return render_template('detail.html', post=post)


@app.route('/post', methods=['POST'])
def save_post():
    # // todo
    title_receive = request.form['title_give']
    pw_receive = request.form['pw_give']
    comment_receive = request.form['comment_give']
    # print(title_receive, pw_receive, comment_receive)
    # 날짜 가져오기
    today = datetime.now()
    #데이터 수 가져오기
    count = db.memo.estimated_document_count()
    next_index = count + 1

    doc = {'idx' : next_index,
            'title': title_receive,
            'content': comment_receive,
            'pw': pw_receive,
            'reg_date': today.strftime('%Y.%m.%d %H:%M:%S')}

    db.memo.insert_one(doc)

    return {"result": "저장 완료"}


@app.route('/post', methods=['GET'])
def get_post():
    posts = list(db.memo.find({},{'_id':False}).sort('reg_date', -1))

    return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    print(idx)
    db.memo.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000,debug=True)