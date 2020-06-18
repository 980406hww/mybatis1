package org.hww.test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hww.entiy.Address;
import org.hww.entiy.Person;
import org.hww.mapper.PersonMapper;

public class TestMybatis {
	//查询单个人
	public static void queryPersonById() throws IOException {
		//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				Person person=personmapper.queryPersonById(2);
				System.out.println(person);
				session.close();		
	}
	//查询全部个人
	public static void queryAllPerson() throws IOException {
		//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				List<Person> persons=personmapper.queryAllPerson();
				System.out.println(persons);
				session.close();		
	}
	//查询全部个人
	public static void queryPersonByIdWithArray() throws IOException {
			//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				int[] nums= {1,3,4};
				List<Person> persons=personmapper.queryPersonByIdWithArray(nums);
				System.out.println(persons);
				session.close();		
	}
	//查询全部个人排序
	public static void queryPersonOrderByColumn() throws IOException {
			//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				List<Person> persons=personmapper.queryPersonOrderByColumn("id");
				System.out.println(persons);
				session.close();		
	}
	//用id或者名字查询全部
	public static void queryPersonByIdOrName() throws IOException {
				//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				Person person=new Person();
				person.setId(3);
				person.setName("%w%");
				List<Person> persons=personmapper.queryPersonByIdOrName(person);
				System.out.println(persons);
				session.close();		
		}
	//用id或者名字查询全部
	public static void queryPersonByAddress() throws IOException {
				//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
//				Address address=new Address();
//				address.setHomeaddress("jx");
//				address.setSchooladdress("jx");
//				List<Person> persons=personmapper.queryPersonByAddress(address);
				Person person=new Person();
				Address address=new Address();
				address.setHomeaddress("jx");
				address.setSchooladdress("jx");
				person.setAddress(address);
				List<Person> persons=personmapper.queryPersonByAddress(person);
				System.out.println(persons);
				session.close();		
			}
	//用hashmap或者名字查询全部
	public static void queryPersonByIdOrNameWithHashMap() throws IOException {
				//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				Map<String, Object> personMap=new HashMap<>();
				personMap.put("id", 1);
				personMap.put("name", "hh");
				List<Person> persons=personmapper.queryPersonByIdOrNameWithHashMap(personMap);
				System.out.println(persons);
				session.close();		
			}
	//查询人，结果为map类型
	public static void queryPersonOutByHashMap() throws IOException {
			//加载mybatis配置文件（为了访问数据库）
			Reader reader=Resources.getResourceAsReader("config.xml");
			//SqlSessionFactory - coonnection 创建工厂
			SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
			SqlSession session=sqlsessionFactory.openSession();
			PersonMapper personmapper=session.getMapper(PersonMapper.class);
			List<HashMap<String, Object>> personMap=personmapper.queryPersonOutByHashMap();
			System.out.println(personMap);
			session.close();		
		}
	//使用动态SQL
		public static void queryPerBySQLTag() throws IOException {
				//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				Person person=new Person();
				person.setId(1);
				person.setName("wl");
				person=personmapper.queryPerBySQLTag(person);
				System.out.println(person);
				session.close();		
			}
	//删除单个人
	public static void deletePersonById() throws IOException {
			//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
//				String statement="org.lanqiao.entiy.personMapper.deletePersonById";
//				Person person=session.selectOne(statement,1);
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				personmapper.deletePersonById(2);
				session.commit();//提交事务
				System.out.println("删除成功");
				session.close();		
	}
	//增加单个人
	public static void addPerson() throws IOException {
				//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
//				String statement="org.lanqiao.entiy.personMapper.addPerson";
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				Person person =new Person(1,"wl",18);
				personmapper.addPerson(person);
				//int count=session.insert(statement, person);
				session.commit();//提交事务
				System.out.println("增加成功");
				session.close();		
	}
	//修改单个人
	public static void updatePersonById() throws IOException {
				//加载mybatis配置文件（为了访问数据库）
				Reader reader=Resources.getResourceAsReader("config.xml");
				//SqlSessionFactory - coonnection 创建工厂
				SqlSessionFactory sqlsessionFactory=new SqlSessionFactoryBuilder().build(reader);//可以通过build的第二参数来指定运行环境
				SqlSession session=sqlsessionFactory.openSession();
//				String statement="org.lanqiao.entiy.personMapper.updatePersonById";
				PersonMapper personmapper=session.getMapper(PersonMapper.class);
				Person person=new Person();
				//修改人的id
				person.setId(3);
				//修改的信息
				person.setName("hh");
				person.setAge(20);
				//执行
//				int count=session.update(statement, person);
				personmapper.updatePersonById(person);
				session.commit();//提交事务
				System.out.println("修改成功");
				session.close();		
		}
	public static void main(String[] args) throws IOException {
//		deletePersonById();
//		addPerson();
//		updatePersonById();
//		queryAllPerson();
//		queryPersonOrderByColumn();
//		queryPersonByIdOrName();
//		queryPersonByAddress();
//		queryPersonByIdOrNameWithHashMap();
//		queryPersonOutByHashMap();		
//		queryPerBySQLTag();
		queryPersonByIdWithArray();
	}
}
