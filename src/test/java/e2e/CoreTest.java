package e2e;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CoreTest {

    protected static String token = "";
    protected static String urlBase = "";
    protected static String contentType = "application/json";


    protected static JSONObject postJson;
    protected static JSONObject pathJson;

    public static void testGet(int getStatusCode, String itemPath,String item){
        given().headers("Authorization", token, "Content-Type", contentType)
                .when().get(urlBase)
                .then().statusCode(getStatusCode).body(itemPath,hasItem(item));
    }

    public static void testPost(int postStatusCode, JSONObject postJson){
        given().headers("Authorization", token, "Content-Type", contentType)
                .body(postJson.toJSONString()).post(urlBase)
                .then()
                .assertThat().statusCode(postStatusCode);
    }

    public static void testPath(int pathStatusCode, JSONObject pathJson, String pathIndex){

        given()
                .headers("Authorization", token,"Content-Type", contentType)
                .body(pathJson.toJSONString())
                .patch(urlBase + pathIndex)
                .then()
                .assertThat()
                .statusCode(pathStatusCode);
    }

    public static void testDelete(int deleteStatusCode,String deletePath){

        given().headers("Authorization", token, "Content-Type", contentType)
                .delete(urlBase + deletePath)
                .then().assertThat().statusCode(deleteStatusCode);
    }
}
