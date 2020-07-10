package com.github.ethanbrown3.cs3230;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) {
//        try {
//            URI uri = new URI("https://api.github.com/users/ethanbrown3/repos");
//            URL url = uri.toURL();
//            System.out.println("URL = " + url);
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());
//        } catch (URISyntaxException e) {
//            System.out.println("URI Bad Syntax: " + e.getMessage());
//        } catch (MalformedURLException e) {
//            System.out.println("URL Malformed: " + e.getMessage());
//        }

        try {
//            URL url = new URL("http://example.org");
            URI baseUri = new URI("https://api.github.com");
            String githubUsername = "ethanbrown3";
            URI userUri = new URI("/users/" + githubUsername + "/repos");
            URI resolvedUri = baseUri.resolve(userUri);
            URL url = resolvedUri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("User-Agent", "Chrome");
//            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if(responseCode != 200) {
                System.out.println("Error reading web page");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String json = inputReader.readLine();
            inputReader.close();
            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            GithubRepo githubRepos[] = gson.fromJson(json, GithubRepo[].class); // deserializes json into target2
            System.out.println(githubRepos);
            for (GithubRepo repo : githubRepos) {
                System.out.println(repo);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
