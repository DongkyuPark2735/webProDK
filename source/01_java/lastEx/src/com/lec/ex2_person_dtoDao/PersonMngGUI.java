package com.lec.ex2_person_dtoDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PersonMngGUI extends JFrame implements ActionListener {
	// ȭ�鿡 �� ������Ʈ
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comjob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	// DB����
	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;

	public PersonMngGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // xŬ���� ����
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());// �⺻���̾ƿ��� borderlayout
		jpup = new JPanel(new GridLayout(5, 2));// �г��� �⺻ ���̿��� flowlayout
		jpbtn = new JPanel();
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comjob = new JComboBox<String>(jnames); // ������ ����� �޺��ڽ���
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);

		ImageIcon icon1 = new ImageIcon("icon/join.png");
		btnInput = new JButton("�Է�", icon1);
		ImageIcon icon2 = new ImageIcon("icon/search.png");
		btnSearch = new JButton("������ȸ", icon2);
		ImageIcon icon3 = new ImageIcon("icon/output.png");
		btnOutput = new JButton("��ü���", icon3);
		ImageIcon icon4 = new ImageIcon("icon/exit.png");
		btnExit = new JButton("����", icon4);

		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));

		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);
		// ������ ������Ʈ ȭ�� �߰�
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comjob);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);
		jpbtn.add(btnInput); // jpbtn : FlowLayout
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup); // comtenPane : FlowLayout
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInput) {	// txtName, comJob, txtKor, txtEng, txtMat���� ���� db��
			String pname = txtName.getText();
			String jname = comjob.getSelectedItem().toString();
//			int jno = comjob.getSelectedIndex()*10;
			String korStr = txtKor.getText();
			String engStr = txtEng.getText();
			String matStr = txtMat.getText();
			if(pname.equals("")||jname.equals("")||korStr.equals("")||engStr.equals("")||matStr.equals("")) {
				txtPool.setText("�̸�, ����, ��, ��, �� ��� �Է��ϼž� �Է� �����մϴ�.");
				return;
			}
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(pname, kor, eng, mat, jname);
			int result = dao.insertPerson(newPerson);
			if(result == PersonDao.SUCCESS) {//�Է¼���
				txtPool.setText(pname+"�� �Է¼���");
				txtName.setText("");
				comjob.setSelectedIndex(0); // �޺��ڽ��� 0��° ����
				comjob.setSelectedItem(""); // �޺��ڽ��� ""�� �ִ� ������ ����
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}
			
		}else if(e.getSource() == btnSearch) { // comjob�� ���õ� ������ȸ ����� txtPool
			String jname = comjob.getSelectedItem().toString();
			if(jname.equals("")) {
				txtPool.setText("���� ������ ������ȸ�ϼ���");
				return;
			}
			person = dao.selectJname(jname);
			if(person.size() != 0) {
				txtPool.setText("rank\t�̸�\t������\t����\t����\t����\t�հ�\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("�ش� �������� �ο��� �����ϴ�.");;
			}
		}else if(e.getSource() == btnOutput) { //��ü ��ȸ ����� txtPool�� 
			person = dao.selectALL();
			if(person.size() != 0) {
				txtPool.setText("rank\t�̸�\t������\t����\t����\t����\t�հ�\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			}else {
				txtPool.setText("��ϵ� �ο��� �����ϴ�.");
			}
		}else if(e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new PersonMngGUI("������ ��������");
	}
}




