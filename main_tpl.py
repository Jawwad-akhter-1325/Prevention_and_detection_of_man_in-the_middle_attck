from flask import Flask, render_template, render_template_string, request, send_file
import random
import datetime
import os

app = Flask(__name__)
images = os.listdir('static')
name = ['Ayush', 'Jawaad', 'Vishwesh']

@app.route('/api', methods = ['GET'])
def api():

    json = {'Name': random.choice(name),
            'Image': random.choice(images),
            'Date':  str(datetime.datetime.now().date()),
            'Time': str(datetime.datetime.now().time())}
    return json

@app.route('/images', methods = ['GET'])
def image():
    filename = request.args.get('name')
    return send_file('static/'+filename, mimetype='image/png')


@app.route('/', methods = ['GET'])
def home_page():
    return "ISM Project"
if __name__ == '__main__':
    app.run(debug = True)

