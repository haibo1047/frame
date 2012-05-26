/**
 * 
 */
package com.ylsq.frame.sh;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hopper
 *
 */
public class LabelAndValueType implements UserType, ParameterizedType {
	private static Logger logger = LoggerFactory.getLogger(LabelAndValueType.class);
	@SuppressWarnings("rawtypes")
	private Class<? extends Enum> enumClass;
	private static Map<Class<?>, LabelAndValue[]> enumValues = new HashMap<Class<?>, LabelAndValue[]>();
	
	@Override
	public void setParameterValues(Properties params) {
		try {
			enumClass = Class.forName(params.getProperty("enumClass")).asSubclass(Enum.class);
		} catch (ClassNotFoundException e) {
			logger.warn("",e);
		}
	}

	public int[] sqlTypes() {
		return new int[]{Types.INTEGER};
	}

	@SuppressWarnings("rawtypes")
	public Class returnedClass() {
		return enumClass;
	}

	public boolean equals(Object x, Object y) throws HibernateException {
		return ( x == y ) || ( x != null && x.equals( y ) );
	}

	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner) throws HibernateException, SQLException {
		Object object = rs.getObject(names[0]);
		if(rs.wasNull()){
			return null;
		}
		for(LabelAndValue lv : enumValues.get(enumClass)){
			if(lv.getValue().equals(object)){
				return lv;
			}
		}
		return null;
	}

	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) throws HibernateException, SQLException {
		if ( value != null ) {
			LabelAndValue lav = (LabelAndValue)value;
			st.setObject(index, lav.getValue());
		}
		else {
			st.setNull( index, sqlTypes()[0] );
		}
		initEnumValue();
	}
	
	private void initEnumValue(){
		LabelAndValue[] values = enumValues.get(enumClass);
		if(values != null){
			Method method;
			try {
				method = enumClass.getDeclaredMethod("values", new Class[0]);
				values = (LabelAndValue[])method.invoke(null, new Object[0]);
			} catch (Exception e) {
				logger.warn("custom hibernate type error",e);
			}
			enumValues.put(enumClass, values); 
		}
	}

	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	public boolean isMutable() {
		return false;
	}

	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}
}
