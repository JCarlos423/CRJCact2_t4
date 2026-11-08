package crjcact1_t4.act1_4.controllers;


import crjcact1_t4.act1_4.dto.ProductoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoRestController {

    // Endpoint REST POST recibiendo un DTO vía JSON
    @PostMapping
    public ResponseEntity crearProductoRest(@RequestBody ProductoDTO productoDTO) {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Producto procesado exitosamente via API REST");
        respuesta.put("estado", "Creado");
        respuesta.put("productoRecibido", productoDTO);
        respuesta.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }
}