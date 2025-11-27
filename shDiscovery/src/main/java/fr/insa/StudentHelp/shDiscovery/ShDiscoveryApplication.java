package fr.insa.StudentHelp.shDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShDiscoveryApplication.class, args);
	}

}
