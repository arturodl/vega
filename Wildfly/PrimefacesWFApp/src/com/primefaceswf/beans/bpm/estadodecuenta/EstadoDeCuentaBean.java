package com.primefaceswf.beans.bpm.estadodecuenta;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="estadoDeCuentaBean")
@ViewScoped
public class EstadoDeCuentaBean {
    private String nombreUsuario;
    
    /* @ManagedProperty(value="#{cuentasPorCobrar}")
	    private CuentasPorCobrar cuentasPorCobrarFacade;
	    
	    @ManagedProperty(value="#{rhFacade}")
	    private Rh rhFacade;
    */	        
    @PostConstruct
    public void inicializar(){
    	System.out.println("Inicializar estado de cuenta bean");
    	nombreUsuario = "Arturo Linares Rincón";
/*    	try{
    		CrearDepartamentoPeticion peticion = new CrearDepartamentoPeticion();
    		Department departamento = new Department();
    		departamento.setName("FrontEnd and BackEnd");
			departamento.setGroupName("TI");
			departamento.setModifiedDate(new Date());
			peticion.setEntidad(departamento);
    		rhFacade.crearDepartamento(peticion);
    		
    	}catch(Exception e){
    		System.out.println("Error: "+e.getCause());
    		e.printStackTrace();
    	} */
    	
    }

	/* public CuentasPorCobrar getCuentasPorCobrarFacade() {
		return cuentasPorCobrarFacade;
	}

	public void setCuentasPorCobrarFacade(CuentasPorCobrar cuentasPorCobrarFacade) {
		this.cuentasPorCobrarFacade = cuentasPorCobrarFacade;
	}
	
	public Rh getRhFacade() {
		return rhFacade;
	}

	public void setRhFacade(Rh rhFacade) {
		this.rhFacade = rhFacade;
	}
    */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
