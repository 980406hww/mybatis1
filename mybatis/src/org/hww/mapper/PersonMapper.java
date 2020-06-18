package org.hww.mapper;
//操作mybatis的接口

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hww.entiy.Address;
import org.hww.entiy.Person;
 
public interface PersonMapper {
		//方法名和mapper。xml文件中标签的id值相同
		//方法的输入参数和mapper。xml文件标签的parameterType类型一致
		//方法的返回值和mapper.xml文件标签的resultType类型一致
	Person queryPersonById(int id);
	List<Person> queryAllPerson();
	void deletePersonById(int id);
	void addPerson(Person person);
	void updatePersonById(Person person);
	List<Person> queryPersonOrderByColumn(String column);
	List<Person> queryPersonByIdOrName(Person person);
	List<Person> queryPersonByAddress(Person person);
	List<Person> queryPersonByIdOrNameWithHashMap(Map<String,Object> map);
	List<HashMap<String, Object>> queryPersonOutByHashMap();
	Person queryPerBySQLTag(Person person);
	List<Person> queryPersonByIdWithArray(int[] id);
}
