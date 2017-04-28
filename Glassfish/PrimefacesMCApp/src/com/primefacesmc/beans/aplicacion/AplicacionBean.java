package com.primefacesmc.beans.aplicacion;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
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
    private Map<String, String> pagina;
    
    @PostConstruct
    public void inicializar(){
    	this.raizArbol = new DefaultTreeNode("Root", null); 
    	
    	TreeNode inventarios = new DefaultTreeNode("Inventarios", raizArbol);
    	TreeNode compras = new DefaultTreeNode("Compras", raizArbol);    	
    	TreeNode ventas = new DefaultTreeNode("Ventas", raizArbol);
    	TreeNode facturacion = new DefaultTreeNode("Facturacion", raizArbol);
    	TreeNode rh = new DefaultTreeNode("Recursos Humanos", raizArbol);
    	TreeNode reportes = new DefaultTreeNode("Reportes", raizArbol);
    	
    	TreeNode requisiciones = new DefaultTreeNode("Requisiciones", inventarios);
    	requisiciones.getChildren().add(new DefaultTreeNode("Automaticas"));
    	requisiciones.getChildren().add(new DefaultTreeNode("Manuales"));
    	
    	TreeNode ingresos = new DefaultTreeNode("Ingresos", inventarios);
    	ingresos.getChildren().add(new DefaultTreeNode("Automaticos"));
    	ingresos.getChildren().add(new DefaultTreeNode("Manuales"));
    	
    	TreeNode proveedores = new DefaultTreeNode("Proveedores", compras);
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
    	
    	this.usuario = "Arturo Linares";
    	
    	pagina = new HashMap<String, String>();
    	this.pagina.put("url", "/WEB-INF/web/content/pantallas/usuario/Usuario-Inicio.xhtml");
    }
    
    
    public void actualizarContenido(AjaxBehaviorEvent eventoAjax){
    	System.out.println("Actualizando contenido, agregando nuevo enlace, boton clicleado: "+eventoAjax.getComponent().getId());
    	
    	if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkInicio") == 0)
    	  this.pagina.put("url", "/WEB-INF/web/content/pantallas/usuario/Usuario-Inicio.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkCorreos") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/usuario/Usuario-Correos.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkNotificaciones") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/usuario/Usuario-Notificaciones.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkUsuario") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/usuario/Usuario-DatosUsuario.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkConfiguracion") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/usuario/Usuario-Configuracion.xhtml");
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

	public Map<String, String> getPagina() {
		return pagina;
	}

	public void setPagina(Map<String, String> pagina) {
		this.pagina = pagina;
	}
}
