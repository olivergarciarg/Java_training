package com.oliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
//            URL url = new URL("http://example.org");
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent","Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("arrrghhh");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line = "";
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
            }
            inputStream.close();

//            URLConnection urlConnection = url.openConnection();
//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//
////            BufferedReader inputStream = new BufferedReader(
////                    new InputStreamReader(url.openStream())
////            );
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream())
//            );
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry: headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> values = entry.getValue();
//                System.out.println("key: " + key);
//                for (String value: values) {
//                    System.out.println("value: " + value);
//                }
//            }
//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();

//            URI uri = url.toURI();
//            URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            URI baseUri =  new URI("http://username:password@myserver.com:5000");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI uri3 = new URI("/store/locations?zip=12345");
//
//            URI resolvedUri1 = baseUri.resolve(uri1);
//            URI resolvedUri2 = baseUri.resolve(uri2);
//            URI resolvedUri3 = baseUri.resolve(uri3);
//
//            URL url1 = resolvedUri1.toURL();
//            URL url2 = resolvedUri2.toURL();
//            URL url3 = resolvedUri3.toURL();
//            System.out.println(url1);
//            System.out.println(url2);
//            System.out.println(url3);
//
//            URI relativizedURI = baseUri.relativize(resolvedUri2);
//            System.out.println(relativizedURI);

//            System.out.println("Scheme: " + uri.getScheme());
//            System.out.println("Scheme-specific part: " + uri.getSchemeSpecificPart());
//            System.out.println("Authority: " + uri.getAuthority());
//            System.out.println("User Info: " + uri.getUserInfo());
//            System.out.println("Host: " + uri.getHost());
//            System.out.println("Port: " + uri.getPort());
//            System.out.println("Path: " + uri.getPath());
//            System.out.println("Path query: " + uri.getQuery());
//            System.out.println("Fragment: " + uri.getFragment());
//        } catch (URISyntaxException e) {
//            System.out.println("URI bad syntax " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL bad syntax " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }
}