/**
 * 
 */
package com.ylsq.frame.sh;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author hopper
 *
 */
public class TimeIdentifierGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		DateFormat df = new SimpleDateFormat("yyyyMMddHH24mmss");
		return Long.parseLong(df.format(new Date()));
	}

}
