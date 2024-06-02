package BackEndC3.ClinicaOdontologica.controller;

import BackEndC3.ClinicaOdontologica.model.Odontologo;
import BackEndC3.ClinicaOdontologica.model.Paciente;
import BackEndC3.ClinicaOdontologica.model.Turno;
import BackEndC3.ClinicaOdontologica.service.OdontologoService;
import BackEndC3.ClinicaOdontologica.service.PacienteService;
import BackEndC3.ClinicaOdontologica.service.TurnoService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    public TurnoController() {
        turnoService= new TurnoService();
        pacienteService= new PacienteService();
        odontologoService= new OdontologoService();
    }

    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno){
        Paciente pacienteBuscado= pacienteService.buscarPorID(turno.getPaciente().getId());
        Odontologo odontologoBuscado= odontologoService.buscarPorId(turno.getOdontologo().getId());
        if(pacienteBuscado!=null&&odontologoBuscado!=null){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else{
            return ResponseEntity.badRequest().build();
        }

    }
    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Integer id){
        String message = turnoService.eliminarPorId(id);
        if (message == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(turnoService.eliminarPorId(id));
    }
}