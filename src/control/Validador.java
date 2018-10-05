package control;
import java.util.ArrayList;

import modelo.Libro;

public class Validador {
	
	public boolean validarISBN(String ISBN,ArrayList<Libro> arrayList) {
		boolean retorno = true;
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i)!=null &&arrayList.get(i).getISBN().equals(ISBN))retorno=false;
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
