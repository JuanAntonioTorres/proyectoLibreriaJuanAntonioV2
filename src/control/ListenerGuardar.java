package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Libro;
import vista.LogicaGrafica;

public class ListenerGuardar implements ActionListener{

	private Logica logica;
	private LogicaGrafica logicaGrafica;
	
	public ListenerGuardar(Logica logica, LogicaGrafica logicaGrafica) {
		super();
		this.logica = logica;
		this.logicaGrafica = logicaGrafica;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Libro libroOriginal = obtenerLibroSeleccionado();
		sacarLibroDeLibros();
		Libro libroModificado = obtenerLibroModificado();
		
		if(!modificarLibro(libroOriginal, libroModificado)) {
			reestablecerLibroOriginal(libroOriginal);
		}
		logicaGrafica.resetearInformacion();
		logicaGrafica.pintarLista(logica.getLibros());
		logicaGrafica.cambiarListenerBoton("Alta", new ListenerBotonAlta(logica, logicaGrafica));
		logicaGrafica.restablecerTextoBotones();
	}



	private void reestablecerLibroOriginal(Libro libroOriginal) {
		logica.getLibros().add(logicaGrafica.getLibroSeleccionado(), libroOriginal);
	}



	private boolean modificarLibro(Libro original,Libro libroModificado) {
		return logica.modificarLibro(original,libroModificado,logicaGrafica.getLibroSeleccionado());
	}



	private Libro obtenerLibroModificado() {
		return logicaGrafica.crearLibro(logica.getLibros());
	}



	private void sacarLibroDeLibros() {
		logica.getLibros().remove(logicaGrafica.getLibroSeleccionado());
	}



	private Libro obtenerLibroSeleccionado() {
		return logica.getLibros().get(logicaGrafica.getLibroSeleccionado());
	}

}
