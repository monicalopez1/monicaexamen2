/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.ModelClientes;
import models.ModelPeliculas;
import models.ModelPrincipal;
import views.ViewCliente;
import views.ViewPeliculas;
import views.ViewPrincipal;
import controllers.ControllerCliente;
import controllers.ControllerPeliculas;
import controllers.ControllerPrincipal;

public class Main {
    
    public static void main(String [] mla ){
     ModelClientes model_cliente = new ModelClientes();
     ViewCliente view_cliente = new ViewCliente();
     ControllerCliente controller_cliente = new ControllerCliente (model_cliente, view_cliente);
     
     ModelPeliculas model_peliculas = new ModelPeliculas();
     ViewPeliculas view_peliculas = new ViewPeliculas();
     ControllerPeliculas controller_peliculas = new ControllerPeliculas(model_peliculas, view_peliculas);
     
     ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        Object views[] = new Object[3];
        views[0] = view_cliente;
        views[1] = view_peliculas;
        views[2] = view_principal;
        ControllerPrincipal controller_principal = new ControllerPrincipal(model_principal, views);

    }
}
