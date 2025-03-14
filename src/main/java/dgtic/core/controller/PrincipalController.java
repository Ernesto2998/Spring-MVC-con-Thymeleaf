package dgtic.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "user")
public class PrincipalController {
    @GetMapping("realizar-venta")
    public String getRealizarVVenta(Model modelo){
        modelo.addAttribute("contenido", "Realizar Venta");
        modelo.addAttribute("description",
                "En esta página se verán las opciones para realizar una venta." +
                        " Se tendrán que desplejar los libros junto con sus respectivos datos." +
                        " Se incluirá un botón para confirmar venta");
        return "principal/venta";
    }

    @GetMapping("historial-ventas")
    public String getHistorialVentas(Model modelo){
        modelo.addAttribute("contenido", "Historial de las ventas");
        modelo.addAttribute("description",
                "Se verá una tabla mostrando los libros vendidos, " +
                        "cuantos se vendieron y se inclurán las opciones para generar los reportes de las ventas");
        return "principal/historial";
    }

    @GetMapping("inventario")
    public String getInventario(Model modelo){
        modelo.addAttribute("contenido", "Inventario");
        modelo.addAttribute("description",
                "Se verá una tabla mostrando los libros vendidos, " +
                        "cuantos se vendieron y se inclurán las opciones para generar los reportes de las ventas");
        return "principal/inventario";
    }

    @GetMapping("sucursal")
    public String getSucursal(Model modelo){
        modelo.addAttribute("contenido", "Sucursal");
        modelo.addAttribute("description",
                "Se verá una tabla mostrando los libros vendidos, " +
                        "cuantos se vendieron y se inclurán las opciones para generar los reportes de las ventas");
        return "principal/inventario";
    }

    @GetMapping("usuarios")
    public String getUsuarios(Model modelo){
        modelo.addAttribute("contenido", "Gestionar Usuarios");
        modelo.addAttribute("description",
                "Se verá una tabla mostrando los libros vendidos, " +
                        "cuantos se vendieron y se inclurán las opciones para generar los reportes de las ventas");
        return "principal/usuarios";
    }
}
