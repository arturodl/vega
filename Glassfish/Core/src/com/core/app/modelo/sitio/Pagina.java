package com.core.app.modelo.sitio;

public class Pagina {
	private int idPagina;
	private String pagina;
	private String urlPagina;
	private String comentarios;
	private int idModulo;
	
	public Pagina(int idPagina, String pagina, String urlPagina, String comentarios){
		this.idPagina = idPagina;
		this.pagina = pagina;
		this.urlPagina = urlPagina;
		this.comentarios = comentarios;		
	}
	
	public Pagina (int idPagina, String pagina, String urlPagina, String comentarios, int idModulo){
		this.idPagina = idPagina;
		this.pagina = pagina;
		this.urlPagina = urlPagina;
		this.comentarios = comentarios;
		this.idModulo = idModulo;
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
	
	
}
