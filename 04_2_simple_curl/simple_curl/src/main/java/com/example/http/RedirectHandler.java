package com.example.http;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.cli.CommandLine;

import com.example.http.request.HttpRequest;
import com.example.http.request.HttpRequestImpl;
import com.example.http.response.HttpResponse;

/**
 * 리다이렉트를 관리하는 클래스
 */
public class RedirectHandler {
    private static final int MAX_REDIRECT_COUNT = 5;

    public static HttpResponse handleRedirect(CommandLine cmd, HttpRequest httpRequest) {
        int redirectCount = 0;
        HttpResponse httpResponse = null;

        while (redirectCount < MAX_REDIRECT_COUNT) {
            httpResponse = HttpClient.sendRequest(cmd, httpRequest);
            int status = httpResponse.getStatus();

            if (status == 301 || status == 302 || status == 307 || status == 308) {
                String newLocation = httpResponse.getLocation();

                if (newLocation == null || newLocation.isEmpty()) {
                    System.err.println("Redirect location is missing in the response.");
                    break;
                }

                try {
                    URL newUrl = new URL(newLocation.startsWith("http") ? newLocation : "http://" + httpRequest.getHost() + newLocation);
                    httpRequest = new HttpRequestImpl(httpRequest.getMethod(), newUrl.toString());
                    redirectCount++;
                    System.out.println("* Redirecting to: " + newUrl);
                } catch (MalformedURLException e) {
                    System.err.println("Invalid redirect URL: " + newLocation);
                    break;
                }
            } else {
                break;
            }
        }

        if (redirectCount == MAX_REDIRECT_COUNT) {
            System.err.println("Error: Maximum redirect limit (" + MAX_REDIRECT_COUNT + ") reached.");
        }
        return httpResponse;
    }
}
