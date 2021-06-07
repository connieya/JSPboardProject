package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import board.vo.Board;

public class BoardDao {

	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	public int 글쓰기(Board dto) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into board(name,title,content,password,readCount) values(?,?,?,?,?)";
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPassword());
			pstmt.setInt(5, 0);
			int result = pstmt.executeUpdate();
			System.out.println("result 값:" + result);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		return -1;

	}

	public void paging() {
		String sql = "select count(*) from board";
		int totalCount = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			totalCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Board> list() {

		ArrayList<Board> dtos = new ArrayList<Board>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String query = "select * from board order by no desc";
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				Timestamp date = rs.getTimestamp("date");
				String name = rs.getString("name"); // column 명
				int readCount = rs.getInt("readCount");
				Board dto = new Board().setNo(no).setName(name).setTitle(title).setDate(date).setReadCount(readCount);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		return dtos;
	} // list() 끝

	public Board 글상세보기(int no) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from board where no =?";
		Board dto = new Board();
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getNString(3));
				dto.setContent(rs.getString(4));
				dto.setDate(rs.getTimestamp(5));
				dto.setReadCount(rs.getInt(6));
				조회수증가(no);
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public void 조회수증가(int no) {
		String sql = "update board set readCount = readCount +1 where no =?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public int 글삭제하기(int no) {
		String sql = "delete from board where no = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return -2; // DB 오류

	}

	public int 삭제인증(String no, String password) {

		String sql = "select password from board where no = ?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, no);

			rs = pstmt.executeQuery();
			if (rs.getString(1).equals(password)) {
				System.out.println("비밀번호 일치");
				return 1;
			} else {
				System.out.println("비밀번호 틀림");

				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (connection != null)
					connection.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		return -2;

	}

	public Board 글수정하기(Board dto) {

		String sql = "update board set title = ? , content = ? where no =?";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}
}
