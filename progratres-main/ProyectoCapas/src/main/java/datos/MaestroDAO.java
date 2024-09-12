/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Maestro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class MaestroDAO {
    private static final String SQL_SELECT = "SELECT id-maestro, nombre-maestro, pago-maestro FROM maestros";
    private static final String SQL_INSERT = "INSERT INTO maestros(nombre-maestro, dire-maestro) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE maestro SET nombre-maestro=?, pago-maestro=? WHERE id-maestro = ?";
    private static final String SQL_DELETE = "DELETE FROM maestro WHERE id-maestro=?";
    private static final String SQL_QUERY = "SELECT id-maestro, nombre-maestro, pago-maestro FROM maestros WHERE id-maestro = ?";


    public List<Maestro> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Maestro maestro = null;
        List<Maestro> maestros = new ArrayList<Maestro>();

        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_maestro = rs.getInt("id-maestro");
                String nombre = rs.getString("nombre-maestro");
                String pago = rs.getString("pago-maestro");
                
                maestro = new Maestro();
                maestro.setId_maestro(id_maestro);
                maestro.setNombreMaestro(nombre);
                maestro.setPago(pago);
                
                maestros.add(maestro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(rs);
            conexion.close(stmt);
            conexion.close(conn);
        }

        return maestros;
    }

    public int insert(Maestro empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, empleado.getNombreMaestro());
            stmt.setString(2, empleado.getPago());


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }

        return rows;
    }

    public int update(Maestro empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombreMaestro());
            stmt.setString(2, empleado.getPago());
            

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }

        return rows;
    }

    public int delete(Maestro empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getId_maestro());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(stmt);
            conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona empleado) { // Si se utiliza un ArrayList
    public Maestro query(Maestro empleado) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Maestro> empleados = new ArrayList<Maestro>();
        int rows = 0;

        try {
            conn = conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, empleado.getId_maestro());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_empleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre_empleado");
                String pago = rs.getString("dire_empleado");
                
                empleado = new Maestro();
                empleado.setId_maestro(id_empleado);
                empleado.setNombreMaestro(nombre);
                empleado.setPago(pago);
                
                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            conexion.close(rs);
            conexion.close(stmt);
            conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return empleado;
    }
    
}
