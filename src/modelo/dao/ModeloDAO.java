package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class ModeloDAO<T> {
	public abstract String registrar (T dto)throws SQLException;
	public abstract T consultar (String text)throws SQLException;
	public abstract ArrayList<T> consultarLista()throws SQLException;
	public abstract String actualizar(T dto)throws SQLException;
	public abstract String eliminar (T dto)throws SQLException;
}
