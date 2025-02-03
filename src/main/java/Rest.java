import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class Rest {

    public  static void main(String args[]) {

            RestAssured.baseURI = "https://api.coindesk.com";
            Response re = RestAssured.given().when().get("/v1/bpi/currentprice.json").then().extract().response();
//            re.prettyPrint();
            String responce = re.asString();
           JSONObject jsonObject = new JSONObject(responce);
              JSONObject bpi = jsonObject.getJSONObject("bpi");
              boolean isUSDPresent = bpi.has("USD");
              boolean isEURPresent = bpi.has("EUR");
              boolean isGBPPresent = bpi.has("GBP");
              System.out.println(isEURPresent);
              System.out.println(isEURPresent);
              System.out.println(isEURPresent);
              JSONObject Gbp= bpi.getJSONObject("GBP");
//              System.out.println(Gbp);
               String description=Gbp.getString("description");

        if ("British Pound Sterling".equals(description)) {
            System.out.println("The description is correct: " + description);
        } else {
            System.out.println("The description is incorrect: " + description);
        }
        }
    }
