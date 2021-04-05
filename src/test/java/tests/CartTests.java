package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import api.Auth;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;


public class CartTests extends TestBase {


	@Test
	void addItemToCartWithHardCodeTest() {
		Response response =
		given()
				.cookie("Nop.customer=f8f6c7d0-2d88-4053-8160-fa37fc002a08; ARRAffinity=1fa9158750fcf7cee1728ac683a12594fe016bf3b1c0544237f51a4ffe2ef5ea; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72")
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")
				.body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1")
				.when()
				.post("/addproducttocart/details/72/1")
				.then()
				.statusCode(200)
				.log().body()
				.body("success", is(true))
				.extract().response();

		System.out.println(response);
	}


	@Test
	void addItemToCartWithCookieTest() {
		Map<String, String> cookies = new Auth().login("qaguru@qa.guru", "qaguru@qa.guru1");

		Response response =
				given()
						.contentType("application/x-www-form-urlencoded; charset=UTF-8")
						.cookies(cookies)
						.body("product_attribute_16_5_4=14&product_attribute_16_6_5=15&product_attribute_16_3_6=18&product_attribute_16_4_7=44&product_attribute_16_8_8=22&addtocart_16.EnteredQuantity=1")
						.when()
						.post("/addproducttocart/details/16/1")
						.then()
						.statusCode(200)
						.log().body()
						.body("success", is(true))
						.extract().response();

		System.out.println(response);
	}
}
