/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloProductos;

/**
 *
 * @author abner
 */
public class ControladorProductos {
    private ModeloProductos modelo;
    
    public ControladorProductos(){
        modelo = new ModeloProductos();
    }
    
    public String InsertarProducto(String nombreProducto, double precioProducto, int cantidad_producto){
        modelo.setNombre(nombreProducto);
        modelo.setPrecio(precioProducto);
        modelo.setCantidad(cantidad_producto);
        String mensaje = modelo.insertarProducto(modelo);
        return mensaje;
    }
    
    public String ModificarProducto(int IdProducto, String nombreProducto, double precioProducto, int cantidad_producto){
        modelo.setIdProducto(IdProducto);
        modelo.setNombre(nombreProducto);
        modelo.setPrecio(precioProducto);
        modelo.setCantidad(cantidad_producto);
        String mensaje = modelo.modificarProducto(modelo);
        return mensaje;
    }
    
    public String BorrarProducto (int IdProducto){
        modelo.setIdProducto(IdProducto);
        String mensaje = modelo.borrarProducto(modelo);
        return mensaje;
    }
}
