package com.obj.framework;

import java.util.ResourceBundle;

/**
 * Clase para el manejo de propiedades
 * @author Jrsaavedra
 *
 */
public class UtilProperties {
	
	// Atributos
	public static UtilProperties utilProperties = null;
	public static final String FIELD_PROPERTIES = "com.obj.properties.fields";
	
	/**
	 * constructor
	 */
	private UtilProperties() {}
	
	/**
	 * singleton
	 * @return
	 */
	public static UtilProperties getInstance() {
		if(utilProperties == null)
			utilProperties = new UtilProperties();
		
		return utilProperties;
	}
	
	/**
	 * Método para obtener propiedades a partir de un archivo de propiedades
	 * @param key
	 * @param bundle
	 * @return
	 * @throws UtilException
	 */
	public String getProperty(String key, String bundle) throws UtilException{
		try {
			ResourceBundle rb = ResourceBundle.getBundle(bundle);
			return rb.getString(key);						
		}catch(Exception ex) {
			throw new UtilException("<<<<< Error al obtener la propiedad: " + key, "99999");
		}
	}
}
