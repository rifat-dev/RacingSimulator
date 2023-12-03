package com.rifat.racingSimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class RacingSimulatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacingSimulatorApplication.class, args);
	}

	@GetMapping("/")
    public String hello() {
      return "hello";
    }

	@GetMapping("/racing-simulator")
    public String showRacingSimulator() {
        return "racing-simulator";
    }

}
