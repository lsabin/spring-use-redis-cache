package com.example.rediscache.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfigurationProperties {

    @NotEmpty
    private String password;

    @Valid
    private SentinelProperties sentinel = new SentinelProperties();

    public class SentinelProperties {
        @NotEmpty
        private String master;

        @NotEmpty
        private Set<String> nodes;

        public String getMaster() {
            return master;
        }

        public void setMaster(String master) {
            this.master = master;
        }

        public Set<String> getNodes() {
            return nodes;
        }

        public void setNodes(Set<String> nodes) {
            this.nodes = nodes;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SentinelProperties getSentinel() {
        return sentinel;
    }

    public void setSentinel(SentinelProperties sentinel) {
        this.sentinel = sentinel;
    }
}
