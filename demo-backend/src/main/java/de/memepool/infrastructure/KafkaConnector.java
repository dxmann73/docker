package de.memepool.infrastructure;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Singleton
@Lock(LockType.READ)
@Startup
public class KafkaConnector {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    KafkaStreams streams;

    @PostConstruct
    public void startUp() {
        logger.info("Starting up kafka...");

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "demo-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.99.100:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> source = builder.stream("streams-plaintext-input");

        source.to("streams-pipe-output");
        Topology topology = builder.build();
        logger.info("Topology: {}", topology.describe());

        streams = new KafkaStreams(topology, props);
        streams.start();
        logger.info("... kafka started.");
    }

    @PreDestroy
    public void shutDown() {
        logger.info("Shutting down kafka...");
        // TODO javadoc suggests that streams is doing its own threading
        // TODO also (probably for that reason) stream clients never stop, we need the timeout to kill them
        streams.close(10, TimeUnit.SECONDS);
        logger.info("... kafka stopped.");
    }
}
