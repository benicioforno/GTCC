package br.com.benicioforno.GTCC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GtccApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtccApplication.class, args);
	}

}
