/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ModelClientes;
import views.ViewCliente;


public class ControllerCliente {
    
    private ModelClientes model_clientes;
    private ViewCliente view_cliente;
    
    public ControllerCliente(ModelClientes model_clientes, ViewCliente view_cliente){
       
        this.model_clientes = model_clientes;
        this.view_cliente = view_cliente;
        this.view_cliente.jbtn_primero.addActionListener(e -> jbtn_primero_clic());
        this.view_cliente.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_clic());
        this.view_cliente.jbtn_anterior.addActionListener(e -> jbtn_anterior_clic());
        this.view_cliente.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_clic());;
        this.view_cliente.jbtn_agregar.addActionListener(e -> jbtn_agregar_clic());
        this.view_cliente.jbtn_eliminar.addActionListener(e -> jbtn_borrar_clic());
        this.view_cliente.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_clic());
        initView();
    }
    public void getValores() {

        view_cliente.jtf_id_cliente.setText(" " + model_clientes.getId_cliente());
        view_cliente.jtf_nombre.setText(model_clientes.getNombre());
        view_cliente.jtf_telefono.setText(model_clientes.getTelefono());
        view_cliente.jtf_email.setText(model_clientes.getEmail());
        view_cliente.jtf_direccion.setText(model_clientes.getDireccion());
    }
    public void setValores() {
        model_clientes.setId_cliente(Integer.parseInt(view_cliente.jtf_id_cliente.getText()));
        model_clientes.setNombre(view_cliente.jtf_nombre.getText());
        model_clientes.setTelefono(view_cliente.jtf_telefono.getText());
        model_clientes.setEmail(view_cliente.jtf_email.getText());
        model_clientes.setDireccion(view_cliente.jtf_direccion.getText());
        
    }
    public void jbtn_agregar_clic() {
        view_cliente.jtf_id_cliente.setText(" ");
        view_cliente.jtf_nombre.setText(" ");
        view_cliente.jtf_telefono.setText(" ");
        view_cliente.jtf_email.setText(" ");

    }
     public void jbtn_actualizar_clic() {
        setValores();
        model_clientes.actualizar();
        getValores();

    }
     public void jbtn_borrar_clic() {
        setValores();
        model_clientes.borrar();
        getValores();
    }
     public void jbtn_primero_clic() {
        model_clientes.moverPrimero();
        getValores();
    }

    public void jbtn_ultimo_clic() {
        model_clientes.moverUltimo();
        getValores();
    }

    public void jbtn_siguiente_clic() {
        model_clientes.moverSiguiente();
        getValores();
    }

    public void jbtn_anterior_clic() {
        model_clientes.moverAnterior();
        getValores();
    }

    public void initView() {
        view_cliente.setVisible(true);
        model_clientes.Conectar();
        model_clientes.moverPrimero();
        getValores();
    }
}
