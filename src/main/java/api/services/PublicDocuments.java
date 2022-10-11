package api.services;

import api.common.RestParams;
import api.models.Config.Config;
import api.models.Search.SearchResponse;
import api.rest.Endpoints;
import api.rest.Params;
import api.rest.RestAPILogFilter;
import api.rest.RestBase;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;

public class PublicDocuments extends RestBase {
    private static String URI;
    private final Gson gson = new Gson();
    private final Filter logFilter = new RestAPILogFilter();
    final private RequestSpecification requestSpec;


    public PublicDocuments(Config config) {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(config.uri)
                .addFilter(logFilter)
                .setBasePath(Endpoints.PublicDocs.PUBLIC_DOCS)
                .setContentType(ContentType.URLENC).build();
        URI = config.uri;
    }

    public SearchResponse searchForKeyword(String text, String deploymentId) {
        return searchForKeyword(text, deploymentId, HttpURLConnection.HTTP_OK);
    }

    public SearchResponse searchForKeyword(String text, String deploymentId, int expectedStatusCode) {
        RestParams params = new RestParams();
        params.put(Params.PublicDocument.KEYWORD, text);
        params.put(Params.PublicDocument.POSITIVEONLY, false);
        params.put(Params.PublicDocument.SLOP, 15);
        params.put(Params.PublicDocument.NEGATIVEONLY, false);
        params.put(Params.PublicDocument.RELEASED, "1633003200000");
        RequestSpecification spec = given().spec(requestSpec).queryParam("documentId", deploymentId);
        Response response = get(Endpoints.PublicDocs.DOCUMENT, spec, params, expectedStatusCode);
        final SearchResponse request = gson.fromJson(new JsonParser().parse(response.asString()), SearchResponse.class);
        return request;
    }


}
