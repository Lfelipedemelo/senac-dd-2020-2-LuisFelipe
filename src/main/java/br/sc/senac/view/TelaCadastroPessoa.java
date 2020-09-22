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
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;

public class TelaCadastroPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtInstituicao;
	private JCheckBox chckbxPesquisador;
	private JLabel lblInstituicao;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		lblSexo.setBounds(224, 232, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCpf.setBounds(224, 285, 46, 14);
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
		
		JRadioButton rdbtnSexoMasculino = new JRadioButton("Masculino");
		rdbtnSexoMasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnSexoMasculino.setSelected(true);
		rdbtnSexoMasculino.setBounds(224, 253, 83, 23);
		contentPane.add(rdbtnSexoMasculino);
		
		JRadioButton rdbtnSexoFeminino = new JRadioButton("Feminino");
		rdbtnSexoFeminino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnSexoFeminino.setBounds(335, 253, 79, 23);
		contentPane.add(rdbtnSexoFeminino);
		
		chckbxPesquisador = new JCheckBox("Pesquisador");
		chckbxPesquisador.setHorizontalTextPosition(SwingConstants.LEFT);
		chckbxPesquisador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxPesquisador.isSelected()) {
					txtInstituicao.setEnabled(true);
					lblInstituicao.setEnabled(true);
				} else {
					txtInstituicao.setEnabled(false);
					lblInstituicao.setEnabled(false);
				}
			}
		});
		chckbxPesquisador.setToolTipText("");
		chckbxPesquisador.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxPesquisador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		chckbxPesquisador.setBounds(220, 410, 121, 23);
		contentPane.add(chckbxPesquisador);
		
		lblInstituicao = new JLabel("Instituição");
		lblInstituicao.setEnabled(false);
		lblInstituicao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInstituicao.setBounds(224, 440, 83, 30);
		contentPane.add(lblInstituicao);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setEnabled(false);
		txtInstituicao.setBounds(224, 469, 250, 30);
		contentPane.add(txtInstituicao);
		txtInstituicao.setColumns(10);
		
		JLabel lblVoluntario = new JLabel("Voluntário");
		lblVoluntario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVoluntario.setBounds(224, 351, 101, 14);
		contentPane.add(lblVoluntario);
		
		JRadioButton rdbtnVoluntarioSim = new JRadioButton("Sim");
		rdbtnVoluntarioSim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnVoluntarioSim.setBounds(224, 374, 52, 23);
		contentPane.add(rdbtnVoluntarioSim);
		
		JRadioButton rdbtnVoluntarioNao = new JRadioButton("N\u00E3o");
		rdbtnVoluntarioNao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnVoluntarioNao.setBounds(284, 374, 53, 23);
		contentPane.add(rdbtnVoluntarioNao);
		
		ButtonGroup rdbtnGroupSexo = new ButtonGroup();
		rdbtnGroupSexo.add(rdbtnSexoMasculino);
		rdbtnGroupSexo.add(rdbtnSexoFeminino);
		
		ButtonGroup rdbtnGroupVoluntario = new ButtonGroup();
		rdbtnGroupVoluntario.add(rdbtnVoluntarioSim);
		rdbtnGroupVoluntario.add(rdbtnVoluntarioNao);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(293, 518, 109, 36);
		contentPane.add(btnNewButton);
		
		MaskFormatter mascaraCpf;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setText("");
			txtCpf.setBounds(224, 310, 92, 30);
			contentPane.add(txtCpf);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir cpf\nErro: " + e.getMessage());
		}

	}
}
