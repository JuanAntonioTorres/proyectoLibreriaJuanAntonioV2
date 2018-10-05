package vista;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.Validador;
import modelo.Libro;

public class LogicaGrafica{
	private static final int LONGITUD_ISBN = 13;
	private static final Color COLOR_ERROR = new Color(255, 240, 245);
	private Puente vistaPrincipal;
	private Validador validador = new Validador();

	public LogicaGrafica(Puente vistaPrincipal) {
		super();
		this.vistaPrincipal = vistaPrincipal;
	}
	
	/**
	 * muestra los datos de un libro en los mismos campos
	 * donde se introducen esos datos con los controles desactivados
	 * @param libro el libro que queremos detallar en pantalla
	 */
	public void pintarLibro(Libro libro) {
		pintarDatos(libro);
		rellenarPanelEstado(libro);
		rellenarPanelFormato(libro);
	}

	/**
	 * limpia el contenido de la lista y lo rellena con 
	 * el titulo del array de libros pasado por parametro
	 * @param libros array de libros que queremos mostrar en la lista
	 */
	
	public void pintarLista(Libro [] libros ) {
		vistaPrincipal.librosDisponibles.removeAll();
		DefaultListModel<String>modeloLista=new DefaultListModel<>();
		for (int i = 0; i < libros.length; i++) {
			modeloLista.addElement(libros[i].getTitulo());
		}
		vistaPrincipal.librosDisponibles.setModel(modeloLista);
	}
	
	/**
	 * crea un libro nuevo usando los datos introducidos los 
	 * los datos han sido validados antes de activar el boton alta
	 * que llama a este metodo
	 * @param modificando 
	 * @return libro si ISBN bien// null si ISBN mal
	 */
	public Libro crearLibro(Libro [] libros) {
		PanelDatos panelDatos = vistaPrincipal.panelDatos;
		String titulo = panelDatos .getTxtTitulo().getText();
		String autor = panelDatos.getTxtAutor().getText();
		String tema = (String) panelDatos.getCmbTemas().getSelectedItem();
		int numPaginas = Integer.parseInt(panelDatos.getTxtNumPaginas().getText());
		String[] formato = obtenerFormatos();
		String estado = obtenerEstados();
		String isbn = panelDatos.getTxtISBN().getText();
		if(validador.validarISBN(isbn,libros)) {
			return new Libro(titulo, autor, tema, numPaginas, formato, estado , isbn);
		}
		else return null;
	}
	
	/**
	 * resetea todos los campos del formulario
	 */
	public void resetearInformacion() {
		restablecerTextoBotones();
		resetearPanelDatos();
		ponerTodoPanelEstadoAFalse();
		ponerTodoPanelFormatoAFalse();
		activarPanelesInformacion(true);
		activarBoton("Alta", false);
	}
	
	/**
	 * activa o desactiva el boton con el name enviado
	 * @param nombreBoton getName() del boton objetivo
	 * @param activar activar/true  desactivar/false
	 */
	public void activarBoton(String nombreBoton, boolean activar) {
		for (int i = 0; i < vistaPrincipal.panelBotones .getComponentCount(); i++) {
			if(((JButton)vistaPrincipal.panelBotones.getComponent(i)).getName().equals(nombreBoton)){
				((JButton)vistaPrincipal.panelBotones.getComponent(i)).setEnabled(activar);
			}
		}
	}
	
	/**
	 * comprueba que los datos del formulario son correctos
	 * y que no hay opciones sin seleccionar y ningun campo 
	 * de texto esta vacio
	 * @return
	 */
	public boolean comprobarTodos() {
		return validaDatos()&&
				comprobarCajasVacias()&&
				comprobarTextosVacios();
	}
	
	/**
	 * activa o desctiva los paneles de la vista principal
	 * @param activar activar/true   desactivar/false
	 */
	public void activarPanelesInformacion(boolean activar) {
		activarPanelTodos(activar,vistaPrincipal.panelChecks.getPanelEstado());
		activarPanelTodos(activar,vistaPrincipal.panelChecks.getPanelFormato());
		activarPanelTodos(activar,vistaPrincipal.panelDatos);
	}


	/**
	 * muestra un mensaje en el texto del boton alta
	 * @param string mensaje para mostrar en el boton
	 */
	public void mostrarMensaje(String string) {
		vistaPrincipal.panelBotones.getBtnAlta().setText(string);
		vistaPrincipal.panelBotones.getBtnAlta().setEnabled(false);
	}

	/**
	 * restablece el texto de los botones que hay en panel botones 
	 * mostrando el texto original guardado en el getName() de cada boton 
	 */
	public void restablecerTextoBotones() {
		for (int i = 0; i < vistaPrincipal.panelBotones.getComponentCount(); i++) {
			((JButton)vistaPrincipal.panelBotones.getComponent(i)).setText(((JButton)vistaPrincipal.panelBotones.getComponent(i)).getName());
		}
	}
	
	
	//metodos privados
	
	private void resetearPanelDatos() {
		for (int i = 0; i < vistaPrincipal.panelDatos.getComponentCount(); i++) {
			if(vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JComboBox.class)) {
				((JComboBox<?>)vistaPrincipal.panelDatos.getComponent(i)).setSelectedIndex(0);
			}
			else if(vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JTextField.class) )((JTextField)vistaPrincipal.panelDatos.getComponent(i)).setText("");
		}
		
	}
	
	private void pintarDatos(Libro libro) {
		vistaPrincipal.panelDatos.getTxtTitulo().setText(libro.getTitulo());
		vistaPrincipal.panelDatos.getTxtAutor().setText(libro.getAutor());
		pintarComboBox(libro);
		vistaPrincipal.panelDatos.getTxtNumPaginas().setText(String.valueOf(libro.getNumPaginas()));
		vistaPrincipal.panelDatos.getTxtISBN().setText(String.valueOf(libro.getISBN()));
	}

	private void pintarComboBox(Libro libro) {
		for (int i = 0; i < vistaPrincipal.panelDatos.getCmbTemas().getModel().getSize(); i++) {
			if(libro.getTema().equals(String.valueOf(vistaPrincipal.panelDatos.getCmbTemas().getModel().getElementAt(i)))) {
				vistaPrincipal.panelDatos.getCmbTemas().setSelectedItem(vistaPrincipal.panelDatos.getCmbTemas().getItemAt(i));
			}
		}
	}
	
	private void rellenarPanelEstado(Libro libro) {
		ponerTodoPanelEstadoAFalse();
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelEstado().getComponentCount(); i++) {
			if(libro.getEstado().equals(((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).getText())) {
				((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).setSelected(true);
			}
		}
	}
	
	private void ponerTodoPanelEstadoAFalse() {
		vistaPrincipal.panelChecks.getBotonGrupo().clearSelection();
	}

	private void rellenarPanelFormato(Libro libro) {
		ponerTodoPanelFormatoAFalse();
		for (int i = 0; i < libro.getFormato().length; i++) {
			for (int j = 0; j < vistaPrincipal.panelChecks.getPanelFormato().getComponentCount(); j++) {
				if(libro.getFormato()[i].equals(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(j)).getText())) {
					((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(j)).setSelected(true);
				}
			}
		}
	}

	private void ponerTodoPanelFormatoAFalse() {
		for (int j = 0; j < vistaPrincipal.panelChecks.getPanelFormato().getComponentCount(); j++) {
			((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(j)).setSelected(false);
		}
	}
	
	private String obtenerEstados() {
		String estado = null;
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelEstado().getComponentCount(); i++) {
			if(((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).isSelected()){
				estado = ((JRadioButton)vistaPrincipal.panelChecks.getPanelEstado().getComponent(i)).getText();
			}
		}
		return estado;
	}

	private String[] obtenerFormatos() {
		String[] formatos = new String[sacarTamanoCadenaFormato()];
		int posicion = 0;
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelFormato().getComponentCount(); i++) {
			if(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(i)).isSelected()){
				formatos[posicion] = String.valueOf(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(i)).getText());
				posicion++;
			}
		}
		return formatos;
	}
	
	private int sacarTamanoCadenaFormato() {
		int retorno = 0;
		for (int i = 0; i < vistaPrincipal.panelChecks.getPanelFormato().getComponentCount(); i++) {
			if(((JCheckBox)vistaPrincipal.panelChecks.getPanelFormato().getComponent(i)).isSelected())retorno++;
		}
		return retorno;
	}

	private boolean comprobarTextosVacios() {
		for (int i = 0; i < vistaPrincipal.panelDatos.getComponentCount(); i++) {
			if(vistaPrincipal.panelDatos.getComponent(i).getClass().equals(JTextField.class)
					&& ((JTextField)vistaPrincipal.panelDatos.getComponent(i)).getText().isEmpty()) {
				return false;
			}
		}
		if(vistaPrincipal.panelDatos.getCmbTemas().getSelectedIndex()<1)return false;
		return true;
	}

	private boolean comprobarCajasVacias() {
		return ((obtenerEstados()!=null)&&(obtenerFormatos().length>0));
	}

	private boolean validaDatos() {
		boolean datosCorrectos = true;
		//valida el numero de paginas 
		if(!validador.validarSoloNumeros(vistaPrincipal.panelDatos.getTxtNumPaginas().getText())) {
			pintarError(vistaPrincipal.panelDatos.getTxtNumPaginas(),true);
			datosCorrectos = false;			
		}
		else pintarError(vistaPrincipal.panelDatos.getTxtNumPaginas(),false);

		//valida el isbn
		if(!validador.validarLongitud (vistaPrincipal.panelDatos.getTxtISBN().getText(),LONGITUD_ISBN)||
				!validador.validarSoloNumeros(vistaPrincipal.panelDatos.getTxtISBN().getText())) {
				datosCorrectos = false;
				 if(vistaPrincipal.panelDatos.getTxtISBN().getText().length()>0&&
						 vistaPrincipal.panelDatos.getTxtISBN().getText().length()!=LONGITUD_ISBN){
					 pintarError(vistaPrincipal.panelDatos.getTxtISBN(),true);
				 }
				 else pintarError(vistaPrincipal.panelDatos.getTxtISBN(),false);
		}	
		else {
			pintarError(vistaPrincipal.panelDatos.getTxtISBN(),false);
		}
		return datosCorrectos;
	}
	
	private void pintarError(JTextField jTextField,boolean error) {
		if(error)jTextField.setBackground(COLOR_ERROR);
		else jTextField.setBackground(Color.white);
	}

	private void activarPanelTodos(boolean activar,JPanel panel) {
		for (int i = 0; i < panel.getComponentCount(); i++) {
			panel.getComponent(i).setEnabled(activar);
		}
	}

	public int getLibroSeleccionado() {
		return vistaPrincipal.librosDisponibles.getSelectedIndex();
	}

	public void cambiarListenerBoton(String nameBoton,ActionListener listener) {
		for (int i = 0; i < vistaPrincipal.panelBotones.getComponentCount(); i++) {
			JButton boton = (JButton)vistaPrincipal.panelBotones.getComponent(i);
			if(boton.getName().equals(nameBoton)) {
				removerListener(boton);
				boton.addActionListener(listener);
			}
		}
	}

	private void removerListener(JButton boton) {
		boton.removeActionListener(((ActionListener)boton.getActionListeners()[0]));
	}

	public void cambiarTextoBoton(String nameBoton, String texto) {
		for (int i = 0; i < vistaPrincipal.panelBotones.getComponentCount(); i++) {
			JButton boton = (JButton)vistaPrincipal.panelBotones.getComponent(i);
			if(boton.getName().equals(nameBoton)) {
				boton.setText(texto);
			}
		}
	}
	
	
}
