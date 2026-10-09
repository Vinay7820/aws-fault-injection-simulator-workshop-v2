import urllib.request

def fetch_data(url):
    response = urllib.request.urlopen(url)
    return response.read()

fetch_data("http://internal-api.example.com/data")
