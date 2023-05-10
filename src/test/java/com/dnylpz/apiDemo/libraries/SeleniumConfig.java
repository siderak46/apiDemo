package com.dnylpz.apiDemo.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class SeleniumConfig {

    @Bean
    public WebDriver webDriver() {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
        // add any desired browser options here
        return new ChromeDriver(chromeOptions);
    }

}
