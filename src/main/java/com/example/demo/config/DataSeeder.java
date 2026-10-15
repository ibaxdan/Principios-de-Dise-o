package com.example.demo.config;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository repository;

    public DataSeeder(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        System.out.println("--> Iniciando carga masiva de registros...");
        List<Producto> lista = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            lista.add(new Producto("Producto " + i, 10.0 + (i % 100), "Categoria " + (i % 5)));
        }
        repository.saveAll(lista);
        System.out.println("--> 50,000 registros insertados exitosamente.");
    }
}