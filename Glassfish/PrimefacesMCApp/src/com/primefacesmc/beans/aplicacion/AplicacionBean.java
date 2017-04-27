package com.primefacesmc.beans.aplicacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name="aplicacionBean")
@ViewScoped
public class AplicacionBean {
    private int clave;
    private String usuario;
    private String password;
    private TreeNode raizArbol;
    
    @PostConstruct
    public void inicializar(){
    	this.raizArbol = new DefaultTreeNode("Root", null); 
    	
    	TreeNode inventarios = new DefaultTreeNode(" - Inventarios", raizArbol);
    	TreeNode compras = new DefaultTreeNode(" - Compras", raizArbol);    	
    	TreeNode ventas = new DefaultTreeNode(" - Ventas", raizArbol);
    	TreeNode facturacion = new DefaultTreeNode(" - Facturacion", raizArbol);
    	TreeNode rh = new DefaultTreeNode(" - Recursos Humanos", raizArbol);
    	TreeNode reportes = new DefaultTreeNode(" - Reportes", raizArbol);
    	
    	TreeNode requisiciones = new DefaultTreeNode(" - Requisiciones", inventarios);
    	requisiciones.getChildren().add(new DefaultTreeNode("Automaticas"));
    	requisiciones.getChildren().add(new DefaultTreeNode("Manuales"));
    	
    	TreeNode ingresos = new DefaultTreeNode(" - Ingresos", inventarios);
    	ingresos.getChildren().add(new DefaultTreeNode("Automaticos"));
    	ingresos.getChildren().add(new DefaultTreeNode("Manuales"));
    	
    	TreeNode proveedores = new DefaultTreeNode(" - Proveedores", compras);
    	proveedores.getChildren().add(new DefaultTreeNode("Lista"));

    	ventas.getChildren().add(new DefaultTreeNode("De contado"));
    	ventas.getChildren().add(new DefaultTreeNode("A Credito"));
    	
    	facturacion.getChildren().add(new DefaultTreeNode("Factura Electronica"));
    	facturacion.getChildren().add(new DefaultTreeNode("Generar CDI"));
    	
    	rh.getChildren().add(new DefaultTreeNode("Personal"));
    	rh.getChildren().add(new DefaultTreeNode("Indemnizaciones"));
    	
    	reportes.getChildren().add(new DefaultTreeNode("Reporte Tipo A"));
    	reportes.getChildren().add(new DefaultTreeNode("Reporte Tipo B"));
    	reportes.getChildren().add(new DefaultTreeNode("Reporte Tipo C"));
    	reportes.getChildren().add(new DefaultTreeNode("Reporte Tipo D"));
    	reportes.getChildren().add(new DefaultTreeNode("Reporte Tipo E"));
    }

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TreeNode getRaizArbol() {
		return raizArbol;
	}

	public void setRaizArbol(TreeNode raizArbol) {
		this.raizArbol = raizArbol;
	}
}
