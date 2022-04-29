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
      # // todo
    return render_template('index.html')


@app.route('/post', methods=['POST'])
def save_post():
    # // todo
    title_receive = request.form['title_give']
    pw_receive = request.form['title_pw']
    comment_receive = request.form['title_comment']
    return {"result": "success"}


@app.route('/post', methods=['GET'])
def get_post():
    posts = list(db.memotest.find({},{'_id':False}))

    return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.test.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)