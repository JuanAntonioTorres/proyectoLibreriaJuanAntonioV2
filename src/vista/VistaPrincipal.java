package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final  String TITULOAPLICACION = "LIBRERÍA";
	protected PanelBotones panelBotones;
	protected panelChecks panelChecks;
	protected PanelDatos panelDatos;
	protected JList<String> librosDisponibles;
	
	public VistaPrincipal(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setForeground(new Color(102, 102, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 500);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 94, 75, 114, 22, 56, 91, 28};
		gridBagLayout.rowHeights = new int[]{53, 28, 41, 55, 55, 55,55, 55, 55};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
			JLabel lblTitulo = new JLabel(TITULOAPLICACION);
			lblTitulo.setForeground(new Color(0, 0, 102));
			lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			GridBagConstraints gbclblTitulo = new GridBagConstraints();
			gbclblTitulo.fill = GridBagConstraints.VERTICAL;
			gbclblTitulo.gridwidth = 8;
			gbclblTitulo.insets = new Insets(0, 0, 5, 0);
			gbclblTitulo.gridx = 0;
			gbclblTitulo.gridy = 0;
			getContentPane().add(lblTitulo, gbclblTitulo);
		
		
		panelDatos = new PanelDatos();
		panelDatos.getTxtTitulo().setMaximumSize(new Dimension(122, 35));
		panelDatos.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbcpanelDatos = new GridBagConstraints();
		gbcpanelDatos.gridheight = 4;
		gbcpanelDatos.gridwidth = 2;
		gbcpanelDatos.fill = GridBagConstraints.BOTH;
		gbcpanelDatos.insets = new Insets(0, 0, 5, 5);
		gbcpanelDatos.gridx = 1;
		gbcpanelDatos.gridy = 2;
		getContentPane().add(panelDatos, gbcpanelDatos);
		
		panelChecks = new panelChecks();
		panelChecks.setBackground(new Color(255, 255, 255));
		panelChecks.getPanelEstado().setBackground(new Color(255, 255, 255));
		panelChecks.getPanelFormato().setBackground(new Color(255, 255, 255));
		GridBagConstraints gbcPanelChecks = new GridBagConstraints();
		gbcPanelChecks.fill = GridBagConstraints.BOTH;
		gbcPanelChecks.insets = new Insets(0, 0, 5, 5);
		gbcPanelChecks.gridx = 3;
		gbcPanelChecks.gridheight = 4;
		gbcPanelChecks.gridy = 2;
		getContentPane().add(panelChecks, gbcPanelChecks);
		
		JLabel lblEstanteria = new JLabel("Estanter\u00EDa");
		lblEstanteria.setForeground(new Color(102, 51, 0));
		lblEstanteria.setFont(new Font("Segoe Print", Font.BOLD, 30));
		GridBagConstraints gbclblEstanteria = new GridBagConstraints();
		gbclblEstanteria.gridheight = 2;
		gbclblEstanteria.fill = GridBagConstraints.VERTICAL;
		gbclblEstanteria.gridwidth = 2;
		gbclblEstanteria.insets = new Insets(0, 0, 5, 5);
		gbclblEstanteria.gridx = 5;
		gbclblEstanteria.gridy = 1;
		getContentPane().add(lblEstanteria, gbclblEstanteria);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbcscrollPane = new GridBagConstraints();
		gbcscrollPane.insets = new Insets(0, 0, 5, 5);
		gbcscrollPane.gridheight = 3;
		gbcscrollPane.gridwidth = 2;
		gbcscrollPane.fill = GridBagConstraints.BOTH;
		gbcscrollPane.gridx = 5;
		gbcscrollPane.gridy = 3;
		getContentPane().add(scrollPane, gbcscrollPane);
		
		librosDisponibles = new JList<>();
		librosDisponibles.setVisibleRowCount(5);
		librosDisponibles.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		scrollPane.setViewportView(librosDisponibles);
		
		panelBotones = new PanelBotones();
		panelBotones.setMinimumSize(new Dimension(374, 152));
		panelBotones.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbcpanelBotones = new GridBagConstraints();
		gbcpanelBotones.fill = GridBagConstraints.BOTH;
		gbcpanelBotones.gridwidth = 6;
		gbcpanelBotones.insets = new Insets(0, 0, 0, 5);
		gbcpanelBotones.gridx = 1;
		gbcpanelBotones.gridheight = 3;
		gbcpanelBotones.gridy = 6;
		getContentPane().add(panelBotones, gbcpanelBotones);	
		
	}		
}