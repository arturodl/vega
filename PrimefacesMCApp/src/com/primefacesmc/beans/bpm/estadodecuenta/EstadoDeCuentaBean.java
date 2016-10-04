package com.primefacesmc.beans.bpm.estadodecuenta;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.core.app.otd.ObtenerEntidadesPorCriterioPeticion;
import com.core.app.otd.PeticionEntidad;
import com.core.app.otd.RespuestaEntidad;
import com.core.app.servicios.entidad.ServicioEntidad;
import com.model.data.app.humanresources.Department;
import com.services.facade.app.cuentasporcobrar.CuentasPorCobrar;
import com.services.facade.app.rh.Rh;

@ManagedBean(name="estadoDeCuentaBean")
@ViewScoped
public class EstadoDeCuentaBean {
    private String nombreUsuario;
    
    @ManagedProperty(value="#{cuentasPorCobrar}")
    private CuentasPorCobrar cuentasPorCobrarFacade;
    
    @ManagedProperty(value="#{rhFacade}")
    private Rh rhFacade;
        
    @PostConstruct
    public void inicializar(){
    	System.out.println("Inicializar estado de cuenta bean");
    	nombreUsuario = "Arturo Linares Rincon";
    	try{
    		PeticionEntidad peticion = new PeticionEntidad();
    		Department departamento = new Department();
    		departamento.setName("FrontEnd and BackEnd");
			departamento.setGroupName("TI");
			departamento.setModifiedDate(new Date());
			peticion.setEntidad(departamento);
    		rhFacade.crearDepartamento(peticion);
    		
    	}catch(Exception e){
    		System.out.println("Error: "+e.getCause());
    		e.printStackTrace();
    	}
    	
    }

	public CuentasPorCobrar getCuentasPorCobrarFacade() {
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
}
