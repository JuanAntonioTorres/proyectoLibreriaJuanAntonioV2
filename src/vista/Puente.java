package vista;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import control.ListenerBotonAlta;
import control.ListenerBotonBaja;
import control.ListenerBotonNuevo;
import control.ListenerCompruebaAlta;
import control.Logica;
import control.MouseListenerLista;

public class Puente extends VistaPrincipal {
	private static final long serialVersionUID = 1L;
	
	public Puente() {
		super();
		asignarListeners();
	}

	private void asignarListeners() {
		Logica logica = new Logica();
		LogicaGrafica logicaGrafica = new LogicaGrafica(this);
		ponerListenerEnBotones(logica,logicaGrafica);
		ponerMouseListenerEnListaLibro(logica,logicaGrafica);
		ponerListenerEnTextFields(logicaGrafica);
		ponerListenerEnChecks(logicaGrafica);
	}

	private void ponerMouseListenerEnListaLibro(Logica logica, LogicaGrafica logicaGrafica) {
		this.librosDisponibles.addMouseListener(new MouseListenerLista(logica , logicaGrafica));
	}

	private void ponerListenerEnChecks(LogicaGrafica logicaGrafica) {
		ponerListenerEnFormato(logicaGrafica);
		ponerListenerEnEstado(logicaGrafica);
	}

	private void ponerListenerEnBotones(Logica logica, LogicaGrafica logicaGrafica) {
		this.panelBotones.getBtnNuevo().addActionListener(new ListenerBotonNuevo(logica,logicaGrafica));
		this.panelBotones.getBtnAlta().addActionListener(new ListenerBotonAlta(logica, logicaGrafica));
		this.panelBotones.getBtnBaja().addActionListener(new ListenerBotonBaja(logica, logicaGrafica));
	}

	private void ponerListenerEnTextFields(LogicaGrafica logicaGrafica) {
		for (int i = 0; i < panelDatos.getComponentCount(); i++) {
			if(panelDatos.getComponent(i).getClass().equals(JTextField.class)) {
				((JTextField)panelDatos.getComponent(i)).addKeyListener(new ListenerCompruebaAlta(logicaGrafica));
			}
		}
	}
	private void ponerListenerEnEstado(LogicaGrafica logicaGrafica) {
		for (int i = 0; i < panelChecks.getPanelEstado().getComponentCount(); i++) {
			((JRadioButton)panelChecks.getPanelEstado().getComponent(i)).addActionListener(new ListenerCompruebaAlta(logicaGrafica));
		}
	}

	private void ponerListenerEnFormato(LogicaGrafica logicaGrafica) {
		for (int i = 0; i < panelChecks.getPanelFormato().getComponentCount(); i++) {
			((JCheckBox)panelChecks.getPanelFormato().getComponent(i)).addActionListener(new ListenerCompruebaAlta(logicaGrafica));
		}
	}
	
}
