package com.mybatis.test;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mybatis.datasource.DataConnection;
import com.mybatis.po.UserDiscriminator;
import com.mybatis.po.UserDiscriminator1;
import com.mybatis.po.UserDiscriminator2;

public class MyBatisTestDiscriminator {
	public DataConnection dataConn = new DataConnection();
	
	@Test
	public void TestDiscriminator1() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		
		UserDiscriminator1 result1 = sqlSession.selectOne("queryUserPosition", 1);
		System.out.println("姓名：" + result1.getUsername());
		System.out.println("性别：" + result1.getGender());
		System.out.println("电子邮件：" + result1.getEmail());
		System.out.println("所在省会：" + result1.getProvince());
		System.out.println("所在城市：" + result1.getCity());
		
		UserDiscriminator2 result2 = sqlSession.selectOne("queryUserInfo", 2);
		System.out.println("姓名：" + result2.getUsername());
		System.out.println("性别：" + result2.getGender());
		System.out.println("电子邮件：" + result2.getEmail());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("顾客生日：" + sdf.format(result2.getBirthday()));
		System.out.println("顾客年龄：" + result2.getAge());
		
		sqlSession.close();
	}
	
	@Test
	public void TestDiscriminator2() throws IOException {
		SqlSession sqlSession = dataConn.getSqlSession();
		UserDiscriminator result1 = sqlSession.selectOne("queryUserPosition", 1);
		HashMap<String, String> resultMap = result1.getUserInfo();
		System.out.println("姓名：" + result1.getUsername());
		System.out.println("性别：" + result1.getGender());
		System.out.println("电子邮件：" + result1.getEmail());
		System.out.println("所在省会：" + resultMap.get("province"));
		System.out.println("所在城市：" + resultMap.get("city"));
		resultMap.clear();
		
		UserDiscriminator result2 = sqlSession.selectOne("queryUserInfo", 2);
		resultMap = result2.getUserInfo();
		System.out.println("姓名：" + result2.getUsername());
		System.out.println("性别：" + result2.getGender());
		System.out.println("电子邮件：" + result2.getEmail());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("顾客生日：" + sdf.format(resultMap.get("birthday")));
		System.out.println("顾客年龄：" + resultMap.get("age"));
		sqlSession.close();
	}
	
	public static void main(String[] args) throws IOException {
		MyBatisTestDiscriminator testDiscriminator = new MyBatisTestDiscriminator();
		testDiscriminator.TestDiscriminator2();

	}

}
