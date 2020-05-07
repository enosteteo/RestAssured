package e2e;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static e2e.CoreTests.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsersTest {

    @Before
    public void setGlobalVar(){
        urlBase = "";
        token = "";
    }

    @Test
    public void t1_getUsers(){
        testGet(200, "items.name", "Administrador");
    }

    @Test
    public void t2_postUsers(){
        postJson = new JSONObject();
        postJson.put("currentPassword", "test01");
        postJson.put("idRole", "1");
        postJson.put("name", "test01");
        postJson.put("newPassword", "test01");
        postJson.put("username", "testeBBB");

        testPost(201, postJson);
        testGet(200, "items.name", "test01");
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
