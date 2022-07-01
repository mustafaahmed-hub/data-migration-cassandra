package com.employee.employcurd.config;

import com.employee.employcurd.model.Employee;
import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Map;

@Configuration
public class HazelcastClientConfig {
    @Bean
    public Config hazelcastConfig(){
        return new Config().setManagementCenterConfig(
                new ManagementCenterConfig().setConsoleEnabled(true)
                        .setScriptingEnabled(true)
                        .setTrustedInterfaces(Collections.singleton("http://localhost:9005/hazelcast-mancenter"))
        );
    }
    @Bean
    public HazelcastInstance hazelcastInstance(Config hazelConfig){
        return Hazelcast.newHazelcastInstance(hazelConfig);
    }
    @Bean
    public Map<Integer, Employee> employeeMap(HazelcastInstance hazelcastInstance){
        return hazelcastInstance.getMap("employeeMap");
    }
}
