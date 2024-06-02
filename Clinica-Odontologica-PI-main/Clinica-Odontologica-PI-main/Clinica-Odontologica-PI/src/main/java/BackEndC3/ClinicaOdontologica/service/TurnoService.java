package BackEndC3.ClinicaOdontologica.service;

import BackEndC3.ClinicaOdontologica.dao.TurnoDAOLISTA;
import BackEndC3.ClinicaOdontologica.dao.iDao;
import BackEndC3.ClinicaOdontologica.model.Turno;

import java.util.List;

public class TurnoService {
    private iDao<Turno> turnoiDao;

    public TurnoService() {
        turnoiDao= new TurnoDAOLISTA();
    }
    public Turno guardarTurno(Turno turno){
        return turnoiDao.crear(turno);
    }
    public List<Turno> buscarTodos(){
        return turnoiDao.buscarTodos();
    }
    public Turno buscarPorId(Integer id){
        return turnoiDao.buscarPorId(id);
    }
    public String eliminarPorId(Integer id){
        try {
            turnoiDao.eliminar(id);
            return "Turno eliminado correctamente";
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
