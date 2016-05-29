package dsada;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MemberDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL= "jdbc:mysql://127.0.0.1:3306/practices";//DB�� ��ġ�� URL�� �� ���⼱ �⺻ local host

	private static final String USER = "root"; //DB ID
	private static final String PASS = ""; //DB �н�����

	public MemberDAO() {

	}
	public Connection getConn(){
	Connection con = null;
	
	try {
		Class.forName(DRIVER); //1. ����̹� �ε�
		con = DriverManager.getConnection(URL,USER,PASS); //2. ����̹� ����
		
	}   catch (Exception e) {
		e.printStackTrace();
	}
	
		return con;
	}
	public boolean insertMember(MemberDTO dto){
		
		boolean ok = false;
		
		Connection con = null; 		 //����
		PreparedStatement ps = null; //���
		
		try{
			
			con = getConn();
			String sql = "insert into tb_member(" +
						"id,pwd,name,tel,addr,birth," +
						"job,gender,email) "+
						"values(?,?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());
			ps.setString(5, dto.getAddr());
			ps.setString(6, dto.getBirth());
			ps.setString(7, dto.getJob());
			ps.setString(8, dto.getGender());
			ps.setString(9, dto.getEmail());
			int r = ps.executeUpdate(); //���� -> ����
			
			
			if(r>0){
				System.out.println("���� ����");	
				ok=true;
			}else{
				System.out.println("���� ����");
			}
			
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ok;
	}//insertMmeber
	
	public Vector getMemberList(){
	       
		Vector data = new Vector();  //Jtable�� ���� ���� �ִ� ��� 1. 2�����迭   2. Vector �� vector�߰�
       
        Connection con = null;       //����
        PreparedStatement ps = null; //���
        ResultSet rs = null;         //���
       
        try{
            con = getConn();
            String sql = "select * from tb_member order by name asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
               
                Vector row = new Vector();
                row.add(id);
                row.add(pwd);
               
               
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getMemberList()
	   
}
