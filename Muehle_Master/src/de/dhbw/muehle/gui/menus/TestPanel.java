package de.dhbw.muehle.gui.menus;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyBoundsListener;

import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;

import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import java.awt.Dimension;

public class TestPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TestPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("51px:grow"),
				ColumnSpec.decode("max(183px;default):grow(6)"),
				ColumnSpec.decode("66px:grow(2)"),},
			new RowSpec[] {
				RowSpec.decode("max(198px;default):grow(3)"),
				RowSpec.decode("max(183px;default):grow(3)"),
				RowSpec.decode("max(219px;default):grow(3)"),}));
		
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);
		infoPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("max(51px;default):grow"),
				ColumnSpec.decode("max(85px;default):grow"),
				ColumnSpec.decode("20px"),
				ColumnSpec.decode("max(85px;default):grow"),
				ColumnSpec.decode("max(66px;default):grow"),},
			new RowSpec[] {
				RowSpec.decode("max(38px;default):grow(2)"),
				RowSpec.decode("max(85px;default):grow(25)"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("max(20px;default)"),
				RowSpec.decode("max(41px;default):grow(50)"),}));
		add(infoPanel, "1, 1, 3, 1, fill, fill");
		
			JLabel lblSpielSteinSpieler1 = new JLabel("weiss");
			infoPanel.add(lblSpielSteinSpieler1, "2, 2, fill, fill");
			
			JLabel lblSpielSteinSpieler2 = new JLabel("schwarz");
			infoPanel.add(lblSpielSteinSpieler2, "4, 2, fill, fill");
			
			JLabel lblSpielerDran = new JLabel();
			lblSpielerDran.setFont(new Font("Arial", Font.BOLD, 14));
			infoPanel.add(lblSpielerDran, "2, 4, 3, 1, center, fill");
		
			
		
		JTextArea logPane = new JTextArea();
		logPane.setLineWrap(true);
		logPane.setWrapStyleWord(true);
		logPane.setOpaque(false);
		logPane.setEditable(false);
		
		final JScrollPane logScroller = new JScrollPane();
		
		logScroller.setOpaque(false);
		logScroller.getViewport().setOpaque(false);
		logScroller.setViewportView(logPane);
		logScroller.setBorder(null);
		
		final JPanel logWrapper = new JPanel();
		logWrapper.setLayout(null);
		logWrapper.setOpaque(false);
		logWrapper.add(logScroller);
		add(logWrapper, "2, 2, fill, fill");
		
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("51px"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(32px;default)"),
				ColumnSpec.decode("max(97px;default)"),
				ColumnSpec.decode("default:grow"),
				ColumnSpec.decode("max(66px;default)"),},
			new RowSpec[] {
				RowSpec.decode("default:grow(25)"),
				RowSpec.decode("max(52px;default)"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("max(52px;default)"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("max(52px;default)"),
				RowSpec.decode("max(35px;default):grow"),}));
		add(buttonPanel, "1, 3, 3, 1, fill, fill");
			
			JButton button = new JButton("?");
			button.setPreferredSize(new Dimension(0, 0));
			buttonPanel.add(button, "3, 2, fill, fill");
		
			JButton btnNeustart = new JButton("Neustart");
			buttonPanel.add(btnNeustart, "3, 4, 2, 1, fill, fill");
			
			JButton btnBack = new JButton("ZumMenue");
			buttonPanel.add(btnBack, "3, 6, 2, 1, fill, fill");

	}
}
