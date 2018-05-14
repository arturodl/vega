package com.obj.transf.datos.app.rh;

public class Vector {
	
	/**
	 * Indica la posicion desde donde quieres empezar a sumar
	 * @param vector
	 * @param pos
	 * @return
	 */
	public int suma(int[] vector, int pos){
		if( pos == ( vector.length - 1 ))
			return vector[pos];
		
		return vector[pos] + suma(vector, (pos+1) ); 
	}
	
	/**
	 * Este metodo evalua a partir de la posicion que se indica con el parametro pos
	 * @param vector1
	 * @param vector2
	 * @param pos
	 * @param evalfirstTime
	 * @return
	 */
	public boolean sonIguales(int[] vector1, int[] vector2, int pos, boolean evalfirstTime){		
		if( evalfirstTime && (vector1.length != vector2.length) )
			return false;		
		
		if( pos <= (vector1.length -1 )) {	
			System.out.println("Vector1: "+vector1[pos]+", vector2: "+vector2[pos]);
			if( vector1[pos] != vector2[pos])
				return false;
		}else
			return true;
		
		return sonIguales(vector1, vector2, (pos+1), false );
	}
	
	public static void main (String [] args){
		Vector vector = new Vector();
		int[] arreglo = {1,2,3,4,5,6,7,8};	
		
	    //System.out.println("La suma es: "+vector.suma(arreglo, 0) );
	    
	    int[] arregloA = {1,2,3,3,3,6,7};
	    int[] arregloB = {1,2,3,4,5,6,7};
	    
	    System.out.println("Los vectores "+ (vector.sonIguales(arregloA, arregloB, 0, true)? "son iguales":" no son iguales" ) );
	}

}

