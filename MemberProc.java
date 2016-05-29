package dsada;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MemberProc extends JFrame implements ActionListener {
	
	JPanel p;
	JTextField tfId, tfName, tfAddr, tfEmail;
	JTextField tfTel1, tfTel2, tfTel3; //��ȭ
	JComboBox<String> cbJob; //����
	JPasswordField pfPwd; //��й�ȣ	
	JTextField tfYear, tfMonth, tfDate; //�������
	JRadioButton rbMan, rbWoman; //��, ��
	JButton btnInsert, btnCancel, btnUpdate,btnDelete; //����, ���, ���� , Ż�� ��ư
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	
	public MemberProc(){ //���Կ� ������
		createUI(); // UI�ۼ����ִ� �޼ҵ�

	}//������
	private void createUI(){
		this.setTitle("ȸ������");
		gb = new GridBagLayout();
		setLayout(gb);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
	
	//���̵�
	JLabel bId = new JLabel("���̵� : ");
	tfId = new JTextField(20);		
	//�׸���鿡 ���̱�
	gbAdd(bId, 0, 0, 1, 1);
	gbAdd(tfId, 1, 0, 3, 1);
	
	//��й�ȣ
	JLabel bPwd = new JLabel("��й�ȣ : ");
	pfPwd = new JPasswordField(20);
	gbAdd(bPwd, 0, 1, 1, 1);
	gbAdd(pfPwd, 1, 1, 3, 1);
	
	//�̸�
	JLabel bName = new JLabel("�̸� :");
	tfName = new JTextField(20);
	gbAdd(bName,0,2,1,1);
	gbAdd(tfName,1,2,3,1);
	
	//��ȭ
	JLabel bTel = new JLabel("��ȭ :");
	JPanel pTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	tfTel1 = new JTextField(6);		
	tfTel2 = new JTextField(6);		
	tfTel3 = new JTextField(6);
	pTel.add(tfTel1);
	pTel.add(new JLabel(" - "));
	pTel.add(tfTel2); 
	pTel.add(new JLabel(" - "));
	pTel.add(tfTel3); 
	gbAdd(bTel, 0, 3, 1,1);
	gbAdd(pTel, 1, 3, 3,1);
	
	//�ּ�
	JLabel bAddr = new JLabel("�ּ�: ");
	tfAddr = new JTextField(20);
	gbAdd(bAddr, 0,4,1,1);
	gbAdd(tfAddr, 1, 4, 3,1);
	
	//����
	JLabel bBirth= new JLabel("����: ");
	tfYear = new JTextField(6);
	tfMonth = new JTextField(6);
	tfDate = new JTextField(6);
	JPanel pBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
	pBirth.add(tfYear);
	pBirth.add(new JLabel("/"));
	pBirth.add(tfMonth);
	pBirth.add(new JLabel("/"));
	pBirth.add(tfDate);
	gbAdd(bBirth, 0,5,1,1);
	gbAdd(pBirth, 1, 5, 3,1);
	
	//����		
	JLabel bJob = new JLabel("���� : ");
	String[] arrJob = {"---", "�л�", "������", "�ֺ�"};
	cbJob = new JComboBox<String>(arrJob);
	JPanel pJob = new JPanel(new FlowLayout(FlowLayout.LEFT));
	pJob.add(cbJob);		
	gbAdd(bJob, 0,6,1,1);
	gbAdd(pJob,1,6,3,1);
	
	//����
	JLabel bGender = new JLabel("���� : ");
	JPanel pGender = new JPanel(new FlowLayout(FlowLayout.LEFT));
	rbMan = new JRadioButton("��",true);
	rbWoman = new JRadioButton("��",true);
	ButtonGroup group = new ButtonGroup();
	group.add(rbMan);
	group.add(rbWoman);
	pGender.add(rbMan);
	pGender.add(rbWoman);		
	gbAdd(bGender, 0,7,1,1);
	gbAdd(pGender,1,7,3,1);
	
	//�̸���
	JLabel bEmail = new JLabel("�̸��� : ");
	tfEmail = new JTextField(20);
	gbAdd(bEmail, 0,8,1,1);
	gbAdd(tfEmail,1,8,3,1);
	
	//��ư
	JPanel pButton = new JPanel();
	btnInsert = new JButton("����");
	btnCancel = new JButton("���");		
	pButton.add(btnInsert);
	pButton.add(btnCancel);		
	gbAdd(pButton, 0, 10, 4, 1);
	
	//��ư�� �����⸦ ������
	btnInsert.addActionListener(this);
	btnCancel.addActionListener(this);
	
	setSize(350,500);
	setVisible(true);
	//setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //���α׷�����
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //����â�� �ݴ´�.
}//createUI
	private void gbAdd(JComponent c, int x, int y, int w, int h){
	gbc.gridx = x;
	gbc.gridy = y;
	gbc.gridwidth = w;
	gbc.gridheight = h;
	gb.setConstraints(c, gbc);
	gbc.insets = new Insets(2, 2, 2, 2);
	add(c, gbc);
	}//gbAdd
	 
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnInsert){
			insertMember();	
			System.out.println("insertMember() ȣ�� ����");
		}else if(ae.getSource() == btnCancel){
			this.dispose(); //â�ݱ� (����â�� ����) 
			//system.exit(0)=> ���� ��� ��� â�� �� ���� 			
			}
		//jTable���� ���� �޼ҵ� ȣ��		
		}
		private void insertMember(){
			
			//ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
			MemberDTO dto = getViewData();
			MemberDAO dao = new MemberDAO();		
			boolean ok = dao.insertMember(dto);
			
			if(ok){
				JOptionPane.showMessageDialog(this, "������ �Ϸ�Ǿ����ϴ�.");
				dispose();
				
			}else{
				JOptionPane.showMessageDialog(this, "������ ���������� ó������ �ʾҽ��ϴ�.");
			}
			
		}//insertMember
		
		public MemberDTO getViewData(){
			
			//ȭ�鿡�� ����ڰ� �Է��� ������ ��´�.
			MemberDTO dto = new MemberDTO();
			String id = tfId.getText();
			String pwd = pfPwd.getText();
			String name = tfName.getText();
			String tel1 = tfTel1.getText();
			String tel2 = tfTel2.getText();
			String tel3 = tfTel3.getText();
			String tel = tel1+"-"+tel2+"-"+tel3;
			String addr = tfAddr.getText();
			String birth1 = tfYear.getText();
			String birth2 = tfMonth.getText();
			String birth3 = tfDate.getText();
			//String birth = birth1+"/"+birth2+"/"+birth3;
			String birth = birth1+birth2+birth3;
			String job = (String)cbJob.getSelectedItem();
			String gender = "";
			if(rbMan.isSelected()){
				gender = "M";
			}else if(rbWoman.isSelected()){
				gender = "W";
			}
			
			String email = tfEmail.getText();		
			//dto�� ��´�.
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setName(name);
			dto.setTel(tel);
			dto.setAddr(addr);
			dto.setBirth(birth);
			dto.setJob(job);
			dto.setGender(gender);
			dto.setEmail(email);
			
			return dto;
		}
		public Vector<String> getColumn(){
			Vector<String> col = new Vector<String>();
			col.add("���̵�");
			col.add("��й�ȣ");
			col.add("�̸�");
			col.add("��ȭ");
			col.add("�ּ�");
			col.add("����");
			col.add("����");
			col.add("����");
			col.add("�̸���");
			return col;
		}
}

