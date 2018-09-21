package unittest.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        //String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10}"; //will fail in case of strict = true
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"; //will pass
        JSONAssert.assertEquals(expectedResponse,actualResponse,true);
    }

    @Test
    public void jsonAssert_StrictFalse_ExactMatchExceptForSpaces() throws JSONException {
        //String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":11}"; //will fail as expected is 11 but getting 10
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10}"; //will pass
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacter() throws JSONException {
        String expectedResponse = "{id: 1,name:Ball,price:10}"; //will pass
        JSONAssert.assertEquals(expectedResponse,actualResponse,false);
        //we need escape character when we have space in value of json object
    }
}
