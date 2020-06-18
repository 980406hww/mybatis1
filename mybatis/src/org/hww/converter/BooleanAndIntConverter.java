package org.hww.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class BooleanAndIntConverter extends BaseTypeHandler<Boolean> {
	//BaseTypeHandler是TypeHandler的实现类
	/*ps:PreparedStatement对象
	 * i:PreparedStatement对象操作参数的位置
	 * parameter:java值
	 * jdbcType:jdbc操作数据库类型
	 */
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int sex=rs.getInt(columnName);
		
		return sex==1?true:false;
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int sex=rs.getInt(columnIndex);//通过下标拿值
		
		return sex==1?true:false;
	}

	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int sex=cs.getInt(columnIndex);//通过存储过程拿
		
		return sex==1?true:false;
	}

	@Override
	//java(boolean)-db(number)
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		if(parameter) {
			ps.setInt(i, 1);
		}
		else {
			ps.setInt(i, 0);
		}
			
	}
	
	
	
}
