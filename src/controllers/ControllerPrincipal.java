/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import models.ModelPrincipal;
import views.ViewCliente;
import views.ViewPeliculas;
import views.ViewPrincipal;


public class ControllerPrincipal {
    
    ModelPrincipal model_principal;
    ViewPrincipal view_principal;
    ViewCliente view_cliente;
    ViewPeliculas view_peliculas;
    ControllerCliente controller_cliente;
    ControllerPeliculas controller_peliculas;
   
    public ControllerPrincipal( ModelPrincipal model_principal, Object views[]){
        this.model_principal = model_principal;
        this.view_principal = (ViewPrincipal) views[1];
        this.view_cliente = (ViewCliente) views[0];
        this.view_peliculas = (ViewPeliculas) views[0];
        view_principal.jmi_cliente.addActionListener(e -> jmi_clienteActionPerformed());
        view_principal.jmi_peliculas.addActionListener(e -> jmi_peliculasActionPerformed());
        initView();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==view_principal.jmi_cliente)
            jmi_clienteActionPerformed();
        else if (e.getSource()==view_principal.jmi_peliculas)
            jmi_peliculasActionPerformed();
    }
    public void jmi_clienteActionPerformed(){
        this.view_principal.setContentPane(view_cliente);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
    public void jmi_peliculasActionPerformed(){
        this.view_principal.setContentPane(view_peliculas);
        this.view_principal.revalidate();
        this.view_principal.repaint();
    }
    public void initView(){
        this.view_principal.setLocationRelativeTo(null);
        view_principal.setVisible(true);
    }
}
