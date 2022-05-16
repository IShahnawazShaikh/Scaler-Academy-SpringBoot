package com.scaler;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class JavaBasicApplication {
    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) {

        SpringApplication.run(JavaBasicApplication.class, args);
        System.out.println("Hello world");
        try {
            getUrl("https://example.com/");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static String getUrl(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }

    }

