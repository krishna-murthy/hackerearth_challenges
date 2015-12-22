var express = require('express');
var mustacheExpress = require('mustache-express'); 
var app = express();
var http = require('http');

app.set('port', (process.env.PORT || 5000));
app.use(express.static(__dirname + '/public'));
app.engine('html', mustacheExpress());
app.set('view engine', 'html');
app.set('views', __dirname + '/html');

app.get('/list_hotels', function(request, response) {
  var options = {
    url: 'http://glydel.0x10.info/api/hotel?type=json&query=list_hotels',
    method: 'GET',
  };
  var parsed = {};
  http.get('http://glydel.0x10.info/api/hotel?type=json&query=list_hotels', function(res) {
    var body = '';
    res.on('data', function(d) {
        body += d;
    });
    res.on('end', function() {
       parsed = JSON.parse(body);
       response.json(parsed);
    });
  }, function(res) {
      console.log(res);
  });
});

app.get('/api_hits', function(request, response) {
   var parsed = {};
   http.get('http://glydel.0x10.info/api/hotel?type=json&query=api_hits', function(res) {
        var body = '';
        res.on('data', function(d) {
            body += d;
        });
        res.on('end', function() {
            parsed = JSON.parse(body);
            response.json(parsed);
        });
    }, function(res) {
        console.log(res);
    });
});

app.get('/download/:id', function(request, response) {
  var parsed = {};
  http.get('http://glydel.0x10.info/api/hotel?type=json&query=list_hotels', function(res) {
    var body = '';
    res.on('data', function(d) {
        body += d;
    });
    res.on('end', function() {
       parsed = JSON.parse(body);
       var fs = require('fs');
       fs.writeFile("/tmp/test",parsed[request.params.id], function(err) {
            response.download("/tmp/test");
       }); 
    });
  }, function(res) {
      console.log(res);
  });
});

app.get('/', function(request, response) {
  response.render('index');
});

app.listen(app.get('port'), function() {
  console.log("Node app is running at localhost:" + app.get('port'));
});
