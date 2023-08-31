package isi.dan.practicas.practica1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import isi.dan.practicas.practica1.model.Alumno;

public class PlainJdbcAlumnoDao implements AlumnoDao {

    private static final String INSERT_SQL     = "INSERT INTO ALUMNO (NOMBRE, LEGAJO) VALUES (?, ?)";
    private static final String UPDATE_SQL = "UPDATE ALUMNO SET NOMBRE=?,LEGAJO=? WHERE ID=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM ALUMNO";
    private static final String SELECT_ONE_SQL = "SELECT * FROM ALUMNO WHERE ID = ?";
    private static final String DELETE_SQL = "DELETE FROM ALUMNO WHERE ID=?";

    private final DataSource dataSource;

    public PlainJdbcAlumnoDao(DataSource ds) {
        this.dataSource = ds;
    }

    private void prepareStatement(PreparedStatement ps, Alumno alumno) throws SQLException {
        ps.setString(1, alumno.getNombre());
        ps.setInt(2, alumno.getLegajo());
    }

    @Override 
    public void insert(Alumno alumno) {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {
            prepareStatement(ps, alumno);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Iterable<Alumno> alumnos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Alumno alumno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Alumno alumno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Alumno findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<Alumno> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
