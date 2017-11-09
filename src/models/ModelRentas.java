/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelRentas {
    private Connection conexion;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    private int id_renta;
    private int id_cliente;
    private int id_pelicula;
    private String formato;
    private String costo_dias;
    private String dias;
    private String total_renta;

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }
    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public void setId_pelicula(int id_pelicula){
        this.id_pelicula = id_pelicula;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public void setCosto_dias(String costo_dias){
        this.costo_dias = costo_dias;
    }
    public void setDias(String Dias){
        this.dias = dias;
    }
    public void setTotal_renta(String total_renta){
        this.total_renta = total_renta;
    }
    
    
    public int getId_renta() {
        return id_renta;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    
    public int getId_pelicula() {
        return id_pelicula;
    }
    
    public String getFormato(){
        return formato;
    }
    public String getCosto_dias(){
        return costo_dias;
    }
    public String getDias(){
        return dias;
    }
    public String getTotal_renta(){
        return total_renta;
    }
    
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/acme_mvc", "root","1234");
        st = conexion.createStatement();
        seleccionarTodos();
    }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error 101" + ex.getMessage());
    }  
  }//Conectar
    
    public void llenarValores(){
      try{
          
          setId_renta(rs.getInt("id_nombre"));
          setId_cliente(rs.getInt("id_cliente"));
          setId_pelicula(rs.getInt("id_pelicula"));
          setFormato(rs.getString("formato"));
          setCosto_dias(rs.getString("costodias"));
          setDias(rs.getString("dias"));
          setTotal_renta(rs.getString("total_renta"));
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 102" + ex.getMessage());
      }
  }
    public void moverPrimero(){
      try{
          rs.first();
          llenarValores();
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 103" + ex.getMessage());
      }
  }
     public void moverUltimo(){
      try{
          rs.last();
          llenarValores();
      } catch (SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 104"+ ex.getMessage());
      }
  }
     public void moverSiguiente(){
      try{
          if(rs.isLast() == false){
              rs.next();
              llenarValores();
          }
      } catch (SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 105"+ ex.getMessage());
      }
  }
     public void moverAnterior(){
      try{
          if(rs.isFirst() == false){
              rs.previous();
              llenarValores();}
          }catch (SQLException ex){
              JOptionPane.showMessageDialog(null,"Error 106"+ ex.getMessage());
      }
  }
     public void seleccionarTodos(){
      try{
          sql = "SELECT * FROM rentas";
          ps = conexion.prepareStatement(sql);
          rs = ps.executeQuery();
          moverPrimero();
      }catch (SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 107"+ ex.getMessage());
      }
  }
     public void insertar(){
      try{
          sql = "INSERT INTO rentas(formato,costodia,dias,total_renta) VALUES ();";
          
          ps.setString(0,formato);
          ps.setString(1,costo_dias);
          ps.setString(2, dias);
          ps.setString(3, total_renta);
          ps.executeUpdate();
          moverPrimero();
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 108"+ ex.getMessage());
      }
  }
     public void borrar(){
      try{
          sql = "DELETE * FROM rentas WHERE id_renta = ;";
          ps = conexion.prepareStatement(sql);
          ps.setInt(0, id_renta);
          ps.setInt(1, id_cliente);
          ps.setInt(2, id_pelicula);
          ps.executeUpdate();
          moverPrimero();
          
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error 109"+ ex.getMessage());
      }
  }
     public void actualizar(){
      try{
          sql = "UPDATE rentas SET formato = ? , costodia = ? , dias = ?, total_renta WHERE id_persona, id_cliente, id_pelicula;";
          ps.setInt(3, id_renta);
          ps.setInt(4, id_cliente);
          ps.setInt(5, id_pelicula);
          ps.setString(0, formato);
          ps.setString(1, costo_dias);
          ps.setString(2, dias);
          ps.setString(3, total_renta);
          ps.executeUpdate();
          moverPrimero();
      }catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error 110"+ ex.getMessage());
      }
  }
}
