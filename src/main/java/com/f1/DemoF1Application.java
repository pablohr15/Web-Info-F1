package com.f1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class DemoF1Application {

	public static void main(String[] args) {
		/*WebScrapping ws = new WebScrapping();
		System.out.println("Running web scraping");
		ws.scraping();
		System.out.println("End");*/

		SpringApplication.run(DemoF1Application.class, args);
		System.out.println("Application starting now...");
		WebScrapping ws = new WebScrapping();
		System.out.println("Running web scraping");
		ws.scraping();
	}

}
