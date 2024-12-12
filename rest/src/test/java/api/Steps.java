package api;

import io.restassured.http.ContentType;
import lombok.Getter;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Steps {
    DatabaseManager databaseSteps = new DatabaseManager();
    @Getter
    private static Map<String, String> cookies;
    @Getter
    private final static String URL = "http://localhost:8080/";

    public Steps() {
        cookies = given()
                .contentType(ContentType.JSON)
                .when()
                .get(URL + "api/food").getCookies();
    }

    /**
     * Метод для получения количества товаров
     */
    public int getProductCount() {
        List<ProductMask> products = given()
                .cookies(cookies)
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "api/food")
                .then().log().all()
                .extract().body().jsonPath().getList("", ProductMask.class);

        return products.size();
    }

    /**
     * Метод для создания товара
     */
    public void createNewProduct(ProductMask product) {
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .body(product)
                .when()
                .post(URL + "api/food")
                .then().statusCode(200);
    }

    /**
     * Метод для сброса тестовых данных
     */
    public void resetTestData() {
        given()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post(URL + "api/data/reset")
                .then().statusCode(200);
    }

    public int getFoodCount(String foodName) {
        return databaseSteps.getFoodCount(foodName);
    }

}
