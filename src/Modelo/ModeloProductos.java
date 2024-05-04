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
public class ModeloProductos {
    int IdProducto;
    String Nombre;
    double Precio;
    int Cantidad;
    private Conexion conexion;
    
    public ModeloProductos() {
        conexion = new Conexion();
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String insertarProducto (ModeloProductos producto){
        Connection cx = conexion.conectar();
        if(cx != null){
            try{
                String spInsertarProducto= "{call insertarProducto(?,?,?)}";
                CallableStatement statement = cx.prepareCall(spInsertarProducto);
                statement.setString(1, producto.getNombre());
                statement.setDouble(2, producto.getPrecio());
                statement.setInt(3, producto.getCantidad());
                statement.execute();
                return "El registro se inserto con exito";
            }catch(SQLException ex){
                return ex.getMessage();
            }finally{
                conexion.desconectar();
            }
            
        }else {
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
    
    public String modificarProducto(ModeloProductos producto){
        Connection cx = conexion.conectar();
        if(cx!=null){
            try{
                String spModificarProducto = "{call modificarProducto(?,?,?,?)}";
                CallableStatement statement = cx.prepareCall(spModificarProducto);
                statement.setInt(1, producto.getIdProducto());
                statement.setString(2, producto.getNombre());
                statement.setDouble(3, producto.getPrecio());
                statement.setInt(4, producto.getCantidad());
                statement.execute();
                return "El registro se modifico con exito";
            } catch(SQLException ex){
                return ex.getMessage();
            }finally{
                conexion.desconectar();
            }
            
        }else{
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
    
    public String borrarProducto(ModeloProductos producto){
        Connection cx = conexion.conectar();
        if(cx!=null){
            try{
                String spBorrarProducto = "{call borrarProducto(?)}";
                CallableStatement statement = cx.prepareCall(spBorrarProducto);
                statement.setInt(1, producto.getIdProducto());
                System.out.println(producto.getIdProducto());
                statement.execute();
                return "El registro se borro con exito";
            } catch(SQLException ex){
                return ex.getMessage();
            }finally{
                conexion.desconectar();
            }
        }else{
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
}
