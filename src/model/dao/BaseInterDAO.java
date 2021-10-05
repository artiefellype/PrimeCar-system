package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO <VO> {
	public void inserir(VO entity) throws SQLException;
	public void editar(VO entity) throws SQLException;
	public void deletar(VO entity) throws SQLException;
	public List<VO> listar(VO entity) throws SQLException;
}
