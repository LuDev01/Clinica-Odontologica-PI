package BackEndC3.ClinicaOdontologica.dao;

import java.util.List;

public interface iDao<T> {
    //todo el crud
    T crear(T t);
    T buscarPorId(Integer id);
    void eliminar(Integer id) throws Exception;
    void actualizar(T t);

    List<T> buscarTodos();
    T buscarPorString(String string);

}
