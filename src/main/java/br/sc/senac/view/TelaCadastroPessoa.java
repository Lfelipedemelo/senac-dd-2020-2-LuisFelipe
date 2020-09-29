package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import br.sc.senac.controller.PacienteController;
import br.sc.senac.controller.PesquisadorController;
import br.sc.senac.model.vo.PacienteVO;
import br.sc.senac.model.vo.PesquisadorVO;

import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtInstituicao;
	private JCheckBox chckbxPesquisador;
	private JLabel lblInstituicao;
	private String cpf;
	private JFormattedTextField txtCpf;
	private JRadioButton rdbtnVoluntarioNao;
	private JRadioButton rdbtnVoluntarioSim;
	private JLabel lblVoluntario;
	private DatePicker dataInicio;
	private boolean eVoluntario;
	private String sexoSelecionado;
	private ButtonGroup rdbtnGroupSexo;
	private ButtonGroup rdbtnGroupVoluntario;
	
	public static final boolean VOLUNTARIO_SIM = true;
	public static final boolean VOLUNTARIO_NAO = false;
	public static final String	SEXO_MASCULINO = "Masculino";
	public static final String SEXO_FEMININO = "Feminino";
	
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
					TelaCadastroPessoa frame = new TelaCadastroPessoa();
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
	public TelaCadastroPessoa() {
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(48, 71, 94));
		panel.setBounds(0, 0, 214, 571);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(10, 162, 193, 221);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel iconCadastroUsuario =new JLabel("");
		iconCadastroUsuario.setBackground(SystemColor.desktop);
		iconCadastroUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		iconCadastroUsuario.setBounds(10, 11, 173, 199);
		panel_2.add(iconCadastroUsuario);
		iconCadastroUsuario.setIcon(new ImageIcon(TelaCadastroPessoa.class.getResource("/Imagens/paciente.png")));
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(224, 100, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSobrenome.setBounds(224, 166, 83, 14);
		contentPane.add(lblSobrenome);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSexo.setBounds(224, 367, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCpf.setBounds(224, 305, 46, 14);
		contentPane.add(lblCpf);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(126, 138, 151));
		panel_1.setBounds(214, 0, 270, 89);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCadastroDePessoa = new JLabel("Cadastro de Pessoa");
		lblCadastroDePessoa.setBounds(10, 11, 250, 67);
		lblCadastroDePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDePessoa.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCadastroDePessoa.setForeground(Color.WHITE);
		panel_1.add(lblCadastroDePessoa);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(224, 125, 250, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSobrenome.setBounds(224, 191, 250, 30);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		final JRadioButton rdbtnSexoMasculino = new JRadioButton("Masculino");
		rdbtnSexoMasculino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sexoSelecionado = SEXO_MASCULINO;
			}
		});
		rdbtnSexoMasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnSexoMasculino.setSelected(true);
		rdbtnSexoMasculino.setBounds(220, 388, 83, 23);
		contentPane.add(rdbtnSexoMasculino);
		
		JRadioButton rdbtnSexoFeminino = new JRadioButton("Feminino");
		rdbtnSexoFeminino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sexoSelecionado = SEXO_FEMININO;
			}
		});
		rdbtnSexoFeminino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnSexoFeminino.setBounds(305, 388, 79, 23);
		contentPane.add(rdbtnSexoFeminino);
		
		chckbxPesquisador = new JCheckBox("Pesquisador");
		chckbxPesquisador.setHorizontalTextPosition(SwingConstants.LEFT);
		chckbxPesquisador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxPesquisador.isSelected()) {
					txtInstituicao.setEnabled(true);
					lblInstituicao.setEnabled(true);
					rdbtnVoluntarioNao.setEnabled(false);
					rdbtnVoluntarioSim.setEnabled(false);
					lblVoluntario.setEnabled(false);
				} else {
					txtInstituicao.setEnabled(false);
					lblInstituicao.setEnabled(false);
					rdbtnVoluntarioNao.setEnabled(true);
					rdbtnVoluntarioSim.setEnabled(true);
					lblVoluntario.setEnabled(true);
				}
			}
		});
		chckbxPesquisador.setToolTipText("");
		chckbxPesquisador.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		chckbxPesquisador.setBounds(220, 414, 157, 23);
		contentPane.add(chckbxPesquisador);
		
		lblInstituicao = new JLabel("Institui\u00E7\u00E3o");
		lblInstituicao.setEnabled(false);
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInstituicao.setBounds(224, 444, 97, 30);
		contentPane.add(lblInstituicao);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setEnabled(false);
		txtInstituicao.setBounds(224, 473, 250, 30);
		contentPane.add(txtInstituicao);
		txtInstituicao.setColumns(10);
		
		lblVoluntario = new JLabel("Voluntário");
		lblVoluntario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVoluntario.setBounds(373, 305, 101, 14);
		contentPane.add(lblVoluntario);
		
		rdbtnVoluntarioSim = new JRadioButton("Sim");
		rdbtnVoluntarioSim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				eVoluntario = VOLUNTARIO_SIM;
			}
		});
		rdbtnVoluntarioSim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnVoluntarioSim.setBounds(361, 326, 52, 30);
		contentPane.add(rdbtnVoluntarioSim);
		
		rdbtnVoluntarioNao = new JRadioButton("Não");
		rdbtnVoluntarioNao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eVoluntario = VOLUNTARIO_NAO;
			}
		});
		rdbtnVoluntarioNao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnVoluntarioNao.setBounds(415, 326, 53, 30);
		contentPane.add(rdbtnVoluntarioNao);
		
		DatePickerSettings dateSettings = new DatePickerSettings();
		dateSettings.setAllowKeyboardEditing(false);
		dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
		dateSettings.setFontValidDate(new Font("Tahoma", Font.PLAIN, 17));
		
		dataInicio = new DatePicker(dateSettings);
		dataInicio.setBounds(224, 258, 250, 30);
		contentPane.add(dataInicio);
		dataInicio.getComponentDateTextField().setFont(new Font("Tahoma", Font.PLAIN, 11));
		JButton datePickerButton = dataInicio.getComponentToggleCalendarButton();
		datePickerButton.setText("");
		datePickerButton.setIcon(new ImageIcon(TelaCadastroVacina.class.getResource("/Imagens/calendario.png")));
		
		rdbtnGroupSexo = new ButtonGroup();
		rdbtnGroupSexo.add(rdbtnSexoMasculino);
		rdbtnGroupSexo.add(rdbtnSexoFeminino);
		
		rdbtnGroupVoluntario = new ButtonGroup();
		rdbtnGroupVoluntario.add(rdbtnVoluntarioSim);
		rdbtnGroupVoluntario.add(rdbtnVoluntarioNao);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxPesquisador.isSelected()) {
					PesquisadorVO pesquisador = new PesquisadorVO();
					pesquisador.setNome(txtNome.getText() + " " + txtSobrenome.getText());
					pesquisador.setSexo(sexoSelecionado);
					pesquisador.setDataNascimento(dataInicio.getDate());
					pesquisador.setCpf(txtCpf.getText().replace(".", "").replace("-", ""));
					pesquisador.setInstituicao(txtInstituicao.getText());
					
					PesquisadorController pesquisadorController = new PesquisadorController();
					JOptionPane.showMessageDialog(null, pesquisadorController.cadastrarPesquisador(pesquisador));
					
					limparTela();
				} else {				
					PacienteVO paciente = new PacienteVO();
					paciente.setNome(txtNome.getText() + " " + txtSobrenome.getText());
					paciente.setSexo(sexoSelecionado);
					paciente.setDataNascimento(dataInicio.getDate());
					paciente.setCpf(txtCpf.getText().replace(".", "").replace("-", ""));
					paciente.setVoluntario(eVoluntario);
					
					PacienteController pacienteController = new PacienteController();
					JOptionPane.showMessageDialog(null, pacienteController.cadastrarPaciente(paciente));
					
					limparTela();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(285, 514, 109, 36);
		contentPane.add(btnNewButton);
		
		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setText("");
			txtCpf.setBounds(224, 326, 92, 30);
			contentPane.add(txtCpf);
			
			JLabel lblNewLabel = new JLabel("Data de Nascimento");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblNewLabel.setBounds(224, 233, 250, 14);
			contentPane.add(lblNewLabel);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir cpf\nErro: " + e.getMessage());
		}

	}

	protected void limparTela() {
		txtCpf.setText("");
		txtInstituicao.setText("");
		txtNome.setText("");
		txtSobrenome.setText("");
		dataInicio.clear();
		rdbtnGroupSexo.clearSelection();
		rdbtnGroupVoluntario.clearSelection();
		
	}
}
