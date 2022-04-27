package com.lec.ex4_supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SuperMNG extends JFrame implements ActionListener {
	// dao
	private CustomerDAO cdao = CustomerDAO.getInstance();
	// ȭ�鱸��
	private Container conteniner;
	private JPanel jpup, jpbtn;
	private JTextField txtCld, txtCTel, txtCname, txtCpoint, txtCAmount;
	private Vector<String> levelNames;
	private JComboBox<String> comLevelName;
	private JButton btnCldSearch, btnCTelSearch, btnCnameSearch, btnBuyWithPoint;
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCTelUpdate, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	public SuperMNG(String title) {
		// ������Ʈ ��ü ����
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		conteniner = getContentPane(); // �����̳� ����Ʈ border
		conteniner.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel(); // �г� ����Ʈ flower
		txtCld = new JTextField(20);
		txtCTel = new JTextField(20);
		txtCname = new JTextField(20);
		txtCpoint = new JTextField(20);
		txtCAmount = new JTextField(20);

		levelNames = cdao.getLevelNames();
		comLevelName = new JComboBox<String>(levelNames);

		btnCldSearch = new JButton("���̵� �˻�");
		btnCTelSearch = new JButton("����ó 4�ڸ�(FULL) �˻�");
		btnCnameSearch = new JButton("�� �̸� �˻�");
		btnBuyWithPoint = new JButton("����Ʈ�� ����");

		btnBuy = new JButton("��ǰ ����");
		btnLevelNameOutput = new JButton("��޺� ���");
		btnAllOutput = new JButton("��ü ���");
		btnInsert = new JButton("ȸ�� ����");
		btnCTelUpdate = new JButton("��ȣ ����");
		btnDelete = new JButton("ȸ�� Ż��");
		btnExit = new JButton("������");

		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);

		// �����̳ʿ� ������Ʈ add
		jpup.add(new JLabel("�� �� ��", (int) CENTER_ALIGNMENT));
		jpup.add(txtCld);
		jpup.add(btnCldSearch);

		jpup.add(new JLabel("����ȭ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);

		jpup.add(new JLabel("���̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);

		jpup.add(new JLabel("�� �� Ʈ", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);

		jpup.add(new JLabel("���űݾ�", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel());// 5�� 3���� �� �� �߰�

		jpup.add(new JLabel("�����", (int) CENTER_ALIGNMENT));
		jpup.add(comLevelName);

		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCTelUpdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);

		conteniner.add(jpup);
		conteniner.add(jpbtn);
		conteniner.add(scrollPane);

		setVisible(true);
		setSize(new Dimension(800, 400));
		setLocation(200, 100);
		txtPool.setText("\t---�� �˻� �� �����ϼ���---");

		// �̺�Ʈ�߰�
		btnCldSearch.addActionListener(this);
		btnCTelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuyWithPoint.addActionListener(this);

		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCTelUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCldSearch) { // ���̵� �˻�
			int cid;
			txtCTel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			comLevelName.setSelectedIndex(0);
			txtCAmount.setText("");
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
			} catch (Exception e2) {
				// cid�Է¶� �ܿ��� �⺻������ ������� ��������

				txtPool.setText("��ȿ�������� �� id�Դϴ�");
				return;
			}
			CustomerDTO customer = cdao.cIdGetCustomer(cid);
			if (customer != null) {
				txtCTel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				comLevelName.setSelectedItem(customer.getLevelName());
				txtCAmount.setText(""); // ��ǰ���ž� ���� ����
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���� ��ޱ��� �䱸 �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������������\n");
				txtPool.append(customer.toString());
			} else {
				txtCTel.setText("");
				txtCname.setText("");
				txtCpoint.setText("");
				comLevelName.setSelectedIndex(0);
				txtCAmount.setText(""); // ��ǰ���ž� ���� ����
				txtPool.setText("�˻��������� id�Դϴ�.");
			}
		} else if (e.getSource() == btnCTelSearch) {// ����ó 4�ڸ� �˻�
			txtCld.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCTel.getText().trim();
			if (ctel.length() < 4) {
				txtPool.setText("��ȭ��ȣ 4�ڸ� �̻� �Է��ϼ���");
				return;
			}

			ArrayList<CustomerDTO> customer = cdao.cTelGetCustomer(ctel);
			if (customer.size() != 0) {
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���� ��ޱ��� �䱸 �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDTO c : customer) {
					txtCld.setText(String.valueOf(c.getCid()));
					txtCname.setText(c.getCname());
					txtCTel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCAmount.setText(""); // ��ǰ���ž� ���� ����
					comLevelName.setSelectedItem(c.getLevelName());
					txtPool.append(c.toString() + "\n");
				}
			} else {
				txtPool.setText("�ش� ��ȭ��ȣ�� ���� �����ϴ�.");
			}
		} else if (e.getSource() == btnCnameSearch) {// �� �̸� �˻�
			txtCld.setText("");
			txtCTel.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			String cname = txtCname.getText().trim();
			if (cname.length() < 2) {
				txtPool.setText("�̸��� 2���� �̻� �Է��ϼ���");
				return;
			}

			ArrayList<CustomerDTO> customer = cdao.cNameGetCustomer(cname);
			if (customer.size() != 0) {
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���� ��ޱ��� �䱸 �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDTO c : customer) {
					txtCld.setText(String.valueOf(c.getCid()));
					txtCTel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCAmount.setText(""); // ��ǰ���ž� ���� ����
					comLevelName.setSelectedItem(c.getLevelName());
					txtPool.append(c.toString() + "\n");
				}
			} else {
				txtPool.setText("�ش� �̸��� ���� �����ϴ�.");
			}
		} else if (e.getSource() == btnBuyWithPoint) {// ����Ʈ ���
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
				if (cpoint < camount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ ���Ű� �Ұ��մϴ�.");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��id�� point�� �Է��ϼ���.");
				return;
			}

			int result = cdao.buyWithPoint(cid, camount);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("����Ʈ ���� ����");
				txtCpoint.setText(String.valueOf(cpoint - camount));//
				txtCAmount.setText("");
			} else {
				txtPool.setText("�� id�� ��ȿ���� �ʽ��ϴ�. �� �˻� �� ������ �ּ���");
			}

		} else if (e.getSource() == btnBuy) {// ��ǰ����
			int cid, camount, cpoint;
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
			} catch (NumberFormatException e2) {
				txtPool.setText("��ȿ�� �� id�� �˻���, ���űݾ��� �Է��Ͻð� �����ϼ���");
				return;
			}
			int result = cdao.buy(cid, camount);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("��ǰ ���� �Ϸ�");
				txtCpoint.setText(String.valueOf(cpoint + (int) (camount * 0.05)));
				txtCAmount.setText("");
			} else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. �� �˻��� �����ϼ���");
			}

		} else if (e.getSource() == btnLevelNameOutput) {// ��޺� �� ���
			txtCname.setText("");
			txtCld.setText("");
			txtCTel.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");

			String levelname = comLevelName.getSelectedItem().toString();// �ڷ��� ����???
			if (levelname.length() == 0) {
				txtPool.setText("����� �����ϼ���");
				return;
			}
			ArrayList<CustomerDTO> customer = cdao.levelNameGetCustomer(levelname);
			if (customer.size() != 0) {
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���� ��ޱ��� �䱸 �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDTO c : customer) {
					txtPool.append(c.toString() + "\n");
				}
				txtPool.append("��" + customer.size() + "��");
			} else {
				txtPool.setText("�ش� ������ ���� �����ϴ�.");
			}
		} else if (e.getSource() == btnAllOutput) {// ��ü ���
			// ��� �Է� ������Ʈ�� ������� ��������
			txtCname.setText("");
			txtCld.setText("");
			txtCTel.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			ArrayList<CustomerDTO> customer = cdao.getCustomers();
			if (customer.size() != 0) {
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t���� ��ޱ��� �䱸 �ݾ�\n");
				txtPool.append("����������������������������������������������������������������������������������������������������������������������������\n");
				for (CustomerDTO c : customer) {
					txtPool.append(c.toString() + "\n");
				}
				txtPool.append("��" + customer.size() + "��");
			} else {
				txtPool.setText("��ϵ� ���� �����ϴ�.");
			}
		} else if (e.getSource() == btnInsert) {// ȸ������
			// ctel, cname �Է¶��� �����ϰ� ��Ʈ�� �� �ʱ�ȭ ������ ����
			txtCld.setText("");
			txtCpoint.setText("1000");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("BRONZE");
			String ctel = txtCTel.getText().trim();
			String cname = txtCname.getText().trim();
			if (ctel.length() < 8 || cname.length() < 2) {
				txtPool.setText("��ȭ��ȣ�� �̸��� �ʼ� �Է»����Դϴ�.");
				return;
			}
			int result = cdao.insertCustomer(ctel, cname);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� �����Ǿ����ϴ�.");
			}
		} else if (e.getSource() == btnCTelUpdate) {// �� ��ȣ ����
			// ctel, cid
			int cid;
			String ctel;
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
				ctel = txtCTel.getText().trim();
				if (ctel.length() < 8) {
					txtPool.setText("������ ��ȭ��ȣ�� Ȯ���� �ּ���");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��id�� �˻��ϼ���");
				return;
			}
			int result = cdao.updateCustomer(cid, ctel);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("��ȭ��ȣ�� �����Ǿ����ϴ�.");
			} else {
				txtPool.setText("��ȿ�� ��id�� �˻��ϼ���");
			}
		} else if (e.getSource() == btnDelete) {// ȸ��Ż��
			//ctel �Է¶� �ܿ��� �⺻���� ������� ��������
			txtCname.setText("");
			txtCld.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCTel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż�� ���ּ���");
				return;
			}
			int result = cdao.deleteCustomer(ctel);
			if(result == CustomerDAO.SUCCESS) {
				txtPool.setText("ȸ��Ż�� �Ϸ�");
				txtCTel.setText("");
			}else {
				txtPool.setText("��ϵ� ��ȭ��ȣ�� ��� Ż�� �Ұ��մϴ�.");
			}
		} else if (e.getSource() == btnExit) {// ������
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new SuperMNG("���۸��� ����");
	}

}



