package crjcact1_t4.act1_4.controllers;


import crjcact1_t4.act1_4.dto.ProductoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/productos")
public class ProductoViewController {

    @Value("${app.nombre-proyecto}")
    private String nombreProyecto;

    @Value("${app.estudiante}")
    private String nombreEstudiante;

    // Lista simulada en memoria
    private List<ProductoDTO> listaProductos = new ArrayList<>();

    public ProductoViewController() {
        listaProductos.add(new ProductoDTO(1L, "Laptop Dell", 15000.0, "Electronica"));
        listaProductos.add(new ProductoDTO(2L, "Teclado Mecanico", 1200.0, "Electronica"));
        listaProductos.add(new ProductoDTO(3L, "Silla Ergonomica", 3500.0, "Muebles"));
        listaProductos.add(new ProductoDTO(4L, "Monitor 4K", 8000.0, "Electronica"));
    }

    // a) Listado con @RequestParam (filtrado por categoría) y uso de @Value
    @GetMapping
    public String listarProductos(@RequestParam(name = "categoria", required = false) String categoria, Model model) {
        List<ProductoDTO> filtrados = listaProductos;

        if (categoria != null && !categoria.trim().isEmpty()) {
            filtrados = listaProductos.stream()
                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                    .collect(Collectors.toList());
        }

        model.addAttribute("productos", filtrados);
        model.addAttribute("categoriaFiltro", categoria != null ? categoria : "");
        model.addAttribute("nombreProyecto", nombreProyecto);
        model.addAttribute("estudiante", nombreEstudiante);

        return "productos/lista";
    }

    // Endpoint con @PathVariable para ver detalle por ID
    @GetMapping("/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        ProductoDTO producto = listaProductos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        model.addAttribute("producto", producto);
        model.addAttribute("estudiante", nombreEstudiante);

        return "productos/detalle";
    }

    // b) Formulario para crear un nuevo producto
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("productoDTO", new ProductoDTO());
        model.addAttribute("estudiante", nombreEstudiante);
        return "productos/formulario";
    }

    // b) Procesar formulario con @ModelAttribute
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute("productoDTO") ProductoDTO productoDTO, Model model) {
        productoDTO.setId((long) (listaProductos.size() + 1));
        listaProductos.add(productoDTO);

        model.addAttribute("productoGuardado", productoDTO);
        model.addAttribute("estudiante", nombreEstudiante);

        return "productos/resultado";
    }

    // Endpoint con @PathVariable para eliminar un producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") Long id) {
        listaProductos.removeIf(p -> p.getId().equals(id));
        return "redirect:/productos";
    }
}