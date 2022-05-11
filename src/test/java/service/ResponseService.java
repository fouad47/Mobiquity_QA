package service;

import com.fasterxml.jackson.databind.ser.Serializers;
import common.Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class ResponseService {
    protected ResponseService(String hostUrl){

        RestAssured.baseURI = hostUrl;

    }

    protected Response get(Base base, Map<String, String> queryParameters){
        return RestAssured.given()
                .queryParams(queryParameters)
                .expect()
                .when()
                .get(base.path())
                .andReturn();
    }
}
