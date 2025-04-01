import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo", "bar")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"));
    }

    @Test
    public void testPostRequest() {
        given()
                .header("Content-Type", "application/json")
                .body("{ \"key\": \"value\" }")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.key", equalTo("value"));
    }

    @Test
    public void testPutRequest() {
        given()
                .header("Content-Type", "application/json")
                .body("{ \"update\": \"true\" }")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.update", equalTo("true"));
    }

    @Test
    public void testPatchRequest() {
        given()
                .header("Content-Type", "application/json")
                .body("{ \"patched\": true }")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.patched", equalTo(true));
    }

    @Test
    public void testDeleteRequest() {
        when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", containsString("/delete"));
    }

    @Test
    public void testHeadRequest() {
        when()
                .head("/get")
                .then()
                .statusCode(200);
    }
}
