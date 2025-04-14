package dgtic.core.controller;

import dgtic.core.model.Clasificacion;
import dgtic.core.model.Pais;
import dgtic.core.model.Sucursal;
import dgtic.core.service.Sucursal.SucursalService;
import dgtic.core.service.pais.PaisService;
import dgtic.core.util.RenderPagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Controller
@RequestMapping(value = "libreria/gestionar/sucursal")
public class ManagerSucursalController {

    @Autowired
    MessageSource mensaje;
    @Autowired
    SucursalService sucursalService;
    @Autowired
    PaisService paisService;

    @GetMapping("")
    public String getGestionar(@RequestParam(name = "page", defaultValue = "0") int page,
                               Model modelo) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Sucursal> sucursales = sucursalService.findPage(pageable);
        RenderPagina<Sucursal> renderPagina = new RenderPagina<>("sucursal", sucursales);
        List<Pais> paises = paisService.findAll();

        modelo.addAttribute("sucursal", new Sucursal());
        modelo.addAttribute("sucursalB", new Sucursal());
        modelo.addAttribute("pais", paises);
        modelo.addAttribute("contenido", "Gestionar Sucursales");
        modelo.addAttribute("listaSucursales", sucursales);
        modelo.addAttribute("page", renderPagina);
        return "principal/sucursal/gestionSucursal";
    }

    @GetMapping("delete-sucursal/{id}")
    public String eliminarSucursal(@PathVariable("id") Integer id,
                                RedirectAttributes modelo) {
        sucursalService.deleteById(id);

        return "redirect:/libreria/gestionar/sucursal";
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String errorRuntimeDuplicated(SQLIntegrityConstraintViolationException e,
                                         Model model) {
        String msg = mensaje.getMessage("Error.base.sucursalDuplicada",
                null, LocaleContextHolder.getLocale());
        model.addAttribute("explicacion", msg);
        return "error-general";
    }
}
