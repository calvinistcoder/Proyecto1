/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author abner
 */
public class ModeloTienda {
    int IdTienda;
    String Nombre;
    String Direccion;
    int Telefono;
    int Nit;
    private Conexion conexion;
    
    public ModeloTienda(){
        conexion = new Conexion();
    }

    public int getIdTienda() {
        return IdTienda;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public int getNit() {
        return Nit;
    }

    public void setIdTienda(int IdTienda) {
        this.IdTienda = IdTienda;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public void setNit(int Nit) {
        this.Nit = Nit;
    }
    
    public String insertarTienda(ModeloTienda tienda){
        Connection cx = conexion.conectar();
        if(cx != null){
            try{
                String spInsertarTienda = "{call insertarTienda(?,?,?,?)}";
                CallableStatement statement = cx.prepareCall(spInsertarTienda);
                statement.setString(1, tienda.getNombre());
                statement.setString(2, tienda.getDireccion());
                statement.setInt(3, tienda.getTelefono());
                statement.setInt(4, tienda.getNit());
                statement.execute();
                return "El registro se inserto con exito";
            } catch(SQLException ex){
                return ex.getMessage();
            } finally {
                conexion.desconectar();
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
    
    public String modificarTienda(ModeloTienda tienda){
        Connection cx = conexion.conectar();
        if(cx!=null){
            try{    
            String spModificarTienda = "{call spModificarTienda(?,?,?,?,?)}";
            CallableStatement statement = cx.prepareCall(spModificarTienda);
            statement.setInt(1, tienda.getIdTienda());
            statement.setString(2, tienda.getNombre());
            statement.setString(3, tienda.getDireccion());
            statement.setInt(4, tienda.getTelefono());
            statement.setInt(5, tienda.getNit());
            statement.execute();
            return "El registro se modifico con exito";
            } catch(SQLException ex){
                return ex.getMessage();
            } finally{
                conexion.desconectar();
            }
            
        } else {
            System.out.println("No se puede conectar a la base de datos");
        }
        return null;
    }
    
    public String borrarTienda(ModeloTienda tienda){
        Connection cx= conexion.conectar();
        if(cx!=null){
            try{
                String spBorrarTienda = "{call borrarTienda(?)}";
                CallableStatement statement = cx.prepareCall(spBorrarTienda);
                statement.setInt(1, tienda.getIdTienda());
                statement.execute();
                return "El registro se borro con exito";
            } catch(SQLException ex){
                return ex.getMessage();
            } finally {
                conexion.desconectar();
            }
        } else {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
    
}
