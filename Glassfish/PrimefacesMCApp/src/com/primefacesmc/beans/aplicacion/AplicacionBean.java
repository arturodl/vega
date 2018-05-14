package com.primefacesmc.beans.aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import com.core.app.modelo.sitio.Pagina;

@ManagedBean(name="aplicacionBean")
@SessionScoped
public class AplicacionBean implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int clave;
    private String usuario;
    private String password;
    private List<Pagina> listaOpcionesUsuario;
    private TreeNode raizArbol;
    private TreeNode nodoSeleccionado;
    private Pagina paginaActual;
        
    @PostConstruct
    public void inicializar(){
    	System.out.println("Inicializando AplicacionBean");    	
    	
    	this.usuario = "Arturo Linares"; 
    	
    	crearOpcionesUsuario();
    	crearOpcionesArbolMenu();    	
    	System.out.println("Saliendo de inicializar bean.");
    
    }
    
    public void seleccionandoNodo(AjaxBehaviorEvent eventoAjax){
    	Pagina paginaSeleccionada = (Pagina)nodoSeleccionado.getData();
    	System.out.println("Nodo seleccionado: "+paginaSeleccionada.getPagina());
    	if ( !paginaSeleccionada.getEsSubmodulo() ){
    		System.out.println("Bean Ultima Pagina Renderizada ( "+paginaActual.getPagina()+" ): "+paginaActual.getNombreBean());
    		
    		if(paginaActual.getNombreBean() != null){
    			FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove( paginaActual.getNombreBean() );
    			System.out.println("Eliminando Bean: "+paginaActual.getNombreBean() );
    		}else
    			System.out.println("La Pagina Renderizada no tiene Bean Asignado");
    		
        	System.out.println("Actualizando pagina actual...");
    		this.paginaActual = paginaSeleccionada;
    		
    	}   	

    	System.out.println("Pagina a renderizar, despues de verificar si es submodulo: "+this.paginaActual.getUrlPagina());
    }
    
    public void actualizarContenido(AjaxBehaviorEvent eventoAjax){
    	System.out.println("Actualizando contenido, agregando nuevo enlace, boton clicleado: "+eventoAjax.getComponent().getId());
    	
    	if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkInicio") == 0)
    	   this.paginaActual = this.listaOpcionesUsuario.get(0);
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkCorreos") == 0)
    			this.paginaActual = this.listaOpcionesUsuario.get(1);
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkNotificaciones") == 0)
    			this.paginaActual = this.listaOpcionesUsuario.get(2);
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkUsuario") == 0)
    			this.paginaActual = this.listaOpcionesUsuario.get(3);
    	else 
    		if ( eventoAjax.getComponent().getId().compareTo("headerPlantilla-linkConfiguracion") == 0)
    			this.paginaActual = this.listaOpcionesUsuario.get(4);
    }
    
    public void crearOpcionesUsuario(){
    	this.listaOpcionesUsuario = new ArrayList<Pagina>();
    	this.listaOpcionesUsuario.add(new Pagina(40,"Inicio","/WEB-INF/web/content/pantallas/Usuario/Usuario-Inicio.xhtml",null,"Pagina de Inicio"));
    	this.listaOpcionesUsuario.add(new Pagina(41,"Correos","/WEB-INF/web/content/pantallas/Usuario/Usuario-Correos.xhtml",null,"Pagina de los Correos del Usuario"));
    	this.listaOpcionesUsuario.add(new Pagina(42,"Notificaciones","/WEB-INF/web/content/pantallas/Usuario/Usuario-Notificaciones.xhtml",null,"Pagina de las Notificaciones del Usuario"));
    	this.listaOpcionesUsuario.add(new Pagina(43,"Datos Usuario","/WEB-INF/web/content/pantallas/Usuario/Usuario-DatosUsuario.xhtml",null,"Pagina de los Datos del Usuario"));
    	this.listaOpcionesUsuario.add(new Pagina(0,"Configuracion","/WEB-INF/web/content/pantallas/Usuario/Usuario-Configuracion.xhtml",null,"Pagina de la Configuracion del Sistema"));
    	paginaActual = this.listaOpcionesUsuario.get(0);
    }
    
    public void crearOpcionesArbolMenu(){
    	this.raizArbol = new DefaultTreeNode(new Pagina(0, "Root","Sin url",null,"Raiz del menu"), null); 
    	
    	/** Modulos principales **/
    	TreeNode inventarios = new DefaultTreeNode(new Pagina(1,"Inventarios",null,null,"Modulo principal de inventarios"), raizArbol);
    	TreeNode compras = new DefaultTreeNode(new Pagina(2,"Compras",null,null,"Modulo principal de compras"), raizArbol);    	
    	TreeNode ventas = new DefaultTreeNode(new Pagina(3,"Ventas",null,null,"Modulo principal de ventas"), raizArbol);
    	TreeNode facturacion = new DefaultTreeNode(new Pagina(4, "Facturacion",null,null,"Modulo principal de facturacion"), raizArbol);
    	TreeNode rh = new DefaultTreeNode(new Pagina(5,"Recurso Humanos",null,null,"Modulo principal de Recursos Humanos"), raizArbol);
    	TreeNode reportes = new DefaultTreeNode(new Pagina(6,"Reportes",null,null,"Modulo principal de reportes" ), raizArbol);
    	
    	
    	TreeNode requisiciones = new DefaultTreeNode(new Pagina(7,"Requisiciones",null,null,"Submodulo de Requisiciones"), inventarios);
    	TreeNode requisicionAutomatica = new DefaultTreeNode(new Pagina(8,"Automaticas","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina de Requisiciones Automaticas"), requisiciones);
    	TreeNode requisicionManual = new DefaultTreeNode(new Pagina(9,"Manual","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina de Requisiciones Manuales"),requisiciones);
    	
    	
    	TreeNode ingresos = new DefaultTreeNode(new Pagina(10, "Ingresos",null,null,"Submodulo de Ingresos"), inventarios);
    	TreeNode ingresoAutomatico = new DefaultTreeNode(new Pagina(11,"Automatico","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina de Ingresos Automaticos"),ingresos);
    	TreeNode ingresoManual = new DefaultTreeNode(new Pagina(12,"Manual","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina de Ingresos Manuales"), ingresos);
    	
    	TreeNode proveedores = new DefaultTreeNode(new Pagina(13,"Proveedores",null,null,"Submodulo de Proveedores"), compras);
    	TreeNode proveedoresListado = new DefaultTreeNode(new Pagina(14,"Envios de Proveedor","/WEB-INF/web/content/pantallas/Compras/Compras-EnviosDeProveedor.xhtml","enviosDeProveedorBean","Pagina de Listado de Proveedores"),proveedores);
    	TreeNode proveedoresEnvios = new DefaultTreeNode(new Pagina(14,"Listado de Proveedor","/WEB-INF/web/content/pantallas/Compras/Compras-CatalogoProveedores.xhtml","catalogoProveedoresBean","Pagina de Listado de Proveedores"),proveedores);
    	
    	TreeNode ventasContado = new DefaultTreeNode(new Pagina(15,"Contado","/WEB-INF/web/content/pantallas/Ventas/Ventas-AlContado.xhtml",null,"Pagina de Ventas de Contado"),ventas);
    	TreeNode ventasCredito = new DefaultTreeNode(new Pagina(16,"Credito","/WEB-INF/web/content/pantallas/Ventas/Ventas-ACredito.xhtml",null,"Pagina de Ventas a credito"),ventas);
    	TreeNode ventasClientes = new DefaultTreeNode(new Pagina(26,"Clientes","/WEB-INF/web/content/pantallas/Ventas/Ventas-ListadoClientes.xhtml",null,"Pagina de Clientes"),ventas);
    	
    	TreeNode facturacionFacturaElec = new DefaultTreeNode(new Pagina(17,"Factura Electronica","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina de Facturacion Electronica"),facturacion);
    	TreeNode facturacionCDI = new DefaultTreeNode(new Pagina(18,"Generar CDI","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina de creacion de CDI"),facturacion);
    	
    	TreeNode rhPersonal = new DefaultTreeNode(new Pagina(19,"Personal","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina del Personal de la Empresa"),rh);
    	TreeNode rhIndemnizaciones = new DefaultTreeNode(new Pagina(20,"Indemnizaciones","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina de Indemnizaciones"),rh);
    	
    	TreeNode reporteTipoA = new DefaultTreeNode(new Pagina(21,"Reporte Tipo A","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina Reporte Tipo A"),reportes);
    	TreeNode reporteTipoB = new DefaultTreeNode(new Pagina(22,"Reporte Tipo B","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina Reporte Tipo B"),reportes);
    	TreeNode reporteTipoC = new DefaultTreeNode(new Pagina(23,"Reporte Tipo C","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina Reporte Tipo C"),reportes);
    	TreeNode reporteTipoD = new DefaultTreeNode(new Pagina(24,"Reporte Tipo D","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina Reporte Tipo D"),reportes);
    	TreeNode reporteTipoE = new DefaultTreeNode(new Pagina(25,"Reporte Tipo E","/WEB-INF/web/content/pantallas/Aplicacion/PaginaEnConstruccion.xhtml",null,"Pagina Reporte Tipo E"),reportes);
    	
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

	public Pagina getPaginaActual() {
		return paginaActual;
	}

	public void setPaginaActual(Pagina paginaActual) {
		this.paginaActual = paginaActual;
	}


	public TreeNode getNodoSeleccionado() {
		return nodoSeleccionado;
	}


	public void setNodoSeleccionado(TreeNode nodoSeleccionado) {		
		this.nodoSeleccionado = nodoSeleccionado;
	}
}
