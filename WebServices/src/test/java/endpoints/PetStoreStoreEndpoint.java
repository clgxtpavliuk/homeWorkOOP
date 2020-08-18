package endpoints;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Store;

public class PetStoreStoreEndpoint {

    public Response getStoreByOrderId(int orderId) {
        return given()
                .pathParam("orderId", orderId)
                .when()
                .get(Config.STORE_BY_ORDER_ID)
                .then()
                .extract().response();
    }

    public Response getPetByInventory() {
        return given()
                .when()
                .get(Config.STORE_BY_INVENTORY)
                .then()
                .extract().response();
    }

    public Response createStore(Store store) {
        return given()
                .body(store)
                .when()
                .post(Config.CREATE_STORE)
                .then()
                .extract().response();
    }

    public Response deleteStoreById(long orderId) {
        return given()
                .when()
                .delete(Config.STORE_BY_ORDER_ID, orderId)
                .then()
                .extract().response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(Config.PETSTORE_BASE_URL)
                .contentType(ContentType.JSON);
    }
}
