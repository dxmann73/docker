package de.memepool.kafkaapi;

import org.wildfly.swarm.config.runtime.AttributeDocumentation;
import org.wildfly.swarm.spi.api.Fraction;
import org.wildfly.swarm.spi.api.annotations.Configurable;
import org.wildfly.swarm.spi.api.annotations.DeploymentModule;

@DeploymentModule(name = "de.memepool.kafkaapi", slot = "main")
@Configurable("swarm.kafkaapi")
public class KafkaFraction implements Fraction<KafkaFraction> {

    /**
     * Uses the specified connection info if not <code>null</code>. Otherwise
     * use primary Datasource
     */
    @AttributeDocumentation("Foo URL")
    private String fooUrl;

}
