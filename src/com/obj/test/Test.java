package com.obj.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.obj.domain.Author;
import com.obj.domain.Book;
import com.obj.domain.Category;
import com.obj.domain.Country;
import com.obj.domain.Editorial;
import com.obj.dto.AuthorDTO;
import com.obj.dto.BookDTO;
import com.obj.dto.CountryDTO;
import com.obj.framework.DataMemoryApp;
import com.obj.framework.UtilException;
import com.obj.framework.UtilFieldValidation;
import com.obj.framework.UtilMapper;
import com.obj.framework.UtilProperties;

/**
 * Clase de validación de DTO's
 * @author Jrsaavedra
 *
 */
public class Test {
	
	/**
	 * Main RUN
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			loadDataInMemory();
			// Proceso de Mapeo de entidades a DTO
			mapperValidationEntityToDto();
			System.out.println("");
			System.out.println("");
			System.out.println("");
			// Proceso de validación de campos DTO
			getValidationInputAuthor();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	/**
	 * Método para en mapeo de una entidad a un DTO
	 * @throws UtilException
	 */
	private static void mapperValidationEntityToDto() throws UtilException {
		System.out.println("++++++++++++++ In Proceso de conversión de Entity a DTO ++++++++++++++");
		// Obtener datos de la entidad
		Book entity_w = getDatabaseEntityBookSimulate();
		System.out.println("<<<<< Info ENTITY: ");
		System.out.println("     " + entity_w);
		System.out.println("");
		
		// Hacer el mapeo de la entidad a un objeto DTO
		Object finalDto_w = UtilMapper.getInstance().mapperDTOfromEntity(entity_w, "BookDTO");
		BookDTO dto_w = (BookDTO) finalDto_w;
		System.out.println("<<<<< Info DTO: ");
		System.out.println("     " + dto_w);
		System.out.println("++++++++++++++ OUT Proceso de conversión de Entity a DTO ++++++++++++++");
	}
	
	/**
	 * Método para la validación de los campos de entrada de un DTO
	 * @throws UtilException
	 */
	private static void getValidationInputAuthor() throws UtilException {
		System.out.println("++++++++++++++ In Proceso de validación de campos DTO ++++++++++++++");
		AuthorDTO dto = getAuthorDTOSimulate();
		
		List<Object> errors = UtilFieldValidation.getInstance().inputFieldValidation(dto, "AuthorDTO");
		System.out.println("<<<<< Cantidad de Errores: " + errors.size());
		for(Object error : errors) {
			System.out.println("	" + error);
		}
		
		System.out.println("++++++++++++++ OUT Proceso de validación de campos DTO ++++++++++++++");
	}
	
	
	/**
	 * Método para similar la Entidad Book con Data
	 * @return
	 */
	private static Book getDatabaseEntityBookSimulate() {
		Book entity = new Book();
		entity.setId(1);
		entity.setCode(UUID.fromString("cc94eb82-4fc3-4abe-92c0-4003a249ec34"));
		entity.setTitle("La vida secreta de la mente");
		entity.setAuthorId(1);
		entity.setEditorialId(1);
		entity.setDescription("es un libro científico de Mariano Sigman, que nos permite indagar un poco más sobre el funcionamiento de nuestro cerebro.  ¿Cómo piensan y se comunican los bebés?   a las personas en las que confiamos? ¿Nace la conciencia en el cerebro? ¿Cómo nos gobierna el inconsciente? ¿Qué le ocurre al cerebro mientras dormimos? ¿Cómo somos capaces de seguir aprendiendo? ¿Hasta cuándo dura la plasticidad cerebral que nos permite ciertas adaptaciones? Todas estas preguntas, que alguna vez en tu vida te habrás realizado, obtendrán definitivamente su respuesta.");
		entity.setEditionNumber(0);
		entity.setCategoryId(1);
		entity.setPrice(7.99);
		entity.setStock(10);
		entity.setState(true);
		entity.setPicture(null);
		
		Country country = new Country();
		country.setId(32);
		country.setCountry("Argentina");
		
		Country country_1 = new Country();
		country_1.setId(170);
		country_1.setCountry("Colombia");
		
		Category category = new Category();
		category.setId(1);
		category.setName("Científicos");
		
		Author author = new Author();
		author.setId(1);
		author.setName("Mariano Sigman");
		author.setCountryId(32);
		author.setCountry(country);
		
		Editorial editorial = new Editorial();
		editorial.setId(1);
		editorial.setName("Temis");
		editorial.setCountryId(170);
		editorial.setCountry(country_1);
		
		entity.setAuthor(author);
		entity.setCategory(category);
		entity.setEditorial(editorial);		
		
		return entity;
	}
	
	/**
	 * Método para simular el DTO Author con Data que llega de un consumo REST
	 * @return
	 */
	private static AuthorDTO getAuthorDTOSimulate() {
		CountryDTO country = new CountryDTO();
		country.setId(32);
		country.setCountry("Argentina");
		
		AuthorDTO author = new AuthorDTO();
		author.setId(1);
		author.setName("");
//		author.setCountryId(32);
		author.setCountry(country);
		
		return author;
	}
	
	private static void loadDataInMemory() {
		try {
			String dtos = UtilProperties.getInstance().getProperty("list.dtoNames", UtilProperties.FIELD_PROPERTIES).trim();	
			String dtoNames[] = dtos.split(";");
			
			Map<String, List<Map<String, String>>> infoDtos = new HashMap<>();
			Map<String, String> classDtos_w = new HashMap<>();
			
			for (String dtoName: dtoNames){
				List<Map<String, String>> infoDto = getListFieldByDTO(dtoName);
				
				classDtos_w.put(dtoName, getClassByDto(dtoName));
				infoDtos.put(dtoName, infoDto);
			}
			
			System.out.println("++++++++++++++ Info Dto's ++++++++++++++");
			System.out.println(classDtos_w);
			System.out.println(infoDtos);
			System.out.println("");
			
			DataMemoryApp.getInstance().setClassDtos(classDtos_w);
			DataMemoryApp.getInstance().setDtos(infoDtos);
		}catch(UtilException ex) {
			ex.printStackTrace();
			System.out.println("<<<<<<<<<<<<<<<<<< Error al cargar datos en Memoria");
		}
	}
	
	/**
	 * Método para obtener clase por dtoName
	 * @param dtoName
	 * @return
	 * @throws UtilException
	 */
	private static String getClassByDto(String dtoName) throws UtilException {
		try {
			return UtilProperties.getInstance().getProperty("class." + dtoName, UtilProperties.FIELD_PROPERTIES).trim();
		}catch(Exception ex) {
			throw new UtilException("<<<<< Error al obtener la clase del DTO: " + dtoName, "99999");
		}
	}
	
	/**
	 * Método para obtener el listado de campos DTO, a partir de un archivo de propiedades
	 * @param dto_w
	 * @return
	 * @throws UtilException
	 */
	private static List<Map<String, String>> getListFieldByDTO(String dto_w) throws UtilException {
		try {
			List<Map<String, String>> list_w = new ArrayList<>();
			
			int dtoLong = Integer.parseInt(
					UtilProperties.getInstance().getProperty("field." + dto_w + ".long", UtilProperties.FIELD_PROPERTIES).trim()
			);
			
			
			for(int i = 1; i < (dtoLong+1); i++) {
				String info = UtilProperties.getInstance().getProperty("field." + dto_w + "."+ i +".info", UtilProperties.FIELD_PROPERTIES).trim();
				String infoField [] = info.split(";");
				
				String className = UtilProperties.getInstance().getProperty("class." + dto_w, UtilProperties.FIELD_PROPERTIES).trim();
				
				Map<String, String> mapInfo = new HashMap<>();
				mapInfo.put("dtoName", dto_w);
				mapInfo.put("dtoClassName", className);
				mapInfo.put("dtoField", getStringByIndex(infoField, 0));
				mapInfo.put("dtoIsRequired", getStringByIndex(infoField, 1));
				mapInfo.put("dtoIsObject", getStringByIndex(infoField, 2));
				mapInfo.put("dtoDatatype", getStringByIndex(infoField, 3));
				mapInfo.put("entityField", getStringByIndex(infoField, 4));
				mapInfo.put("isMapper", getStringByIndex(infoField, 5));
				
				list_w.add(mapInfo);
			}
			
			return list_w;
		}catch(Exception ex) {
			throw new UtilException("<<<<< Error al obtener el listado de campos DTO: " + dto_w, "99999");
		}
	}
	
	/**
	 * Método para devolver un string a partir de una posición de un Array de String[]
	 * @param str []
	 * @param i
	 * @return
	 */
	private static String getStringByIndex(String str[], int i) {
		try {
			return str[i];
		}catch (ArrayIndexOutOfBoundsException ex) {
			return null;
		}
	}
	
	/**
	 * Método para guardart datos en Memoria
	 */
//	private void loadDataInMemory(){
//		try{
//			logger.info("<<<<<<<<<<<<<<<<<<< Inicia proceso de cargar datos en Memoria");
//
//			List<Dto> dtoNames = confDtoService.getDistinctDtoNames();
//			Map<String, List<Map<String, String>>> infoDtos = new HashMap<>();
//			Map<String, String> classDtos_w = new HashMap<>();
//
//			for (Dto dto: dtoNames){
//				List<Map<String, String>> infoDto = new ArrayList<>();
//
//				// Obtener campos del DTO
//				List<Dto> confDtos = confDtoService.getLisByDtoName(dto.getDtoName());
//				for(Dto confDto: confDtos){
//					Map<String, String> fieldDto = new HashMap<>();
//					fieldDto.put("dtoName", confDto.getDtoName());
//					fieldDto.put("dtoClassName", confDto.getDtoClasName());
//					fieldDto.put("dtoField", confDto.getDtoField());
//					fieldDto.put("dtoIsRequired", isTrue(confDto.getDtoIsRequired()));
//					fieldDto.put("dtoIsObject", isTrue(confDto.getDtoIsObject()));
//					fieldDto.put("dtoDatatype", confDto.getDtoDatatype());
//					fieldDto.put("entityField", confDto.getEntityField());
//					fieldDto.put("isMapper", isTrue(confDto.getIsMapper()));
//
//					infoDto.add(fieldDto);
//				}
//
//				// Almacenar mapa de datos
//				infoDtos.put(dto.getDtoName(), infoDto);
//				classDtos_w.put(dto.getDtoName(), dto.getDtoClasName());
//			}
//
//			// Guardar datos en Memoria
//			DataMemoryApp.getInstance().setDtos(infoDtos);
//			DataMemoryApp.getInstance().setClassDtos(classDtos_w);
//
//			logger.info("<<<<<<<<<<<<<<<<<<< Finaliza proceso de cargar datos en Memoria");
//		}catch(UtilException ex){
//			logger.error(ex.getMessage());
//		}
//	}

	/**
	 * Método para devolver S/N de acuerdo a un valor Booleano
	 * @param is
	 * @return
	 */
//	private String isTrue(Boolean is){
//		if(is == null)
//			return null;
//
//		if (is.equals(true))
//			return "S";
//
//		return "N";
//	}

}
