package com.dnylpz.apiDemo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest()
class ApiDemoApplicationTests {
	@Value("${app.url}")
	private String appUrl;

	@Value("chrome,firefox,edge")
	private List<String> browsers;

	//@Autowired
	//private WebDriver webDriver;

	/*@Test
	public void testGoogleSearch() {
		webDriver.get(appUrl);
		WebElement searchBox = webDriver.findElement(By.name("q"));
		searchBox.sendKeys("Spring Boot");
		searchBox.sendKeys(Keys.RETURN);
		WebElement results = webDriver.findElement(By.id("search"));
		assertTrue(results.isDisplayed());
	}*/

	@Test
	public void testAppIsRunning() {
		// Test code
		RestAssured.baseURI = appUrl;
		Response res = RestAssured.when().get("/greeting");
		res.then().statusCode(200);
		System.out.println(res.statusCode());
	}

}
