package control;
import java.util.ArrayList;

import modelo.Libro;

public class Logica {
	private ArrayList<Libro> libros;
	
	public Logica() {
		super();
		this.libros = new ArrayList<>();
	}
	
	
	/**
	 * para poder insertar libros de forma dinamica en un array estatico
	 * se crea un segundo array con una posicion mas que el original
	 * se copia el original al nuevo
	 * se apunta el puntero del array original al array nuevo 
	 * y se inserta el nuevo libro en la ultima posicion
	 * @param libro
	 */
	public void altaLibro(Libro libro) {
		libros.add(libro);
	}

	/**
	 * crea un array con una posicion menos que el original
	 * y hasta que llegue a la posicion del que se quiere borrar
	 * copia los libros del original al aux en la misma posicion 
	 * cuando la posicion es igual no hace nada y cuando 
	 * la poscion es mayor lo guarda en el aux pero en una posicion menos
	 * 
	 * al final se ha copiado to el array original al aux execpto el de la posicion
	 * y apuntamos el array de libros hacia el array aux
	 * 
	 * que duro es trabajar con array staticos
	 * 
	 * @param selectedIndex posicion del libro que se quiere borrar
	 */
	public void borrarLibro(int selectedIndex) {
		libros.remove(selectedIndex);
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}


	public boolean modificarLibro(Libro original,Libro modificado,int posicion) {
		boolean retorno;
		if(!original.esIgualQue(modificado)){
			libros.add(posicion, modificado);
			retorno = true;
		}
		else retorno = false;
		return retorno;
	}
}
