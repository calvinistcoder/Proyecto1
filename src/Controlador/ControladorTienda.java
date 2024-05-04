/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ModeloTienda;

/**
 *
 * @author abner
 */
public class ControladorTienda {
    private ModeloTienda modelo;
    
    public ControladorTienda(){
        modelo = new ModeloTienda();
    }
    
    public String InsertarTienda(String nombre_tienda, String direccion_tienda, int telefono_tienda, int nit_tienda){
        modelo.setNombre(nombre_tienda);
        modelo.setDireccion(direccion_tienda);
        modelo.setTelefono(telefono_tienda);
        modelo.setNit(nit_tienda);
        String mensaje = modelo.insertarTienda(modelo);
        return mensaje;
    }
    
    public String ModificarTienda(int id_tienda, String nombre_tienda, String direccion_tienda, int telefono_tienda, int nit_tienda){
        modelo.setIdTienda(id_tienda);
        modelo.setNombre(nombre_tienda);
        modelo.setDireccion(direccion_tienda);
        modelo.setTelefono(telefono_tienda);
        modelo.setNit(nit_tienda);
        String mensaje = modelo.modificarTienda(modelo);
        return mensaje;
    }
    
    public String BorrarTienda(int IdTienda){
        modelo.setIdTienda(IdTienda);
        String mensaje = modelo.borrarTienda(modelo);
        return mensaje;
    }
}
