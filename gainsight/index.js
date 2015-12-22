var express = require('express');
var mustacheExpress = require('mustache-express');
var app = express();
var http = require('http');
var fs = require('fs');

app.set('port', (process.env.PORT || 5000));
app.use(express.static(__dirname + '/public'));
app.engine('html', mustacheExpress());
app.set('view engine', 'html');
app.set('views', __dirname + '/html');

app.get('/', function(request, response) {
    response.render('index');
});

app.get('/total_likes', function(request, response) {
    var totalLikes = 0;
    fs.readFile('likes',{encoding: 'utf8'}, function (err,data) {
        totalLikes = data;
        response.json({total_likes: totalLikes});
    });
});

app.get('/image_list/:pno' , function(request, response) {
    var parsed = {};
    var page_number = request.params.pno;
    var url = 'http://gainsight.0x10.info/api/image?page_no=' + page_number;
    http.get(url, function(res) {
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

app.post('/like_image', function(request, response) {
    fs.readFile('likes',{encoding: 'utf8'}, function (err,data) {
        totalLikes = parseInt(data,10);
        totalLikes += 1;
        fs.writeFile('likes', totalLikes, {encoding: 'utf8'}, function(err, data) {
            response.json(200);
        });
    });
});

app.listen(app.get('port'), function() {
    console.log("Node app is running at localhost:" + app.get('port'));
});
