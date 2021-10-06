package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BaseInterDAO <VO> {
	public void inserir(VO entity) throws SQLException;
	public void editar(VO entity) throws SQLException;
	public void remover(VO entity) throws SQLException;
	public List<VO> listar(VO entity) throws SQLException;
}
