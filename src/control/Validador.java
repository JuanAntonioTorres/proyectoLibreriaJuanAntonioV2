package control;
import modelo.Libro;

public class Validador {
	
	public boolean validarISBN(String ISBN,Libro libros []) {
		boolean retorno = true;
		for (int i = 0; i < libros.length; i++) {
			if(libros[i]!=null &&libros[i].getISBN().equals(ISBN))retorno=false;
		}
		return retorno;
	}
	
	public boolean validarSoloNumeros(String texto) {
		boolean retorno = true;
		for (int i = 0; i < texto.length(); i++) {
			if(!Character.isDigit(texto.charAt(i))) {
				retorno = false;
			}
		}
	return retorno;
	}

	public boolean validarLongitud(String string, int longitudNib) {
		return string.length()==longitudNib;
	}
}
