package es.masanz.ut6.arkanoid.dao;

import es.masanz.ut6.arkanoid.database.ConnectionManager;
import es.masanz.ut6.arkanoid.model.Ladrillo;
import es.masanz.ut6.arkanoid.model.Nivel;

import java.util.List;

public class NivelDao {

    public static Nivel obtenerNivel(int id){
        // TODO 01: Buscar y devolver el nivel en caso de existir

        String sql = "SELECT id, filas, columnas, ladrillos, siguiente_nivel FROM nivel WHERE id = ?";
        Object[] params = {id};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql,params);

        if (resultado != null && resultado.length == 1) {
            Nivel nivel = new Nivel();

            nivel.setId((Integer) resultado[0][0]);
            nivel.setFilas((Integer) resultado[0][1]);
            nivel.setColumnas((Integer) resultado[0][2]);
            nivel.setLadrillos((List<Ladrillo>) resultado[0][3]);
            nivel.setSiguienteNivel((Integer) resultado[0][4]);
            return nivel;
        }
        return null;
    }


}
