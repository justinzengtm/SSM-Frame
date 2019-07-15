package com.mybatis.typeHandlers;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.BaseTypeHandler;

public class DateTypeHandler extends BaseTypeHandler<Date> {
	@Override
	// 在为SQL配置传入参数时执行的操作,可将参数传入数据库前对数据类型做处理
	public void setNonNullParameter(PreparedStatement ps, int i,  Date date, JdbcType jdbcType) throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ps.setString(i, sdf.format(date));
	}
	
	@Override
	// 根据字段名来获得结果
	public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// 在结果集中把varchar类型转换为Date类型
		String tmpDate = rs.getString(columnName);
		if(tmpDate != null) {
			return new Date(Long.parseLong(tmpDate));
		} else {
			return null;
		}
	}
	
	@Override
	//根据字段下标获得结果
	public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		String tmpDate = rs.getString(columnIndex);
		if(tmpDate != null) {
			return new Date(Long.parseLong(tmpDate));
		} else {
			return null;
		}
	}
	
	@Override
	public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		String tmpDate = cs.getString(columnIndex);
		if(tmpDate != null) {
			return new Date(Long.parseLong(tmpDate));
		} else {
			return null;
		}
	}

}
