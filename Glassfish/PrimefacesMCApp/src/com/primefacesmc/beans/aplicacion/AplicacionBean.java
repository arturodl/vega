package com.primefacesmc.beans.aplicacion;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import com.core.app.modelo.sitio.Pagina;

@ManagedBean(name="aplicacionBean")
@SessionScoped
public class AplicacionBean {
    private int clave;
    private String usuario;
    private String password;
    private TreeNode raizArbol;
    private TreeNode nodoSeleccionado;
    private Map<String, String> pagina;
        
    @PostConstruct
    public void inicializar(){
    	System.out.println("Inicializando AplicacionBean");    	
    	this.usuario = "Arturo Linares";    	
    	
    	crearOpcionesArbolMenu();
    	
    	pagina = new HashMap<String, String>();
    	this.pagina.put("url", "/WEB-INF/web/content/pantallas/Usuario/Usuario-Inicio.xhtml");
    	System.out.println("Saliendo de inicializar bean.");
    
    }
    
    public void crearOpcionesArbolMenu(){
    	this.raizArbol = new DefaultTreeNode(new Pagina(0, "Root","Sin url","Raiz del menu"), null); 
    	
    	/** Modulos principales **/
    	TreeNode inventarios = new DefaultTreeNode(new Pagina(1,"Inventarios","Sin url","Modulo principal de inventarios"), raizArbol);
    	TreeNode compras = new DefaultTreeNode(new Pagina(2,"Compras","Sin url","Modulo principal de compras"), raizArbol);    	
    	TreeNode ventas = new DefaultTreeNode(new Pagina(3,"Ventas","Sin url","Modulo principal de ventas"), raizArbol);
    	TreeNode facturacion = new DefaultTreeNode(new Pagina(4, "Facturacion","Sin url","Modulo principal de facturacion"), raizArbol);
    	TreeNode rh = new DefaultTreeNode(new Pagina(5,"Recurso Humanos","Sin url","Modulo principal de Recursos Humanos"), raizArbol);
    	TreeNode reportes = new DefaultTreeNode(new Pagina(6,"Reportes","Sin url","Modulo principal de reportes" ), raizArbol);
    	
    	
    	TreeNode requisiciones = new DefaultTreeNode(new Pagina(7,"Requisiciones","Sin url","Submodulo de Requisiciones"), inventarios);
    	TreeNode requisicionAutomatica = new DefaultTreeNode(new Pagina(8,"Automaticas","#","Pagina de Requisiciones Automaticas"), requisiciones);
    	TreeNode requisicionManual = new DefaultTreeNode(new Pagina(9,"Manual","#","Pagina de Requisiciones Manuales"),requisiciones);
    	
    	
    	TreeNode ingresos = new DefaultTreeNode(new Pagina(10, "Ingresos","Sin url","Submodulo de Ingresos"), inventarios);
    	TreeNode ingresoAutomatico = new DefaultTreeNode(new Pagina(11,"Automatico","#","Pagina de Ingresos Automaticos"),ingresos);
    	TreeNode ingresoManual = new DefaultTreeNode(new Pagina(12,"Manual","#","Pagina de Ingresos Manuales"), ingresos);
    	
    	TreeNode proveedores = new DefaultTreeNode(new Pagina(13,"Proveedores","Sin url","Submodulo de Proveedores"), compras);
    	TreeNode proveedoresListado = new DefaultTreeNode(new Pagina(14,"Lista de Proveedores","#","Pagina de Listado de Proveedores"),proveedores);
    	TreeNode proveedoresEnvios = new DefaultTreeNode(new Pagina(14,"Envios de Proveedor","#","Pagina de Listado de Proveedores"),proveedores);
    	
    	TreeNode ventasContado = new DefaultTreeNode(new Pagina(15,"Contado","#","Pagina de Ventas de Contado"),ventas);
    	TreeNode ventasCredito = new DefaultTreeNode(new Pagina(16,"Credito","#","Pagina de Ventas a credito"),ventas);
    	TreeNode ventasClientes = new DefaultTreeNode(new Pagina(26,"Clientes","#","Pagina de Clientes"),ventas);
    	
    	TreeNode facturacionFacturaElec = new DefaultTreeNode(new Pagina(17,"Factura Electronica","#","Pagina de Facturacion Electronica"),facturacion);
    	TreeNode facturacionCDI = new DefaultTreeNode(new Pagina(18,"Generar CDI","#","Pagina de creacion de CDI"),facturacion);
    	
    	TreeNode rhPersonal = new DefaultTreeNode(new Pagina(19,"Personal","#","Pagina del Personal de la Empresa"),rh);
    	TreeNode rhIndemnizaciones = new DefaultTreeNode(new Pagina(20,"Indemnizaciones","#","Pagina de Indemnizaciones"),rh);
    	
    	TreeNode reporteTipoA = new DefaultTreeNode(new Pagina(21,"Reporte Tipo A","#","Pagina Reporte Tipo A"),reportes);
    	TreeNode reporteTipoB = new DefaultTreeNode(new Pagina(22,"Reporte Tipo B","#","Pagina Reporte Tipo B"),reportes);
    	TreeNode reporteTipoC = new DefaultTreeNode(new Pagina(23,"Reporte Tipo C","#","Pagina Reporte Tipo C"),reportes);
    	TreeNode reporteTipoD = new DefaultTreeNode(new Pagina(24,"Reporte Tipo D","#","Pagina Reporte Tipo D"),reportes);
    	TreeNode reporteTipoE = new DefaultTreeNode(new Pagina(25,"Reporte Tipo E","#","Pagina Reporte Tipo E"),reportes);
    	
    }
    
    public void seleccionandoNodo(AjaxBehaviorEvent eventoAjax){
    	System.out.println("Nodo seleccionado: "+((Pagina)nodoSeleccionado.getData()).getPagina());
    }
    
    public void actualizarContenido(AjaxBehaviorEvent eventoAjax){
    	System.out.println("Actualizando contenido, agregando nuevo enlace, boton clicleado: "+eventoAjax.getComponent().getId());
    	
    	if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkInicio") == 0)
    	  this.pagina.put("url", "/WEB-INF/web/content/pantallas/Usuario/Usuario-Inicio.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkCorreos") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/Usuario/Usuario-Correos.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkNotificaciones") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/Usuario/Usuario-Notificaciones.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkUsuario") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/Usuario/Usuario-DatosUsuario.xhtml");
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkConfiguracion") == 0)
    			this.pagina.put("url", "/WEB-INF/web/content/pantallas/Usuario/Usuario-Configuracion.xhtml"); 
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


	public TreeNode getNodoSeleccionado() {
		return nodoSeleccionado;
	}


	public void setNodoSeleccionado(TreeNode nodoSeleccionado) {		
		this.nodoSeleccionado = nodoSeleccionado;
	}
}
