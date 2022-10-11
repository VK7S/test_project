package api.rest;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import pages.logging.ReporterNG;

import java.util.Map;
import java.util.TreeMap;

public class RestAPILogFilter implements Filter {


    @Override
    public synchronized Response filter(FilterableRequestSpecification requestSpec,
                                        FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        ReporterNG.info("Request Log:");
        StringBuilder msg = new StringBuilder();
        msg.append(String.format("--request %s --url '%s' ", requestSpec.getMethod(), requestSpec.getURI()));
        msg.append(String.format("--header 'content-type: %s' ", requestSpec.getContentType()));
        if (requestSpec.getBody() != null) {
            String str = requestSpec.getBody().toString().replaceAll("\n", "");
            msg.append(String.format("--data '%s'", str.length() > 1024 ? str.substring(0, 1024) + " ..." : str));
        }
        ReporterNG.info(msg.toString());
        printParams(requestSpec.getQueryParams());
        ReporterNG.info(String.format("Response Status Line: %s | Response Time: %sms | Content-Type: %s",
                response.getStatusLine(), response.getTime(), response.getContentType()));
        return response;
    }

    private void printParams(Map<String, String> params) {
        if (params.size() > 0) {
            ReporterNG.info("Query params:");
            TreeMap<String, String> tree = new TreeMap<>(params);
            for (Map.Entry<String, String> entry : tree.entrySet()) {
                ReporterNG.info(String.format("    %s = %s", entry.getKey(), entry.getValue()));
            }
        }
    }

}
