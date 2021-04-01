package tests;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;


public class TestBase {

	@BeforeAll
	static void setup() {
		RestAssured.baseURI = "http://demowebshop.tricentis.com/";
	}
}
