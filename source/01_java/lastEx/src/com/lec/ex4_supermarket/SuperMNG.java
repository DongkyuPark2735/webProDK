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
	// 화면구현
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
		// 컴포넌트 객체 생성
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		conteniner = getContentPane(); // 컨테이너 디폴트 border
		conteniner.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel(); // 패널 디폴트 flower
		txtCld = new JTextField(20);
		txtCTel = new JTextField(20);
		txtCname = new JTextField(20);
		txtCpoint = new JTextField(20);
		txtCAmount = new JTextField(20);

		levelNames = cdao.getLevelNames();
		comLevelName = new JComboBox<String>(levelNames);

		btnCldSearch = new JButton("아이디 검색");
		btnCTelSearch = new JButton("연락처 4자리(FULL) 검색");
		btnCnameSearch = new JButton("고객 이름 검색");
		btnBuyWithPoint = new JButton("포인트로 구매");

		btnBuy = new JButton("물품 구매");
		btnLevelNameOutput = new JButton("등급별 출력");
		btnAllOutput = new JButton("전체 출력");
		btnInsert = new JButton("회원 가입");
		btnCTelUpdate = new JButton("번호 수정");
		btnDelete = new JButton("회원 탈퇴");
		btnExit = new JButton("나가기");

		txtPool = new JTextArea(6, 70);
		scrollPane = new JScrollPane(txtPool);

		// 컨테이너에 컴포넌트 add
		jpup.add(new JLabel("아 이 디", (int) CENTER_ALIGNMENT));
		jpup.add(txtCld);
		jpup.add(btnCldSearch);

		jpup.add(new JLabel("고객전화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCTel);
		jpup.add(btnCTelSearch);

		jpup.add(new JLabel("고객이름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);

		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuyWithPoint);

		jpup.add(new JLabel("구매금액", (int) CENTER_ALIGNMENT));
		jpup.add(txtCAmount);
		jpup.add(new JLabel());// 5행 3열엔 빈 라벨 추가

		jpup.add(new JLabel("고객등급", (int) CENTER_ALIGNMENT));
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
		txtPool.setText("\t---고객 검색 후 구매하세요---");

		// 이벤트추가
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
		if (e.getSource() == btnCldSearch) { // 아이디 검색
			int cid;
			txtCTel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			comLevelName.setSelectedIndex(0);
			txtCAmount.setText("");
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
			} catch (Exception e2) {
				// cid입력란 외에는 기본적으로 비워놓고 로직수행

				txtPool.setText("유효하지않은 고객 id입니다");
				return;
			}
			CustomerDTO customer = cdao.cIdGetCustomer(cid);
			if (customer != null) {
				txtCTel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				comLevelName.setSelectedItem(customer.getLevelName());
				txtCAmount.setText(""); // 물품구매액 넣을 예정
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음 등급까지 요구 금액\n");
				txtPool.append("──────────────────────────────────────────────────────────────\n");
				txtPool.append(customer.toString());
			} else {
				txtCTel.setText("");
				txtCname.setText("");
				txtCpoint.setText("");
				comLevelName.setSelectedIndex(0);
				txtCAmount.setText(""); // 물품구매액 넣을 예정
				txtPool.setText("검색되지않은 id입니다.");
			}
		} else if (e.getSource() == btnCTelSearch) {// 연락처 4자리 검색
			txtCld.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCTel.getText().trim();
			if (ctel.length() < 4) {
				txtPool.setText("전화번호 4자리 이상 입력하세요");
				return;
			}

			ArrayList<CustomerDTO> customer = cdao.cTelGetCustomer(ctel);
			if (customer.size() != 0) {
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음 등급까지 요구 금액\n");
				txtPool.append("──────────────────────────────────────────────────────────────\n");
				for (CustomerDTO c : customer) {
					txtCld.setText(String.valueOf(c.getCid()));
					txtCname.setText(c.getCname());
					txtCTel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCAmount.setText(""); // 물품구매액 넣을 예정
					comLevelName.setSelectedItem(c.getLevelName());
					txtPool.append(c.toString() + "\n");
				}
			} else {
				txtPool.setText("해당 전화번호의 고객이 없습니다.");
			}
		} else if (e.getSource() == btnCnameSearch) {// 고객 이름 검색
			txtCld.setText("");
			txtCTel.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			String cname = txtCname.getText().trim();
			if (cname.length() < 2) {
				txtPool.setText("이름을 2글자 이상 입력하세요");
				return;
			}

			ArrayList<CustomerDTO> customer = cdao.cNameGetCustomer(cname);
			if (customer.size() != 0) {
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음 등급까지 요구 금액\n");
				txtPool.append("──────────────────────────────────────────────────────────────\n");
				for (CustomerDTO c : customer) {
					txtCld.setText(String.valueOf(c.getCid()));
					txtCTel.setText(c.getCtel());
					txtCpoint.setText(String.valueOf(c.getCpoint()));
					txtCAmount.setText(""); // 물품구매액 넣을 예정
					comLevelName.setSelectedItem(c.getLevelName());
					txtPool.append(c.toString() + "\n");
				}
			} else {
				txtPool.setText("해당 이름의 고객이 없습니다.");
			}
		} else if (e.getSource() == btnBuyWithPoint) {// 포인트 사용
			int cid, cpoint, camount;
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
				if (cpoint < camount) {
					txtPool.setText("포인트가 부족하여 포인트 구매가 불가합니다.");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객id와 point를 입력하세요.");
				return;
			}

			int result = cdao.buyWithPoint(cid, camount);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("포인트 구매 성공");
				txtCpoint.setText(String.valueOf(cpoint - camount));//
				txtCAmount.setText("");
			} else {
				txtPool.setText("고객 id가 유효하지 않습니다. 고객 검색 후 구매해 주세요");
			}

		} else if (e.getSource() == btnBuy) {// 물품구매
			int cid, camount, cpoint;
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
				cpoint = Integer.parseInt(txtCpoint.getText().trim());
				camount = Integer.parseInt(txtCAmount.getText().trim());
			} catch (NumberFormatException e2) {
				txtPool.setText("유효한 고객 id로 검색후, 구매금액을 입력하시고 구매하세요");
				return;
			}
			int result = cdao.buy(cid, camount);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("물품 구매 완료");
				txtCpoint.setText(String.valueOf(cpoint + (int) (camount * 0.05)));
				txtCAmount.setText("");
			} else {
				txtPool.setText("고객 아이디가 유효하지 않습니다. 고객 검색후 구매하세요");
			}

		} else if (e.getSource() == btnLevelNameOutput) {// 등급별 고객 출력
			txtCname.setText("");
			txtCld.setText("");
			txtCTel.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");

			String levelname = comLevelName.getSelectedItem().toString();// 자료형 무엇???
			if (levelname.length() == 0) {
				txtPool.setText("등급을 선택하세요");
				return;
			}
			ArrayList<CustomerDTO> customer = cdao.levelNameGetCustomer(levelname);
			if (customer.size() != 0) {
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음 등급까지 요구 금액\n");
				txtPool.append("──────────────────────────────────────────────────────────────\n");
				for (CustomerDTO c : customer) {
					txtPool.append(c.toString() + "\n");
				}
				txtPool.append("총" + customer.size() + "명");
			} else {
				txtPool.setText("해당 레벨의 고객이 없습니다.");
			}
		} else if (e.getSource() == btnAllOutput) {// 전체 출력
			// 모든 입력 컴포넌트를 비워놓고 로직수행
			txtCname.setText("");
			txtCld.setText("");
			txtCTel.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			ArrayList<CustomerDTO> customer = cdao.getCustomers();
			if (customer.size() != 0) {
				txtPool.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t다음 등급까지 요구 금액\n");
				txtPool.append("──────────────────────────────────────────────────────────────\n");
				for (CustomerDTO c : customer) {
					txtPool.append(c.toString() + "\n");
				}
				txtPool.append("총" + customer.size() + "명");
			} else {
				txtPool.setText("등록된 고객이 없습니다.");
			}
		} else if (e.getSource() == btnInsert) {// 회원가입
			// ctel, cname 입력란을 제외하고 빈스트링 및 초기화 값으로 정리
			txtCld.setText("");
			txtCpoint.setText("1000");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("BRONZE");
			String ctel = txtCTel.getText().trim();
			String cname = txtCname.getText().trim();
			if (ctel.length() < 8 || cname.length() < 2) {
				txtPool.setText("전화번호와 이름은 필수 입력사항입니다.");
				return;
			}
			int result = cdao.insertCustomer(ctel, cname);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("회원가입 감사합니다. 포인트 1000점이 적립되었습니다.");
			}
		} else if (e.getSource() == btnCTelUpdate) {// 고객 번호 수정
			// ctel, cid
			int cid;
			String ctel;
			try {
				cid = Integer.parseInt(txtCld.getText().trim());
				ctel = txtCTel.getText().trim();
				if (ctel.length() < 8) {
					txtPool.setText("변경할 전화번호를 확인해 주세요");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객id를 검색하세요");
				return;
			}
			int result = cdao.updateCustomer(cid, ctel);
			if (result == CustomerDAO.SUCCESS) {
				txtPool.setText("전화번호가 수정되었습니다.");
			} else {
				txtPool.setText("유효한 고객id를 검색하세요");
			}
		} else if (e.getSource() == btnDelete) {// 회원탈퇴
			//ctel 입력란 외에는 기본으로 비워놓고 로직수행
			txtCname.setText("");
			txtCld.setText("");
			txtCpoint.setText("");
			txtCAmount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCTel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("전화번호를 입력 후 회원탈퇴 해주세요");
				return;
			}
			int result = cdao.deleteCustomer(ctel);
			if(result == CustomerDAO.SUCCESS) {
				txtPool.setText("회원탈퇴 완료");
				txtCTel.setText("");
			}else {
				txtPool.setText("등록된 전화번호가 없어서 탈퇴가 불가합니다.");
			}
		} else if (e.getSource() == btnExit) {// 나가기
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new SuperMNG("슈퍼마켓 관리");
	}

}



