package com.core.app.servicios;

public interface ServicioPeticionRespuesta <P,R>{	
	R ejecutar(P peticion);
}
