package modelo;
import java.util.Arrays;

public class Libro {
	
	//Propiedades
	private String titulo;
	private String autor;
	private String tema;
	private int numPaginas;
	private String isbn;
	private String[] formato=new String[3];
	private String estado;

	
	public Libro(String titulo, String autor, String tema, int numPaginas,
			String[] formato, String estado, String nib) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.tema = tema;
		this.numPaginas = numPaginas;
		this.formato = formato;
		this.estado = estado;
		this.isbn = nib;
	}

	public boolean esIgualQue(Libro libro) {
		if(this.autor.equals(libro.getAutor()))return false;
		if(this.estado.equals(libro.getEstado()))return false;
		if(Arrays.equals(this.formato,libro.getFormato()))return false;
		if(this.numPaginas==libro.getNumPaginas())return false;
		if(this.tema.equals(libro.getTema()))return false;
		if(this.titulo.equals(libro.getTitulo()))return false;
		return true;
	}
	
	//GETTERS
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getTema() {
		return tema;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public String[] getFormato() {
		return formato;
	}
	public String getEstado() {
		return estado;
	}
	public String getISBN() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
