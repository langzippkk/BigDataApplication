package org.example;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
{"date":"2020-12-02T00:00:00.000","day":"Wednesday","people_tested_total":"10",
"people_positive_total":"10","people_not_positive_total":"0","people_tested_age_0_17":"0",
"people_tested_age_18_29":"3","people_tested_age_30_39":"0","people_tested_age_40_49":"0",
"people_tested_age_50_59":"1","people_tested_age_60_69":"3","people_tested_age_70_79":"1",
"people_tested_age_80_":"2","people_tested_age_unknown":"0","people_tested_female":"9",
"people_tested_male":"1","people_tested_gender_unknown":"0","people_tested_latinx":"1",
"people_tested_asian_non_latinx":"1","people_tested_black_non_latinx":"1",
"people_tested_white_non_latinx":"1","people_tested_other_race_non_latinx":"4",
"people_tested_unknown_race_ethnicity":"2","people_positive_age_0_17":"0",
"people_positive_age_18_29":"3","people_positive_age_30_39":"0",
"people_positive_age_40_49":"0","people_positive_age_50_59":"1","people_positive_age_60_69":"3",
"people_positive_age_70_79":"1","people_positive_age_80_":"2","people_positive_age_unknown":"0",
"people_positive_female":"9","people_positive_male":"1","people_positive_gender_unknown":"0",
"people_positive_latinx":"1","people_positive_asian_non_latinx":"1",
"people_positive_black_non_latinx":"1","people_positive_white_non_latinx":"1",
"people_positive_other_race_non_latinx":"4","people_positive_unknown_race_ethnicity":"2",
"people_not_positive_age_0_17":"0","people_not_positive_age_18_29":"0",
"people_not_positive_age_30_39":"0","people_not_positive_age_40_49":"0",
"people_not_positive_age_50_59":"0","people_not_positive_age_60_69":"0",
"people_not_positive_age_70_79":"0","people_not_positive_age_80_":"0",
"people_not_positive_age_unknown":"0","people_not_positive_female":"0",
"people_not_positive_male":"0","people_not_positive_gender_unknown":"0",
"people_not_positive_latinx":"0","people_not_positive_asian_non_latinx":"0",
"people_not_positive_black_non_latinx":"0","people_not_positive_white_non_latinx":"0",
"people_not_positive_other_race_non_latinx":"0","people_not_positive_unknown_race_ethnicity":"0"}
 */


// Inspired by http://stackoverflow.com/questions/14458450/what-to-use-instead-of-org-jboss-resteasy-client-clientrequest
public class RealTimeCovid {
    static class Task extends TimerTask {
        private Client client;
        Random generator = new Random();

        public CovidResponse[] getCovidResponse() {
            Invocation.Builder bldr
            = client.target("https://data.cityofchicago.org/resource/t4hh-4ku9.json").request("application/json");
            try {
                return bldr.get(CovidResponse[].class);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            return null;  // Sometimes the web service fails due to network problems. Just let it try again
        }


        // Adapted from http://hortonworks.com/hadoop-tutorial/simulating-transporting-realtime-events-stream-apache-kafka/
        Properties props = new Properties();
        String TOPIC = "nian_final_covid";
        KafkaProducer<String, String> producer;

        public Task() {
            client = ClientBuilder.newClient();
            // enable POJO mapping using Jackson - see
            // https://jersey.java.net/documentation/latest/user-guide.html#json.jackson
            client.register(JacksonFeature.class);
            props.put("bootstrap.servers", bootstrapServers);
            props.put("acks", "all");
            props.put("retries", 0);
            props.put("batch.size", 16384);
            props.put("linger.ms", 1);
            props.put("buffer.memory", 33554432);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            producer = new KafkaProducer<>(props);
        }

        @Override
        public void run() {
            CovidResponse[] responses = getCovidResponse();
            CovidResponse response = responses[0];
            if(response == null)
                return;
            ObjectMapper mapper = new ObjectMapper();

            ProducerRecord<String, String> data;

            //write the record

            try {
                CovidRecord kfr = new CovidRecord(
                        response.getDate(),
                        response.getDay(),
                        response.getPeopleTestedTotal(),
                        response.getPeoplePositiveTotal());

                data = new ProducerRecord<String, String>
                        (TOPIC,
                                mapper.writeValueAsString(kfr));
                System.out.println(data);
                producer.send(data);
            } catch (JsonProcessingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }


    static String bootstrapServers = new String("localhost:9092");

    public static void main(String[] args) {
        if(args.length > 0)  // This lets us run on the cluster with a different kafka
            bootstrapServers = args[0];
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Task(), 0, 60*1000);
    }
}

