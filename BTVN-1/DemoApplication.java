package com.example.demo;

import com.example.demo.BTVN.Film;
import com.example.demo.BTVN.LocalDateAdapter;
import com.example.demo.Bai1.entity.Book;
import com.example.demo.Bai2.Recipe;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public abstract class DemoApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        try {
            FileReader reader = new FileReader("FilmData.json");
            Type filmListType = new TypeToken<ArrayList<Film>>(){}.getType();
            ArrayList<Film> films = gson.fromJson(reader, filmListType);
            System.out.println(films);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
