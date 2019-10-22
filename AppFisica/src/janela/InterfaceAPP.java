package janela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JRadioButton;

public class InterfaceAPP extends JFrame {

	private JPanel janela;
	private JTextField txtCampoEletrico, txtExCampo, txtComprimentoHaste, txtForca, txtConstante, txtExComprimentoHaste,
			txtExForca;
	private JButton btnCalcular;
	private JLabel lblImagemHaste, lblComprimentoIniciala, lblCampoEletrico, lblComprimentoDaHaste, lblForcaEltrica;
	private JLabel lblEscolhaAHaste, lblDadosDoExercicio, lblUndMedidaCampo, lblConstantek, lblResultado,
			lblUniMedidaHaste, lblUniMedidaForca;
	private JLabel lblCarga, lblUniMedidaCarga, lblUniMedidaComInicial, lblEx, lblExpHaste, lblExpForca, lblExpCarga,
			lblCompInicial, lblDistanciax, lblExpDistanciaX;
	private JLabel lblUnDistanciaX, lblDenDeCarga, lblExpDenCarga, lblUnDenCarga, lblExpConstanteK, lblUnConstanteK;
	private JTextField txtCarga, txtExCarga, txtComInicial, txtExComInicial, txtUniCampo;
	private JComboBox comboUniForca, comboUniCampo, comboUniHaste, comboUniCarga, comboUniComInicial, comboDistanciaX,
			comboDenCarga;
	private JTextField txtDistanciaX, txtExpDistanciaX, txtDenCarga, txtExpDenCarga, txtExpConstanteK, txtUnConstanteK,
			txtPasso1, txtPasso2, txtPasso3, txtPasso4, txtPasso5, txtPasso6, txtPasso7;
	private JRadioButton boxHasteEixo, boxHasteFora, boxHasteInfinita;
	ButtonGroup grupoDeHaste;
	private int id = 0;

	public InterfaceAPP() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 1000, 735);
		setTitle("Cálculos de Física");

		criaComponentes();
		AcaoHasteEixo();
		AcaoHasteFora();
		AcaoHasteInfinita();
		setVisible(true);
	}

	private void criaComponentes() {
		janela = new JPanel();
		janela.setBackground(new Color(0, 0, 0));
		janela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(janela);
		janela.setLayout(null);

		// _________________Criando os paines______________________________
		// PAINEL PRINCIPAL
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(12, 13, 955, 662);
		janela.add(panel);
		panel.setLayout(null);

		JPanel panelEscolhaHaste = new JPanel();
		panelEscolhaHaste.setForeground(Color.DARK_GRAY);
		panelEscolhaHaste.setBackground(Color.DARK_GRAY);
		panelEscolhaHaste.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelEscolhaHaste.setBounds(12, 13, 930, 52);
		panel.add(panelEscolhaHaste);
		panelEscolhaHaste.setLayout(null);

		JPanel panelCalculo = new JPanel();
		panelCalculo.setBackground(Color.DARK_GRAY);
		panelCalculo.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCalculo.setBounds(12, 78, 930, 571);
		panel.add(panelCalculo);
		panelCalculo.setLayout(null);
		// ______________________Fim_______________________________________

		// ___________________Criando os JRadioButton __________________________

		boxHasteFora = new JRadioButton("HASTE FORA DO EIXO X");
		boxHasteFora.setForeground(Color.WHITE);
		boxHasteFora.setBackground(Color.DARK_GRAY);
		boxHasteFora.setBounds(237, 9, 185, 25);
		panelEscolhaHaste.add(boxHasteFora);

		boxHasteEixo = new JRadioButton("HASTE NO EIXO X");
		boxHasteEixo.setForeground(Color.WHITE);
		boxHasteEixo.setBackground(Color.DARK_GRAY);
		boxHasteEixo.setBounds(457, 9, 147, 25);
		panelEscolhaHaste.add(boxHasteEixo);

		boxHasteInfinita = new JRadioButton("HASTE INFINITA");
		boxHasteInfinita.setForeground(Color.WHITE);
		boxHasteInfinita.setBackground(Color.DARK_GRAY);
		boxHasteInfinita.setBounds(635, 10, 115, 23);
		panelEscolhaHaste.add(boxHasteInfinita);

		grupoDeHaste = new ButtonGroup();
		grupoDeHaste.add(boxHasteFora);
		grupoDeHaste.add(boxHasteEixo);
		grupoDeHaste.add(boxHasteInfinita);

		// ______________________Fim_______________________________________

		// ____________________________Criando os Comboboxs________________
		txtUniCampo = new JTextField("C²/n * m²");
		txtUniCampo.setBounds(359, 53, 83, 22);
		txtUniCampo.setEditable(false);
		panelCalculo.add(txtUniCampo);

		comboUniHaste = new JComboBox();
		comboUniHaste.setModel(new DefaultComboBoxModel(new String[] { "m", "cm", "mm" }));
		comboUniHaste.setBounds(795, 53, 101, 22);
		panelCalculo.add(comboUniHaste);

		comboUniForca = new JComboBox();
		comboUniForca.setModel(new DefaultComboBoxModel(new String[] { "N" }));
		comboUniForca.setBounds(359, 86, 83, 22);
		panelCalculo.add(comboUniForca);

		comboUniCarga = new JComboBox();
		comboUniCarga.setModel(new DefaultComboBoxModel(new String[] { "C", "\u00B5C", "nC" }));
		comboUniCarga.setBounds(795, 86, 101, 22);
		panelCalculo.add(comboUniCarga);

		comboUniComInicial = new JComboBox();
		comboUniComInicial.setModel(new DefaultComboBoxModel(new String[] { "m", "cm", "mm" }));
		comboUniComInicial.setBounds(359, 116, 83, 22);
		panelCalculo.add(comboUniComInicial);
		// _________________________________Fim___________________________

		// ____________________Criandos os textFields_______________________

		txtConstante = new JTextField();
		txtConstante.setText("9*10");
		txtConstante.setEditable(false);
		txtConstante.setBounds(569, 150, 61, 22);
		panelCalculo.add(txtConstante);
		txtConstante.setColumns(10);

		txtExCampo = new JTextField("-12");
		txtExCampo.setBounds(228, 53, 29, 22);
		panelCalculo.add(txtExCampo);
		txtExCampo.setColumns(10);

		txtComprimentoHaste = new JTextField();
		txtComprimentoHaste.setBounds(569, 53, 62, 22);
		panelCalculo.add(txtComprimentoHaste);
		txtComprimentoHaste.setColumns(10);

		txtForca = new JTextField();
		txtForca.setBounds(127, 83, 61, 22);
		panelCalculo.add(txtForca);
		txtForca.setColumns(10);

		txtExComprimentoHaste = new JTextField();
		txtExComprimentoHaste.setBounds(680, 53, 29, 22);
		panelCalculo.add(txtExComprimentoHaste);
		txtExComprimentoHaste.setColumns(10);

		txtExForca = new JTextField();
		txtExForca.setColumns(10);
		txtExForca.setBounds(228, 86, 29, 22);
		panelCalculo.add(txtExForca);

		txtCarga = new JTextField();
		txtCarga.setBounds(569, 86, 61, 22);
		panelCalculo.add(txtCarga);
		txtCarga.setColumns(10);

		txtExCarga = new JTextField();
		txtExCarga.setColumns(10);
		txtExCarga.setBounds(680, 86, 29, 22);
		panelCalculo.add(txtExCarga);

		txtComInicial = new JTextField();
		txtComInicial.setBounds(127, 116, 61, 22);
		panelCalculo.add(txtComInicial);
		txtComInicial.setColumns(10);

		txtExComInicial = new JTextField();
		txtExComInicial.setColumns(10);
		txtExComInicial.setBounds(228, 119, 29, 22);
		panelCalculo.add(txtExComInicial);
		// ___________________________Fim____________________________________

		// _______________________Criando os labels__________________________

		lblComprimentoDaHaste = new JLabel("Comp. da Haste (L):");
		lblComprimentoDaHaste.setForeground(Color.WHITE);
		lblComprimentoDaHaste.setBounds(454, 56, 116, 16);
		panelCalculo.add(lblComprimentoDaHaste);

		lblForcaEltrica = new JLabel("Den. Linear (\u03BB):");
		lblForcaEltrica.setForeground(Color.WHITE);
		lblForcaEltrica.setBounds(12, 86, 111, 16);
		panelCalculo.add(lblForcaEltrica);

		lblConstantek = new JLabel("Constante (K): ");
		lblConstantek.setForeground(Color.WHITE);
		lblConstantek.setBounds(454, 153, 107, 16);
		panelCalculo.add(lblConstantek);

		lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setBounds(12, 177, 94, 22);
		panelCalculo.add(lblResultado);

		lblEscolhaAHaste = new JLabel("ESCOLHA O TIPO DE HASTE :");
		lblEscolhaAHaste.setForeground(Color.WHITE);
		lblEscolhaAHaste.setBounds(46, 11, 185, 21);
		panelEscolhaHaste.add(lblEscolhaAHaste);
		// __________________________________Fim_________________________________

		// _______________Criando os botões______________________________________

		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(793, 8, 101, 29);
		panelEscolhaHaste.add(btnCalcular);
		btnCalcular.setFont(new Font("Sitka Text", Font.BOLD, 12));
		btnCalcular.setForeground(Color.BLACK);
		btnCalcular.setBackground(new Color(255, 153, 102));
		
		
		JButton btnNewButton = new JButton("LIMPAR PASSOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtPasso1.setText("");
				txtPasso2.setText("");
				txtPasso3.setText("");
				txtPasso4.setText("");
				txtPasso5.setText("");
				txtPasso6.setText("");
				txtPasso7.setText("");
				
				
			}
		});
		btnNewButton.setBounds(308, 177, 134, 23);
		panelCalculo.add(btnNewButton);
		
		

		lblDadosDoExercicio = new JLabel("DADOS DO EXEMPLO :");
		lblDadosDoExercicio.setForeground(Color.WHITE);
		lblDadosDoExercicio.setBounds(12, 11, 214, 22);
		panelCalculo.add(lblDadosDoExercicio);

		lblCampoEletrico = new JLabel("Epsilon (ε0):");
		lblCampoEletrico.setForeground(Color.WHITE);
		lblCampoEletrico.setBounds(12, 59, 111, 16);
		panelCalculo.add(lblCampoEletrico);

		txtCampoEletrico = new JTextField("8,85");
		txtCampoEletrico.setBounds(126, 53, 61, 22);
		panelCalculo.add(txtCampoEletrico);
		txtCampoEletrico.setColumns(10);

		lblUndMedidaCampo = new JLabel("Und. Medida:");
		lblUndMedidaCampo.setForeground(Color.WHITE);
		lblUndMedidaCampo.setBounds(267, 56, 83, 16);
		panelCalculo.add(lblUndMedidaCampo);

		lblImagemHaste = new JLabel("");
		lblImagemHaste.setBounds(446, 210, 475, 350);
		panelCalculo.add(lblImagemHaste);

		lblUniMedidaHaste = new JLabel("Und. Medida:");
		lblUniMedidaHaste.setForeground(Color.WHITE);
		lblUniMedidaHaste.setBounds(719, 56, 83, 16);
		panelCalculo.add(lblUniMedidaHaste);

		lblUniMedidaForca = new JLabel("Und. Medida:");
		lblUniMedidaForca.setForeground(Color.WHITE);
		lblUniMedidaForca.setBounds(267, 86, 83, 16);
		panelCalculo.add(lblUniMedidaForca);

		lblCarga = new JLabel("Carga (Q):");
		lblCarga.setForeground(Color.WHITE);
		lblCarga.setBounds(454, 89, 92, 16);
		panelCalculo.add(lblCarga);

		lblComprimentoIniciala = new JLabel("Comp. Inicial (A):");
		lblComprimentoIniciala.setForeground(Color.WHITE);
		lblComprimentoIniciala.setBounds(12, 116, 111, 16);
		panelCalculo.add(lblComprimentoIniciala);

		lblUniMedidaCarga = new JLabel("Und. Medida:");
		lblUniMedidaCarga.setForeground(Color.WHITE);
		lblUniMedidaCarga.setBounds(719, 89, 83, 16);
		panelCalculo.add(lblUniMedidaCarga);

		lblUniMedidaComInicial = new JLabel("Und. Medida:");
		lblUniMedidaComInicial.setForeground(Color.WHITE);
		lblUniMedidaComInicial.setBounds(267, 119, 83, 16);
		panelCalculo.add(lblUniMedidaComInicial);

		lblEx = new JLabel("Exp:");
		lblEx.setForeground(Color.WHITE);
		lblEx.setBounds(197, 60, 29, 14);
		panelCalculo.add(lblEx);

		lblExpHaste = new JLabel("Exp:");
		lblExpHaste.setForeground(Color.WHITE);
		lblExpHaste.setBounds(641, 57, 29, 14);
		panelCalculo.add(lblExpHaste);

		lblExpForca = new JLabel("Exp:");
		lblExpForca.setForeground(Color.WHITE);
		lblExpForca.setBounds(198, 87, 29, 14);
		panelCalculo.add(lblExpForca);

		lblExpCarga = new JLabel("Exp:");
		lblExpCarga.setForeground(Color.WHITE);
		lblExpCarga.setBounds(641, 90, 29, 14);
		panelCalculo.add(lblExpCarga);

		lblCompInicial = new JLabel("Exp:");
		lblCompInicial.setForeground(Color.WHITE);
		lblCompInicial.setBounds(198, 120, 29, 14);
		panelCalculo.add(lblCompInicial);

		lblDistanciax = new JLabel("Dist\u00E2ncia(X):");
		lblDistanciax.setForeground(Color.WHITE);
		lblDistanciax.setBounds(454, 122, 92, 16);
		panelCalculo.add(lblDistanciax);

		txtDistanciaX = new JTextField();
		txtDistanciaX.setColumns(10);
		txtDistanciaX.setBounds(570, 119, 61, 22);
		panelCalculo.add(txtDistanciaX);

		lblExpDistanciaX = new JLabel("Exp:");
		lblExpDistanciaX.setForeground(Color.WHITE);
		lblExpDistanciaX.setBounds(641, 123, 29, 14);
		panelCalculo.add(lblExpDistanciaX);

		txtExpDistanciaX = new JTextField();
		txtExpDistanciaX.setColumns(10);
		txtExpDistanciaX.setBounds(680, 119, 29, 22);
		panelCalculo.add(txtExpDistanciaX);

		lblUnDistanciaX = new JLabel("Und. Medida:");
		lblUnDistanciaX.setForeground(Color.WHITE);
		lblUnDistanciaX.setBounds(719, 119, 83, 16);
		panelCalculo.add(lblUnDistanciaX);

		comboDistanciaX = new JComboBox();
		comboDistanciaX.setModel(new DefaultComboBoxModel(new String[] { "m", "cm", "mm" }));
		comboDistanciaX.setBounds(795, 119, 101, 22);
		panelCalculo.add(comboDistanciaX);

		lblDenDeCarga = new JLabel("Den. Carga ( \u03BB):");
		lblDenDeCarga.setForeground(Color.WHITE);
		lblDenDeCarga.setBounds(12, 151, 111, 16);
		panelCalculo.add(lblDenDeCarga);

		txtDenCarga = new JTextField();
		txtDenCarga.setColumns(10);
		txtDenCarga.setBounds(127, 149, 61, 22);
		panelCalculo.add(txtDenCarga);

		lblExpDenCarga = new JLabel("Exp:");
		lblExpDenCarga.setForeground(Color.WHITE);
		lblExpDenCarga.setBounds(197, 153, 29, 14);
		panelCalculo.add(lblExpDenCarga);

		txtExpDenCarga = new JTextField();
		txtExpDenCarga.setColumns(10);
		txtExpDenCarga.setBounds(228, 152, 29, 22);
		panelCalculo.add(txtExpDenCarga);

		lblUnDenCarga = new JLabel("Und. Medida:");
		lblUnDenCarga.setForeground(Color.WHITE);
		lblUnDenCarga.setBounds(267, 151, 83, 16);
		panelCalculo.add(lblUnDenCarga);

		comboDenCarga = new JComboBox();
		comboDenCarga.setModel(new DefaultComboBoxModel(new String[] { "C/m", "C/cm", "C/mm" }));
		comboDenCarga.setBounds(359, 150, 83, 22);
		panelCalculo.add(comboDenCarga);

		lblExpConstanteK = new JLabel("Exp:");
		lblExpConstanteK.setForeground(Color.WHITE);
		lblExpConstanteK.setBounds(640, 154, 29, 14);
		panelCalculo.add(lblExpConstanteK);

		txtExpConstanteK = new JTextField();
		txtExpConstanteK.setText("9");
		txtExpConstanteK.setEditable(false);
		txtExpConstanteK.setColumns(10);
		txtExpConstanteK.setBounds(680, 150, 29, 22);
		panelCalculo.add(txtExpConstanteK);

		lblUnConstanteK = new JLabel("Und. Medida:");
		lblUnConstanteK.setForeground(Color.WHITE);
		lblUnConstanteK.setBounds(719, 153, 83, 16);
		panelCalculo.add(lblUnConstanteK);

		txtUnConstanteK = new JTextField();
		txtUnConstanteK.setText("N * m²/C²");
		txtUnConstanteK.setEditable(false);
		txtUnConstanteK.setBounds(795, 150, 101, 22);
		panelCalculo.add(txtUnConstanteK);
		txtUnConstanteK.setColumns(10);

		txtPasso1 = new JTextField();
		txtPasso1.setBounds(12, 210, 430, 50);
		txtPasso1.setEditable(false);
		txtPasso1.setBackground(Color.WHITE);
		panelCalculo.add(txtPasso1);

		txtPasso2 = new JTextField();
		txtPasso2.setBounds(12, 261, 430, 50);
		txtPasso2.setEditable(false);
		txtPasso2.setBackground(Color.WHITE);
		panelCalculo.add(txtPasso2);

		txtPasso3 = new JTextField();
		txtPasso3.setBounds(12, 311, 430, 50);
		txtPasso3.setEditable(false);
		txtPasso3.setBackground(Color.WHITE);
		panelCalculo.add(txtPasso3);

		txtPasso4 = new JTextField();
		txtPasso4.setBounds(12, 361, 430, 50);
		txtPasso4.setEditable(false);
		txtPasso4.setBackground(Color.WHITE);
		panelCalculo.add(txtPasso4);

		txtPasso5 = new JTextField();
		txtPasso5.setBounds(12, 410, 430, 50);
		txtPasso5.setEditable(false);
		txtPasso5.setBackground(Color.WHITE);
		panelCalculo.add(txtPasso5);

		txtPasso6 = new JTextField();
		txtPasso6.setBounds(12, 460, 430, 50);
		txtPasso6.setEditable(false);
		txtPasso6.setBackground(Color.WHITE);
		panelCalculo.add(txtPasso6);

		txtPasso7 = new JTextField();
		txtPasso7.setBounds(12, 510, 430, 50);
		txtPasso7.setEditable(false);
		txtPasso7.setBackground(Color.WHITE);
		panelCalculo.add(txtPasso7);
		
	
		
		
		
		
		
		
		
		

		// _________________________Fim______________________________________________
	}

	// __________________________Função para Limpar os
	// texfields______________________
	public void limpaTextField() {

		txtCarga.setText("");
		txtExCarga.setText("");
		comboUniCarga.setSelectedItem("C");

		txtComInicial.setText("");
		txtExComInicial.setText("");
		comboUniComInicial.setSelectedItem("m");

		txtComprimentoHaste.setText("");
		txtExComprimentoHaste.setText("");
		comboUniHaste.setSelectedItem("m");

		txtDenCarga.setText("");
		txtExpDenCarga.setText("");
		comboDenCarga.setSelectedItem("C/m");

		txtDistanciaX.setText("");
		txtExpDistanciaX.setText("");
		comboDistanciaX.setSelectedItem("m");

	}

	private void AcaoHasteEixo() {

		boxHasteEixo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (boxHasteEixo.isSelected() == true && boxHasteFora.isSelected() == false
						&& boxHasteInfinita.isSelected() == false) {
					System.out.println("Esta selecionado o Haste no Eixo");
					id = 1;
					ImageIcon img = new ImageIcon("img/haste.png");
					lblImagemHaste.setIcon(img);

					txtCampoEletrico.setEditable(true);
					
					txtExCampo.setEditable(true);
					
					txtComprimentoHaste.setEditable(true);
					
					txtExComprimentoHaste.setEditable(true);
					
					
					comboUniHaste.setEnabled(true);

					
					txtForca.setEditable(true);
					
					
					txtExForca.setEditable(true);
					
					
					comboUniForca.setEnabled(true);

					
					txtCarga.setEditable(true);
					
					
					txtExCarga.setEditable(true);
					
					
					comboUniCarga.setEnabled(true);

					txtComInicial.setEditable(true);
					txtExComInicial.setEditable(true);
					comboUniComInicial.setEnabled(true);

					txtDistanciaX.setEditable(true);
					txtExpDistanciaX.setEditable(true);
					comboDistanciaX.setEnabled(true);

					txtDenCarga.setEditable(true);
					txtExpDenCarga.setEditable(true);
					comboDenCarga.setEnabled(true);
					repaint();
					
					//Desabilitando os campos do JtexField
					txtCampoEletrico.setEditable(false);
					
					txtExCampo.setEditable(false);
					
					txtDistanciaX.setEditable(false);
					
					txtExpDistanciaX.setEditable(false);
					
					comboDistanciaX.setEnabled(false);
					
					txtForca.setEditable(false);
					
					txtExForca.setEditable(false);
					
					comboUniForca.setEnabled(false);
					
					txtDenCarga.setEditable(false);
					
					txtExpDenCarga.setEditable(false);
					
					comboDenCarga.setEnabled(false);
					
					repaint();
					
				

				}
				limpaTextField();
			}

		});

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if ((id == 1) && (boxHasteEixo.isSelected() == true && boxHasteFora.isSelected() == false
						&& boxHasteInfinita.isSelected() == false)) {

					demonstraHasteEixo();
					repaint();
				}
			}
		});
	}

	private void AcaoHasteFora() {

		boxHasteFora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (boxHasteFora.isSelected() == true && boxHasteEixo.isSelected() == false
						&& boxHasteInfinita.isSelected() == false) {
					System.out.println("Esta selecionado o Haste fora");
					id = 2;
					ImageIcon img2 = new ImageIcon("img/hasteFora.png");
					lblImagemHaste.setIcon(img2);

					txtCampoEletrico.setEditable(true);
					txtExCampo.setEditable(true);

					txtComprimentoHaste.setEditable(true);
					txtExComprimentoHaste.setEditable(true);
					comboUniHaste.setEnabled(true);

					txtForca.setEditable(true);
					txtExForca.setEditable(true);
					comboUniForca.setEnabled(true);

					txtCarga.setEditable(true);
					txtExCarga.setEditable(true);
					comboUniCarga.setEnabled(true);

					txtComInicial.setEditable(true);
					txtExComInicial.setEditable(true);
					comboUniComInicial.setEnabled(true);

					txtDistanciaX.setEditable(true);
					txtExpDistanciaX.setEditable(true);
					comboDistanciaX.setEnabled(true);

					txtDenCarga.setEditable(true);
					txtExpDenCarga.setEditable(true);
					comboDenCarga.setEnabled(true);
					
					repaint();
					
					//Desabilitando os campos do JtexField
					txtDenCarga.setEditable(false);
					
					txtExpDenCarga.setEditable(false);
					
					comboDenCarga.setEnabled(false);
					
					txtCampoEletrico.setEditable(false);
					
					txtExCampo.setEditable(false);
					
					txtComprimentoHaste.setEditable(false);
					
					txtExComprimentoHaste.setEditable(false);
					
					txtForca.setEditable(false);
					
					txtExForca.setEditable(false);
					
					comboUniHaste.setEnabled(false);
					
					comboUniForca.setEnabled(false);
				
					
					repaint();
				

				}
				limpaTextField();
			}
		});

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if ((id == 2) && (boxHasteFora.isSelected() == true && boxHasteEixo.isSelected() == false
						&& boxHasteInfinita.isSelected() == false)) {
					demonstraHasteForaEixo();
				}
			}
		});
	}

	private void AcaoHasteInfinita() {

		boxHasteInfinita.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (boxHasteInfinita.isSelected() == true && boxHasteEixo.isSelected() == false
						&& boxHasteFora.isSelected() == false) {
					System.out.println("Esta selecionado o Haste infinita");
					id = 3;
					ImageIcon img3 = new ImageIcon("img/hasteInfinita.png");
					lblImagemHaste.setIcon(img3);

					txtCampoEletrico.setEditable(true);
					txtExCampo.setEditable(true);

					txtComprimentoHaste.setEditable(true);
					txtExComprimentoHaste.setEditable(true);
					comboUniHaste.setEnabled(true);

					txtForca.setEditable(true);
					txtExForca.setEditable(true);
					comboUniForca.setEnabled(true);

					txtCarga.setEditable(true);
					txtExCarga.setEditable(true);
					comboUniCarga.setEnabled(true);

					txtComInicial.setEditable(true);
					txtExComInicial.setEditable(true);
					comboUniComInicial.setEnabled(true);

					txtDistanciaX.setEditable(true);
					txtExpDistanciaX.setEditable(true);
					comboDistanciaX.setEnabled(true);

					txtDenCarga.setEditable(true);
					txtExpDenCarga.setEditable(true);
					comboDenCarga.setEnabled(true);
					repaint();
					
					//Desabilitando os campos do JtexFiel
					txtCampoEletrico.setEditable(false);
					
					txtExCampo.setEditable(false);
				
					
					txtCarga.setEditable(false);
				
					
					txtExCarga.setEditable(false);
				
					
					comboUniCarga.setEnabled(false);
				
					
					txtDistanciaX.setEditable(false);
					
					
					txtExpDistanciaX.setEditable(false);
				
					
					comboDistanciaX.setEnabled(false);
		
					
					txtExComprimentoHaste.setEditable(false);
				
					
					txtComprimentoHaste.setEditable(false);
					
					
					comboUniHaste.setEnabled(false);
			
					
					txtForca.setEditable(false);
				
					
					txtExForca.setEditable(false);
					
					
					comboUniForca.setEnabled(false);
				
					
					repaint();
					
					

				}
				limpaTextField();
			}

		});

		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 if ((id == 3) && (boxHasteInfinita.isSelected() == true && boxHasteEixo.isSelected() == false
						&& boxHasteFora.isSelected() == false)) {
					hasteInfinita();
				}
			}
		});
	}

	private void demonstraHasteForaEixo() {
		double carga, comprimentoInicial, distanciaX, epsilon, resultado;
		int expCarga, expComprimentoInicial, expDistancia;

		if (txtCarga.getText().equals("") && txtComInicial.getText().equals("") && txtDistanciaX.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preeencha todos os campos!!");
		} else {
			carga = Double.parseDouble(txtCarga.getText());
			comprimentoInicial = Double.parseDouble(txtComInicial.getText());
			distanciaX = Double.parseDouble(txtDistanciaX.getText());
			epsilon = 8.85 * (Math.pow(10, -12));

			if (txtExCarga.getText().equals(""))
				expCarga = 0;
			else
				expCarga = Integer.parseInt(txtExCarga.getText());

			if (txtExComInicial.getText().equals(""))
				expComprimentoInicial = 0;
			else
				expComprimentoInicial = Integer.parseInt(txtExComInicial.getText());

			if (txtExpDistanciaX.getText().equals(""))
				expDistancia = 0;
			else
				expDistancia = Integer.parseInt(txtExpDistanciaX.getText());

			carga *= Math.pow(10, expCarga);
			comprimentoInicial *= Math.pow(10, expComprimentoInicial);
			distanciaX *= Math.pow(10, expDistancia);

			switch (comboUniCarga.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				carga *= Math.pow(10, -6);
				break;
			case 2:
				carga *= Math.pow(10, -9);
				break;
			}

			switch (comboUniComInicial.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				comprimentoInicial *= Math.pow(10, -2);
				break;
			case 2:
				comprimentoInicial *= Math.pow(10, -4);
				break;
			}

			switch (comboDistanciaX.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				distanciaX *= Math.pow(10, -2);
				break;
			case 2:
				distanciaX *= Math.pow(10, -4);
				break;
			}

			txtPasso1.setText("E = Q / 4 * π * Ԑ0 * x * (x² + a²)¹/²");

			txtPasso2.setText("E = " + carga + " / 4 * π * " + epsilon + " * " + distanciaX + " * (" + distanciaX
					+ "² + " + comprimentoInicial + "²)¹/²");

			txtPasso3.setText("E = " + carga + " / 4 * π * " + epsilon + " * " + distanciaX + " * ("
					+ Math.pow(distanciaX, 2) + " + " + Math.pow(comprimentoInicial, 2) + ")¹/²");

			txtPasso4.setText("E = " + carga + " / 4 * π * " + epsilon + " * " + distanciaX + " * "
					+ (Math.pow((Math.pow(distanciaX, 2) + Math.pow(comprimentoInicial, 2)), 0.5)));

			txtPasso5.setText("E = " + carga + " / " + (4 * Math.PI * epsilon * distanciaX
					* (Math.pow((Math.pow(distanciaX, 2) + Math.pow(comprimentoInicial, 2)), 0.5))));

			resultado = carga / (4 * Math.PI * epsilon * distanciaX
					* (Math.pow((Math.pow(distanciaX, 2) + Math.pow(comprimentoInicial, 2)), 0.5)));

			txtPasso6.setText("E = " + resultado);
		}
	}

	private void demonstraHasteEixo() {
		double comprimentoHaste, carga, comprimentoInicial, epsilon, resultado;
		int expComprimentoHaste, expCarga, expComprimentoInicial;

		if (txtComprimentoHaste.getText().equals("") && txtCarga.getText().equals("")
				&& txtComInicial.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preeencha todos os campos!!");
		} else {
			comprimentoHaste = Double.parseDouble(txtComprimentoHaste.getText());
			carga = Double.parseDouble(txtCarga.getText());
			comprimentoInicial = Double.parseDouble(txtComInicial.getText());
			epsilon = 8.85 * (Math.pow(10, -12));

			if (txtExComprimentoHaste.getText().equals(""))
				expComprimentoHaste = 0;
			else
				expComprimentoHaste = Integer.parseInt(txtExComprimentoHaste.getText());

			if (txtExCarga.getText().equals(""))
				expCarga = 0;
			else
				expCarga = Integer.parseInt(txtExCarga.getText());

			if (txtExComInicial.getText().equals(""))
				expComprimentoInicial = 0;
			else
				expComprimentoInicial = Integer.parseInt(txtExComInicial.getText());

			comprimentoHaste *= Math.pow(10, expComprimentoHaste);
			carga *= Math.pow(10, expCarga);
			comprimentoInicial *= Math.pow(10, expComprimentoInicial);

			switch (comboUniHaste.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				comprimentoHaste *= Math.pow(10, -2);
				break;
			case 2:
				comprimentoHaste *= Math.pow(10, -4);
				break;
			}

			switch (comboUniComInicial.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				comprimentoInicial *= Math.pow(10, -2);
				break;
			case 2:
				comprimentoInicial *= Math.pow(10, -4);
				break;
			}

			switch (comboUniCarga.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				carga *= Math.pow(10, -6);
				break;
			case 2:
				carga *= Math.pow(10, -9);
				break;
			}

			txtPasso1.setText("E = Q / 4 * π * Ԑ0 * a * (l + a)");
			txtPasso2.setText("E = " + carga + " / 4 * π * " + epsilon + " * " + comprimentoInicial + " * ("
					+ comprimentoHaste + " + " + comprimentoInicial + ")");
			txtPasso3.setText("E = " + carga + " / 4 * π * " + epsilon + " * " + comprimentoInicial + " * "
					+ (comprimentoHaste + comprimentoInicial));
			txtPasso4.setText("E = " + carga + " / "
					+ 4 * Math.PI * epsilon * comprimentoInicial * (comprimentoHaste + comprimentoInicial));
			resultado = carga / (4 * Math.PI * epsilon * comprimentoInicial * (comprimentoHaste + comprimentoInicial));
			txtPasso5.setText("E = " + resultado);
		}
	}

	private void hasteInfinita() {
		double comprimentoInicial, densidadeCarga, epsilon;
		int expComprimentoInicial, expDensidadeCarga;

		if (txtComInicial.getText().equals("") && txtDenCarga.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Preeencha todos os campos!!");
		} else {
			comprimentoInicial = Double.parseDouble(txtComInicial.getText());
			densidadeCarga = Double.parseDouble(txtDenCarga.getText());
			epsilon = 8.85 * (Math.pow(10, -12));

			if (txtExComInicial.getText().equals(""))
				expComprimentoInicial = 0;
			else
				expComprimentoInicial = Integer.parseInt(txtExComInicial.getText());

			if (txtExpDenCarga.getText().equals(""))
				expDensidadeCarga = 0;
			else
				expDensidadeCarga = Integer.parseInt(txtExpDenCarga.getText());

			comprimentoInicial *= Math.pow(10, expComprimentoInicial);
			densidadeCarga *= Math.pow(10, expDensidadeCarga);

			switch (comboUniComInicial.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				comprimentoInicial *= Math.pow(10, -2);
				break;
			case 2:
				comprimentoInicial *= Math.pow(10, -4);
				break;
			}

			switch (comboDenCarga.getSelectedIndex()) {
			case 0:
				break;
			case 1:
				densidadeCarga *= Math.pow(10, -2);
				break;
			case 2:
				densidadeCarga *= Math.pow(10, -4);
				break;
			}

			txtPasso1.setText("E = 2 * λ / 4 * π * Ԑ0 * a ");
			txtPasso2.setText("E = 2 * " + densidadeCarga + " / " + " 4 * π * " + epsilon + " * " + comprimentoInicial);
			txtPasso3.setText("E = 2 * " + densidadeCarga + " / " + 4 * Math.PI * epsilon * comprimentoInicial);
			txtPasso4.setText("E = " + 2 * densidadeCarga + " / " + 4 * Math.PI * epsilon * comprimentoInicial);
			txtPasso5.setText("E = " + (2 * densidadeCarga) / (4 * Math.PI * epsilon * comprimentoInicial));

		}
	}
}
