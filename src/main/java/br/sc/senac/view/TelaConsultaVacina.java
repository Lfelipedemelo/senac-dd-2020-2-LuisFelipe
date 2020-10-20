package br.sc.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.sc.senac.controller.VacinaController;
import br.sc.senac.model.dao.VacinaDAO;
import br.sc.senac.model.vo.VacinaVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TelaConsultaVacina extends JFrame {

	private JPanel contentPane;
	private JTextField txtPais;
	private JTextField txtPesquisador;
	private JTable tblVacinas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConsultaVacina frame = new TelaConsultaVacina();
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
	public TelaConsultaVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][]", "[][][][grow][]"));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaConsultaVacina.class.getResource("/Imagens/consulta.png")));
		contentPane.add(lblNewLabel_1, "cell 1 0");
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		contentPane.add(lblPais, "flowx,cell 1 1,alignx left");
		
		txtPais = new JTextField();
		txtPais.setToolTipText("test");
		contentPane.add(txtPais, "cell 1 1,growx");
		txtPais.setColumns(10);
		
		JLabel lblPesquisador = new JLabel("Pesquisador");
		contentPane.add(lblPesquisador, "flowx,cell 1 1,alignx left");
		
		txtPesquisador = new JTextField();
		contentPane.add(txtPesquisador, "cell 1 1,growx");
		txtPesquisador.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarVacinas();
			}
		});
		contentPane.add(btnConsultar, "flowx,cell 1 2,growx");
		
		tblVacinas = new JTable();
		tblVacinas.setBorder(new LineBorder(new Color(0, 0, 0)));
		tblVacinas.setModel(new DefaultTableModel(
			new Object[][] {
				{"#", "Pa\u00EDs", "Estagio", "Pesquisador", "Data In\u00EDcio"},
			},
			new String[] {
				"#", "Pa\u00EDs", "Estagio", "Pesquisador", "Data Inicio"
			}
		));
		contentPane.add(tblVacinas, "flowx,cell 1 3,grow");
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPais.setText(null);
				txtPesquisador.setText(null);
			}
		});
		contentPane.add(btnLimpar, "cell 1 2,growx");
	}
	
	protected void consultarVacinas() {

		VacinaDAO vacinaDAO = new VacinaDAO();
		List<VacinaVO> vacinas = new ArrayList<VacinaVO>();
		vacinas = vacinaDAO.pesquisarTodos();
		atualizarTabelaVacinas(vacinas);

	}

	protected void atualizarTabelaVacinas(List<VacinaVO> vacinas) {
		this.limparTabela();

		DefaultTableModel modelo = (DefaultTableModel) tblVacinas.getModel();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (VacinaVO vacina : vacinas) {
			String dataFormatada = vacina.getDtInicioPesquisa().format(formatter);

			String[] novaLinha = new String[] { 
					vacina.getIdVacina() + "", 
					vacina.getPais(), 
					vacina.getEstagio() + "",
					vacina.getPesquisador() + "", 
					dataFormatada 
			};
			modelo.addRow(novaLinha);
		}

	}

	private void limparTabela() {
		tblVacinas.setModel(new DefaultTableModel(
				new String[][] {
					{"#", "País", "Estagio", "Pesquisador", "Data Início"},
				},
				new String[] {
					"#", "País", "Estagio", "Pesquisador", "Data Início"
				}
			));
	}

}
