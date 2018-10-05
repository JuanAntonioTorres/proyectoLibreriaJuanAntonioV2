package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Dimension;

public class panelChecks extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel panelFormato;
	private JPanel panelEstado;
	private ButtonGroup botonGrupo;
	public panelChecks() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(150, 450));
		setMinimumSize(new Dimension(150, 300));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{170, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panelFormato = new JPanel();
		panelFormato.setPreferredSize(new Dimension(122, 333));
		panelFormato.setBackground(new Color(255, 255, 255));
		panelFormato.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "FORMATO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelFormato = new GridBagConstraints();
		gbc_panelFormato.insets = new Insets(0, 0, 5, 0);
		gbc_panelFormato.fill = GridBagConstraints.BOTH;
		gbc_panelFormato.gridx = 0;
		gbc_panelFormato.gridy = 0;
		add(panelFormato, gbc_panelFormato);
		panelFormato.setLayout(new GridLayout(0, 1, 0, 0));
		
		JCheckBox checkBox = new JCheckBox("Cartone");
		checkBox.setPreferredSize(new Dimension(122, 33));
		checkBox.setMaximumSize(new Dimension(122, 90));
		checkBox.setBackground(new Color(255, 255, 255));
		checkBox.setFont(new Font("Dialog", Font.BOLD, 14));
		panelFormato.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Rustica");
		checkBox_1.setPreferredSize(new Dimension(122, 33));
		checkBox_1.setMaximumSize(new Dimension(122, 90));
		checkBox_1.setBackground(new Color(255, 255, 255));
		checkBox_1.setFont(new Font("Dialog", Font.BOLD, 14));
		panelFormato.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Tapa Dura");
		checkBox_2.setPreferredSize(new Dimension(122, 33));
		checkBox_2.setMaximumSize(new Dimension(122, 90));
		checkBox_2.setBackground(new Color(255, 255, 255));
		checkBox_2.setFont(new Font("Dialog", Font.BOLD, 14));
		panelFormato.add(checkBox_2);
		
		panelEstado = new JPanel();
		panelEstado.setPreferredSize(new Dimension(122, 222));
		panelEstado.setBackground(new Color(255, 255, 255));
		panelEstado.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "ESTADO", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panelEstado = new GridBagConstraints();
		gbc_panelEstado.fill = GridBagConstraints.BOTH;
		gbc_panelEstado.gridx = 0;
		gbc_panelEstado.gridy = 1;
		add(panelEstado, gbc_panelEstado);
		panelEstado.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton radioButton = new JRadioButton("Novedad");
		radioButton.setPreferredSize(new Dimension(122, 33));
		radioButton.setMaximumSize(new Dimension(122, 90));
		radioButton.setBackground(new Color(255, 255, 255));
		radioButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panelEstado.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Reedici\u00F3n");
		radioButton_1.setPreferredSize(new Dimension(122, 33));
		radioButton_1.setMaximumSize(new Dimension(122, 90));
		radioButton_1.setBackground(new Color(255, 255, 255));
		radioButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		panelEstado.add(radioButton_1);
		
		botonGrupo = new ButtonGroup();
		botonGrupo.add(radioButton);
		botonGrupo.add(radioButton_1);
	}
	
	
	
	public ButtonGroup getBotonGrupo() {
		return botonGrupo;
	}

	public JPanel getPanelFormato() {
		return panelFormato;
	}

	public JPanel getPanelEstado() {
		return panelEstado;
	}
	
}
