package kr.s09.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.s03.preparedstatement.DBUtill;

public class BookDAO {
	// ���� ���

	public void insertBook(BookVO book) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtill.getConnection();
			sql = "insert into book (bk_num,bk_name,bk_category) values (book_seq.nextval,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBk_name());
			pstmt.setString(2, book.getBk_category());

			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� �߰� �߽��ϴ�.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}

	// ���� ��� ����
	public void selectListBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtill.getConnection();
			sql = "select bk_num,bk_name,bk_category,bk_regdate,re_status from book "
					+ "left outer join (select * from reservation where re_status=1) "
					+ "using(bk_num) order by bk_num desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("----------------------------------------");
			System.out.println("��ȣ\t�з�\t�����\t\t���⿩��\t������");
			System.out.println("----------------------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt("bk_num") + "\t");
				System.out.print(rs.getString("bk_category") + "\t");
				System.out.print(rs.getDate("bk_regdate") + "\t");
				if (rs.getInt("re_status") == 0) { // re_status�� null�� INT�� ��ȯ �� 0���� ��ȯ
					System.out.print("���� ����\t");
				} else {
					System.out.print("���� ��\t");
				}
				System.out.println(rs.getString("bk_name"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	//������
	public void insertReservation(ReservationVO reservation) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "insert into reservation (re_num,bk_num,me_num,re_status) " //re_num �����ȣ 
																			  //bk_num å��ȣ
																			  //me_num ����ȣ
					+ "values(reservation_seq.nextval,?,?,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservation.getBk_num());
			pstmt.setInt(2, reservation.getMe_num());
			
			int count = pstmt.executeUpdate();
			System.out.println(count +"�� ���� �߰��߽��ϴ�.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
	//���� ���� Ȯ��
	
	public int getStatusReservation(int bk_num) {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = null;
	      int count = 0;
	      
	      try {
	         //JDBC ���� 1,2�ܰ�
	         conn = DBUtill.getConnection();
	         //SQL�� �ۼ�
	         sql = "SELECT re_status FROM book LEFT OUTER JOIN " //left outer join �߸� �Է��� �� ã��
	               + "(SELECT * FROM reservation WHERE re_status=1) USING(bk_num) WHERE bk_num=?";
	         //JDBC ���� 3�ܰ� : PreparedStatement ��ü ����
	         pstmt = conn.prepareStatement(sql);
	         //?�� ������ ���ε�   
	         pstmt.setInt(1, bk_num);
	         //JDBC ���� 4�ܰ� : SQL���� �����ؼ� ���̺�κ��� ���⿩�� ��ȸ
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	                     //�÷� �ε���
	            count = rs.getInt(1);//���� ��ȣ�� ���� ��
	         }else{
	            count = -1;//���� ��ȣ�� ���� ��
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         //�ڿ�����
	         DBUtill.executeClose(rs, pstmt, conn);
	      }
	      
	      return count;
	   }
	
	public void updateReservation(int re_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "update reservation set re_status=0, re_modifydate=SYSDATE where re_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_num);
			int count = pstmt.executeUpdate();
			System.out.println(count + "���� ���� ���� �߽��ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}
	
	//���� ��� ����
	public void selectListReservation() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "select re_num, me_id,me_name,bk_name,re_status,re_regdate,re_modifydate from reservation "
					+ "join book using(bk_num) join member using(me_num) "
					+ "order by re_num desc";
			
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			System.out.println("-------------------------------");
			System.out.println("��ȣ\t���̵�\t������\t���⵵����\t���⿩��\t������\t�ݳ���");
			System.out.println("-------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				if(rs.getInt("re_status")==0) {
					System.out.print("�ݳ�\t");
				}else {
					System.out.print("���� ��\t");
				}
				System.out.print(rs.getDate("re_regdate")+"\t");
				if(rs.getDate("re_modifydate") == null) {
					System.out.println("");
				}else {
					System.out.println(rs.getDate("re_modifydate"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	//MY���� ��� ����
	public void selectMyList(int me_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			conn = DBUtill.getConnection();
			sql = "select re_num, me_id,me_name,bk_name,re_status,re_regdate,re_modifydate from reservation "
					+ "join book using(bk_num) join member using(me_num) "
					+ "where me_num=? order by re_num desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, me_num);
			rs= pstmt.executeQuery();
		    
			System.out.println("-------------------------------");
			System.out.println("��ȣ\t���̵�\t������\t���⵵����\t���⿩��\t������\t�ݳ���");
			System.out.println("-------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				if(rs.getInt("re_status")==0) {
					System.out.print("�ݳ�\t");
				}else {
					System.out.print("���� ��\t");
				}
				System.out.print(rs.getDate("re_regdate")+"\t");
				if(rs.getDate("re_modifydate") == null) {
					System.out.println("");
				}else {
					System.out.println(rs.getDate("re_modifydate"));
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}
	}
	
	// ȸ������
	public void insertMember(MemberVO member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DBUtill.getConnection();
			sql = "insert into member (me_num,me_id,me_passwd,me_name,me_phone) "
					+ "values (member_seq.nextval,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMe_id());
			pstmt.setString(2, member.getMe_passwd());
			pstmt.setString(3, member.getMe_name());
			pstmt.setString(4, member.getMe_phone());

			int count = pstmt.executeUpdate();
			System.out.println(count + "�� ���� �߰��߽��ϴ�.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(null, pstmt, conn);
		}
	}

	// ȸ�����
	public void selectListMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			conn = DBUtill.getConnection();

			sql = "select * from member order by me_num desc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			System.out.println("--------------------------");
			System.out.println("��ȣ\t���̵�\t�̸�\t��й�ȣ\t��ȭ��ȣ\t������");

			while (rs.next()) {
				System.out.print(rs.getInt("me_num") + "\t");
				System.out.print(rs.getString("me_id") + "\t");
				System.out.print(rs.getString("me_name") + "\t");
				System.out.print(rs.getString("me_passwd") + "\t");
				System.out.print(rs.getString("me_phone") + "\t");
				System.out.println(rs.getDate("me_regdate"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}

	}

	// ���̵� �ߺ�üũ
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;

		try {
			conn = DBUtill.getConnection();
			sql = "select me_id from member where me_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = 1; // ī��Ʈ�� 0�̸� ���̵� ������, me_id�� ������ if���� �������� ����
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}

		return count;
	}

	public int loginCheck(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int me_num = 0;

		try {
			conn = DBUtill.getConnection();

			sql = "select me_num from member where me_id=? and me_passwd=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);

			rs = pstmt.executeQuery();
			if (rs.next()) { // �ɹ�id�� ����ũŰ �̱⶧���� �� �ϳ��� �ҷ��ͼ� if�� ��� (while ���)
				me_num = rs.getInt(1); // �ε��� ��ȣ ���, ���� ����ص� ����
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtill.executeClose(rs, pstmt, conn);
		}

		return me_num;
	}

	public int getStatusBack(int re_num, int me_num) {
		// TODO Auto-generated method stub
		return 0;
	}
}
