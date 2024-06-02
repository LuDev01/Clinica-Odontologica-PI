package BackEndC3.ClinicaOdontologica.service;
import BackEndC3.ClinicaOdontologica.dao.OdontologoDAOH2;
import BackEndC3.ClinicaOdontologica.dao.iDao;
import BackEndC3.ClinicaOdontologica.model.Odontologo;

import java.util.List;

public class OdontologoService {

    private iDao<Odontologo> odontologoiDao;
    private iDao<Odontologo> odontologoiDaoMemoria;

    public OdontologoService() {
        odontologoiDao = new OdontologoDAOH2();
    }

    public List<Odontologo> buscarOdontologos() {
        return odontologoiDao.buscarTodos();
    }

    public Odontologo crearOdontologos(Odontologo odontologo) {
        return odontologoiDao.crear(odontologo);
    }

    public Odontologo buscarPorId(Integer id) {
        return odontologoiDao.buscarPorId(id);
    }

    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        odontologoiDao.actualizar(odontologo);
        return odontologo;
    }

    public String eliminarOdontologo(Integer id){
        try{
            odontologoiDao.eliminar(id);
            return "Odontologo eliminado con éxito!";
        }catch (Exception e){
            return "Odontlogo no eliminado";
        }

    }


}


