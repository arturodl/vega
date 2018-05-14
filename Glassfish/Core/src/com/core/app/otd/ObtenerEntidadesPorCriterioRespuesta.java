package com.core.app.otd;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class ObtenerEntidadesPorCriterioRespuesta {
	
	private List listaEntidades;
	
	private String mensajeResultadoObtencion;

	public List getListaEntidades() {
		return listaEntidades;
	}

	public void setListaEntidades(List listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

	public String getMensajeResultadoObtencion() {
		return mensajeResultadoObtencion;
	}

	public void setMensajeResultadoObtencion(String mensajeResultadoObtencion) {
		this.mensajeResultadoObtencion = mensajeResultadoObtencion;
	}

}
