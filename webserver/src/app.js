'use strict';
const http = require('http');
var assert = require('assert');
const express= require('express');
const app = express();
const mustache = require('mustache');
const filesystem = require('fs');
const url = require('url');
const port = Number(process.argv[2]);

const hbase = require('hbase')
var hclient = hbase({ host: process.argv[3], port: Number(process.argv[4])})


function counterToNumber(c) {
    return Number(Buffer.from(c).readInt32BE());
}


// store data in a dictionary stats[column] = value
function rowToMap(row) {
	var stats = {}
	if (row==null)
		return NaN;
	row.forEach(function (item) {
        if (item['column'] != 'weather:weekday'){
            stats[item['column']] = counterToNumber(item['$'])
        }
        else {
            stats[item['column']] = (item['$'])
        }
	});
	return stats;
}

hclient.table('processed_weather_covid_nian').row('08/08/2020').get((error, value) => {
    console.info(value)
	console.info(rowToMap(value))
	console.info(error)
})

function getFormattedDate(date) {
	var year = date.substring(0,4).toString();
	var month = date.substring(5,7).toString();
	var day = date.substring(8,10).toString();

	return month + '/' + day + '/' + year;
}

app.use(express.static('public'));
app.get('/delays.html',function (req, res) {
    const time1=req.query['date'];
    const time = getFormattedDate(time1)
    console.info(time)
	hclient.table('processed_weather_covid_nian').row(time).get(function (err, cells) {
		console.info(cells);
		const covidinfo = rowToMap(cells);
		console.log(covidinfo)

		var template = filesystem.readFileSync("result.mustache").toString();
		var html = mustache.render(template,  {
			Temperature : covidinfo["weather:Temperature"],
			Humidity : covidinfo["weather:Humidity"],
			Rain: covidinfo["weather:Rain"],
			tested : covidinfo["weather:tested"],
			positive : covidinfo["weather:positive"],
			weekday:covidinfo["weather:weekday"]
		});
		res.send(html);
	});
});


/* Send simulated weather to kafka */
var kafka = require('kafka-node');
var Producer = kafka.Producer;
var KeyedMessage = kafka.KeyedMessage;
var kafkaClient = new kafka.KafkaClient({kafkaHost: process.argv[5]});
var kafkaProducer = new Producer(kafkaClient);


app.get('/weather.html',function (req, res) {
    var date_val = req.query['Date'];
    var temperature_val = req.query['Temperature'];
    var Humidity_val = req.query['Humidity'];
    var Rain_val = req.query['Rain'];
    const time3= new Date(date_val);
    const time4 = getFormattedDate(time3);
    var report = {
        date:time4,
        temperature: temperature_val,
        humidity: Humidity_val,
        rain: Rain_val
    };

    console.info(report)

    kafkaProducer.send([{ topic:'nian_final', messages: JSON.stringify(report)}],
        function (err, data) {
            console.log("Kafka Error: " + err)
            console.log(data);
            console.log(report);
            res.redirect('submit-weather.html');
        });
});

app.listen(port);
