package BackEndC3.ClinicaOdontologica.controller;

import BackEndC3.ClinicaOdontologica.model.Odontologo;
import BackEndC3.ClinicaOdontologica.service.OdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;

    public OdontologoController() {
      odontologoService=new OdontologoService();
    }
 /*   @GetMapping
    public String buscarOdontologoTodos(Model model){
        List<Odontologo>listaOdontogos=odontologoService.buscarOdontologos();
        model.addAttribute("odontologos",listaOdontogos);
        return "listaodontologos.html";
    }*/
     @GetMapping
        public List<Odontologo> buscarOdontologoTodos() {
         List<Odontologo> listaOdontogos = odontologoService.buscarOdontologos();
         return listaOdontogos;
     }
    @PostMapping
    public Odontologo guardarOdontologo(@RequestBody Odontologo odontologo){
        return odontologoService.crearOdontologos(odontologo);
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
         Odontologo odontologoBuscado=odontologoService.buscarPorId(odontologo.getId());
         if (odontologoBuscado != null){
             return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
         }
         else {
             return ResponseEntity.badRequest().build();
         }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo>buscarOdontologoPorId(@PathVariable Integer id){
         return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id){
         Odontologo odontologo=odontologoService.buscarPorId(id);
         if (odontologo==null){
             return ResponseEntity.badRequest().build();
         }

         return ResponseEntity.ok(odontologoService.eliminarOdontologo(id));
    }
}


