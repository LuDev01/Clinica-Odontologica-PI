package BackEndC3.ClinicaOdontologica.dao;

import BackEndC3.ClinicaOdontologica.model.Turno;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TurnoDAOLISTA implements iDao<Turno> {
    private static Integer idGenerator = 0;

    public Integer generateId() {
        idGenerator = idGenerator+1;
        return idGenerator;
    }

    private Logger logger= Logger.getLogger(TurnoDAOLISTA.class);
    private List<Turno> turnos= new ArrayList<>();
    @Override
    public Turno crear(Turno turno) {
        logger.info("iniciando las operaciones de guardado de un turno");
        PacienteDAOH2 pacienteDAOH2= new PacienteDAOH2();
        OdontologoDAOH2 odontologoDAOH2= new OdontologoDAOH2();
        turno.setPaciente(pacienteDAOH2.buscarPorId(turno.getPaciente().getId()));
        turno.setOdontologo(odontologoDAOH2.buscarPorId(turno.getOdontologo().getId()));
        turno.setId(generateId());
        turnos.add(turno);
        logger.info("turno guardado con exito");
        return turno;
    }

    @Override
    public Turno buscarPorId(Integer id) {
        for (Turno turno : turnos) {
            if(turno.getId().equals(id)){
                return turno;
            }else{
                System.out.println("turno no encontrado");
            }

        }
        return null;
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        logger.info("iniciando las operaciones de eliminar el turno: " + id);

        Turno turnoPorEliminar = this.buscarPorId(id);
        if (turnoPorEliminar == null){
            throw new Exception("Turno no encontrado");
        }
        this.turnos.remove(this.buscarPorId(id));
    }

    @Override
    public void actualizar(Turno turno)  {


        int index = this.turnos.indexOf(this.buscarPorId(turno.getId()));
        this.turnos.set(index, turno);


    }

    @Override
    public List<Turno> buscarTodos() {
        logger.info("iniciando las operacion de mostrar todos los turnos");
        return turnos;
    }

    @Override
    public Turno buscarPorString(String string) {
        return null;
    }
}
