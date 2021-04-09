package e2e;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static e2e.CoreTest.*;

public class UsersTest {
    
     public JSONObject createUserJson(String currentPassword, String role, String name, String newPassword, String username) {
        JSONObject json = new JSONObject();
        json.put("currentPassword", currentPassword);
        json.put("idRole", role);
        json.put("name", name);
        json.put("newPassword", newPassword);
        json.put("username", username);
        return json;
    }

    @BeforeAll
    public void setGlobalVar(){
        urlBase += "http://localhost:8080/";
        token += "";
    }

    @Test
    public void t1_getUsers(){
        testGet(200, "items.name", "Administrador");
    }

    @Test
    public void t2_postUsers(){
        String name = "test01";
        JSONObject postJson = createUserJson("test01", "1", name, "test01", "testttBBB");
        testPost(201, postJson);
        
//         postJson = new JSONObject();
//         postJson.put("currentPassword", "test01");
//         postJson.put("idRole", "1");
//         postJson.put("name", "test01");
//         postJson.put("newPassword", "test01");
//         postJson.put("username", "testeBBB");
        testGet(200, "items.name", name);
    }

    @Test
    public void t3_pathUsers(){
        pathJson = new JSONObject();
        pathJson.put("name", "perto");
        pathJson.put("username", "coelho");
        testPath(200, pathJson, "02");
        testGet(200, "items.name", "perto");
    }

    @Test
    public void t4_deleteUsers(){
        testDelete(200, "/2");
        testGet(200, "items.name", "perto");
    }
}
