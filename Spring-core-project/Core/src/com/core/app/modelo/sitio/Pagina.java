package com.core.app.modelo.sitio;

public class Pagina {
	private int idPagina;
	private String pagina;
	private String urlPagina;
	private String nombreBean;
	private String comentarios;
	private int idModulo;
	private boolean esSubmodulo;
	
	public Pagina(int idPagina, String pagina, String urlPagina, String nombreBean, String comentarios){
		this.idPagina = idPagina;
		this.pagina = pagina;
		this.urlPagina = urlPagina;
		this.nombreBean = nombreBean;
		this.comentarios = comentarios;		
		this.esSubmodulo = urlPagina == null;
	}
	
	public Pagina (int idPagina, String pagina, String urlPagina, String nombreBean, String comentarios, int idModulo){
		this.idPagina = idPagina;
		this.pagina = pagina;
		this.urlPagina = urlPagina;
		this.nombreBean = nombreBean;
		this.comentarios = comentarios;
		this.idModulo = idModulo;
		this.esSubmodulo = urlPagina == null;
	}
	
	public int getIdPagina() {
		return idPagina;
	}
	public void setIdPagina(int idPagina) {
		this.idPagina = idPagina;
	}
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
	}
	public String getUrlPagina() {
		return urlPagina;
	}
	public void setUrlPagina(String urlPagina) {
		this.urlPagina = urlPagina;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public int getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}

	public boolean getEsSubmodulo() {
		return esSubmodulo;
	}

	public void setEsSubmodulo(boolean esSubmodulo) {
		this.esSubmodulo = esSubmodulo;
	}

	public String getNombreBean() {
		return nombreBean;
	}

	public void setNombreBean(String nombreBean) {
		this.nombreBean = nombreBean;
	}
	
	
}
