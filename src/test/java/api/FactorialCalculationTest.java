package api;

import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utils.FactorialCalculation.factorialCalculation;

public class FactorialCalculationTest {

    @DataProvider
    public Object[] inputData() {
        return new Object[][]{
                {0},
                {-1},
                {1},
                {13},
                {256},
                {2000}
        };
    }

    @Test(dataProvider = "inputData")
    private void calculationTest(int num) {
        String expectedFactorial = String.valueOf(factorialCalculation(num));
        String actualFactorial = given().baseUri("https://qainterview.pythonanywhere.com")
                .param("number", String.valueOf(num))
                .when()
                .post("/factorial")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .body()
                .path("answer")
                .toString();
        Assert.assertEquals(actualFactorial, expectedFactorial);
    }
}
