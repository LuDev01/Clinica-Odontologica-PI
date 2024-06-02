package BackEndC3.ClinicaOdontologica.controller;

import BackEndC3.ClinicaOdontologica.model.Paciente;
import BackEndC3.ClinicaOdontologica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //para trabajar sin tecnologia de vista
//@Controller //<-- es controller pq vamos a usar una tecnologia de vista
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;
    public PacienteController() {
        pacienteService= new PacienteService();
    }
    //ahora vienen todos los metodos que nos permitan actuar como intermediarios.

    /* @GetMapping
    public String buscarPacientePorCorreo(Model model, @RequestParam("email") String email){

        Paciente paciente= pacienteService.buscarPorEmail(email);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        model.addAttribute("matricula",paciente.getOdontologo().getNumeroMatricula());
        return "index";
    }

    @GetMapping("/todos")
    public String buscarPacienteTodos(Model model ){
        List<Paciente> listadoPacientes=pacienteService.buscarTodosPacientes();
        model.addAttribute("pacientes",listadoPacientes);
        return "listapacientes";
    }*/
    @GetMapping
    public List<Paciente> buscarPacienteTodos(){
        List<Paciente> listadoPacientes=pacienteService.buscarTodosPacientes();
        return listadoPacientes;
    }
    @PostMapping //--> nos permite persistir los datos que vienen desde la vista
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }
    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){

        Paciente pacienteBuscado= pacienteService.buscarPorID(paciente.getId());
        if(pacienteBuscado!=null){
            pacienteService.actualizarPaciente(paciente);
            return "paciente actualizado con exito";
        }else{
            return "paciente no encontrado";
        }
    }
    @GetMapping("/{id}")
    public Paciente buscarPorPaciente(@PathVariable Integer id){

        return pacienteService.buscarPorID(id);
    }
    @DeleteMapping("/{id}")
    public String pacienteAEliminar(@PathVariable Integer id){
        Paciente pacienteConsultado= pacienteService.buscarPorID(id);
        if(pacienteConsultado!=null){
            return pacienteService.pacienteAEliminar(pacienteConsultado);
        }else{
            return "Paciente no encontrado";
        }
    }
}
