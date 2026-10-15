package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerSinCache() {
        return repository.findAll();
    }

    @Cacheable(value = "productosCache")
    public List<Producto> obtenerConCache() {
        return repository.findAll();
    }

    @CacheEvict(value = "productosCache", allEntries = true)
    public void limpiarCache() {
        System.out.println("Caché invalidada.");
    }
}