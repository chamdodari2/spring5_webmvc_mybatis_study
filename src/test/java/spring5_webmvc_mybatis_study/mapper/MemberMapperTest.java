package spring5_webmvc_mybatis_study.mapper;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_webmvc_mybatis_study.config.ContextRoot;
import spring5_webmvc_mybatis_study.dto.Member;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
ContextRoot.class
})
public class MemberMapperTest {
	protected static final Log log = LogFactory.getLog(MemberMapperTest.class);
	
	@Autowired
	private MemberMapper mapper;
	
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		//
				List<Member> list = mapper.selectAll();
				Assert.assertNotNull(list);
				list.stream().forEach(System.out::println);
	}

//	@Test
//	public void testSelectByEmail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testInsert() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectMemberByMap() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSelectMemberForMap() {
//		fail("Not yet implemented");
//	}

}
