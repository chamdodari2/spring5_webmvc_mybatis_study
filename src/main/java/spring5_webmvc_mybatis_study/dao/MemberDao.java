package spring5_webmvc_mybatis_study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring5_webmvc_mybatis_study.dto.Member;
import spring5_webmvc_mybatis_study.mapper.MemberRowMapper;

//@Component
public class MemberDao {

	private JdbcTemplate jdbcTemplate;



	public MemberDao(DataSource dataSource) {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 결과가 1개 이상인 경우
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query("select * from member where email = ?", new MemberRowMapper(), email);
		return results.isEmpty() ? null : results.get(0);
	}

	public List<Member> selectAll() {
		return jdbcTemplate.query("select * from member", new MemberRowMapper());

	}

//결과가 1행인 경우

	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
	}

	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
		@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into member (email,password,name,regdate)" + "values(?,?,?,?)", new String[] { "id" });

				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		},keyHolder);

		
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

	public void update(Member member) {
		jdbcTemplate.update("update member set name=? , password = ? where email=?", member.getName(),
				member.getPassword(), member.getEmail());
	}

	public void delete(Member member) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("delete from member where email=?");
				pstmt.setString(1, member.getEmail());
				return pstmt;
			}

		};
		jdbcTemplate.update(psc);
	}
}