package kr.or.connect.todo.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.connect.todo.dto.Todo;


public class TodoDao {
	private static String dburl = "jdbc:mysql://localhost:3306/todo?serverTimezone=Asia/Seoul&useUnicode=true&characterEncoding=UTF-8";
	private static String dbUser = "root";
	private static String dbpasswd = "qhdksdhksfy0252";
	
	//type에 따라 객체 가져오는 함수
	public List<Todo> getTodos(String t_type) {
		List<Todo> list = new ArrayList<>();
		Connection conn = null; //연결
		PreparedStatement ps = null; //명령
		ResultSet rs = null; //결과값

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "SELECT id, title, name, sequence, type, regdate FROM todo WHERE type = ? ORDER BY id desc";
			ps = conn.prepareStatement(sql);
			ps.setString(1, t_type); //몇 번째 물음표 대신에 이 값을 넣어주세용
			rs = ps.executeQuery();

			while (rs.next()) {
				int todo_id = rs.getInt("id");
				String todo_title = rs.getString("title");
				String todo_name = rs.getString("name");
				int todo_se = rs.getInt("sequence");
				String todo_type = rs.getString("type");
				String todo_date = rs.getString("regdate");
				
				Todo todo = new Todo(todo_id, todo_title, todo_name, todo_se, todo_type, todo_date);
				list.add(todo); // list에 반복할때마다 Role인스턴스를 생성하여 list에 추가한다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	//값 집어넣는 함수
	public int addTodo(Todo todo) {
		int insertCount = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "INSERT INTO todo (title, name, sequence) VALUES ( ?, ?, ? )";

		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, todo.getTitle());
			ps.setString(2,  todo.getName());
			ps.setInt(3, todo.getSequence());

			insertCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return insertCount;
	}
	
	//객체 수정하는 함수
	public int updateTodo(String type, int id) {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" );
			
			conn = DriverManager.getConnection ( dburl, dbUser, dbpasswd );
			
			String sql = "update todo set type = ? where id = ?";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			ps.setInt(2,  id);
			
			updateCount = ps.executeUpdate();

		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(Exception ex) {}
			} // if
			
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception ex) {}
			} // if
		} // finally
		
		return updateCount;
	}
}
