package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;

import br.sc.senac.controller.VacinaController;
import br.sc.senac.model.vo.VacinaVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroVacina extends JFrame {
	private JTextField txtPais;
	private DatePicker dataInicio;
	private JTextField txtNomePesquisador;
	private JRadioButton rbtnEstagioInicial;
	private JRadioButton rbtnEstagioTestes;
	private JRadioButton rbtnEstagioAplicacao;
	private int estagioSelecionado;
	private ButtonGroup rbtnGroupEstagio;
	private static final int ESTAGIO_INICIAL = 1;
	private static final int ESTAGIO_TESTES = 2;
	private static final int ESTAGIO_APLICACAO = 3;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVacina frame = new TelaCadastroVacina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 610);
		getContentPane().setLayout(null);
		
		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
		dateSettings.setFontValidDate(new Font("Tahoma", Font.PLAIN, 17));
		
		dataInicio = new DatePicker(dateSettings);
		dataInicio.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		dataInicio.setBounds(224, 278, 250, 30);
		getContentPane().add(dataInicio);
		JButton datePickerButton = dataInicio.getComponentToggleCalendarButton();
		datePickerButton.setText("");
		datePickerButton.setIcon(new ImageIcon(TelaCadastroVacina.class.getResource("/Imagens/calendario.png")));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 214, 571);
		panel.setBackground(new Color(48, 71, 94));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(214, 0, 270, 89);
		panel_1.setBackground(new Color(126, 138, 151));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro de Vacina");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 11, 250, 67);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(10, 162, 193, 221);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroVacina.class.getResource("/Imagens/vacina.png")));
		lblNewLabel.setBounds(10, 11, 173, 199);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nome do pesquisador respons\u00E1vel");
		lblNewLabel_2.setBounds(224, 181, 250, 21);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data de in\u00EDcio");
		lblNewLabel_3.setBounds(224, 253, 250, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pais");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(224, 319, 36, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtPais = new JTextField();
		txtPais.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtPais.setBounds(224, 344, 250, 30);
		getContentPane().add(txtPais);
		txtPais.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Est\u00E1gio da pesquisa");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(224, 385, 250, 21);
		getContentPane().add(lblNewLabel_5);
		
		rbtnEstagioInicial = new JRadioButton("Inicial");
		rbtnEstagioInicial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				estagioSelecionado = ESTAGIO_INICIAL;
			}
		});
		rbtnEstagioInicial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbtnEstagioInicial.setBounds(224, 413, 72, 23);
		getContentPane().add(rbtnEstagioInicial);
		
		rbtnEstagioTestes = new JRadioButton("Testes");
		rbtnEstagioTestes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				estagioSelecionado = ESTAGIO_TESTES;
			}
		});
		rbtnEstagioTestes.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbtnEstagioTestes.setBounds(298, 413, 77, 23);
		getContentPane().add(rbtnEstagioTestes);
		
		rbtnEstagioAplicacao = new JRadioButton("Aplica\u00E7\u00E3o");
		rbtnEstagioAplicacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				estagioSelecionado = ESTAGIO_APLICACAO;
			}
		});
		rbtnEstagioAplicacao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rbtnEstagioAplicacao.setBounds(377, 413, 105, 23);
		getContentPane().add(rbtnEstagioAplicacao);
		
		rbtnGroupEstagio = new ButtonGroup();
		rbtnGroupEstagio.add(rbtnEstagioInicial);
		rbtnGroupEstagio.add(rbtnEstagioTestes);
		rbtnGroupEstagio.add(rbtnEstagioAplicacao);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VacinaVO vacina = new VacinaVO();
				vacina.setPesquisador(txtNomePesquisador.getText());
				vacina.setPais(txtPais.getText());
				vacina.setEstagio(estagioSelecionado);
				vacina.setDtInicioPesquisa(dataInicio.getDate());
				
				VacinaController vacinaController = new VacinaController();
				JOptionPane.showMessageDialog(null, vacinaController.cadastrarVacina(vacina));
				
				limparTela();
				
			}
		});
		btnCadastrar.setBounds(299, 495, 109, 36);
		getContentPane().add(btnCadastrar);
		
		txtNomePesquisador = new JTextField();
		txtNomePesquisador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNomePesquisador.setBounds(224, 213, 250, 30);
		getContentPane().add(txtNomePesquisador);
		txtNomePesquisador.setColumns(10);
		
	}

	protected void limparTela() {
		txtNomePesquisador.setText("");
		dataInicio.setDate(null);
		txtPais.setText("");
		rbtnGroupEstagio.clearSelection();
	}
}
