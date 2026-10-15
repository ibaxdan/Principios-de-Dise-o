package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/sin-cache")
    public ResponseEntity<Map<String, Object>> getSinCache() {
        long inicio = System.currentTimeMillis();
        List<Producto> datos = service.obtenerSinCache();
        long fin = System.currentTimeMillis();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("tipo", "Directo a Base de Datos (Sin Caché)");
        respuesta.put("totalRegistros", datos.size());
        respuesta.put("tiempoMs", (fin - inicio));
        respuesta.put("muestra", datos.subList(0, 10));
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/con-cache")
    public ResponseEntity<Map<String, Object>> getConCache() {
        long inicio = System.currentTimeMillis();
        List<Producto> datos = service.obtenerConCache();
        long fin = System.currentTimeMillis();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("tipo", "Con Caché en Memoria");
        respuesta.put("totalRegistros", datos.size());
        respuesta.put("tiempoMs", (fin - inicio));
        respuesta.put("muestra", datos.subList(0, 10));
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/limpiar-cache")
    public ResponseEntity<String> clearCache() {
        service.limpiarCache();
        return ResponseEntity.ok("Caché eliminada.");
    }
}