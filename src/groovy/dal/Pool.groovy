package dal;

import javax.sql.DataSource;

import org.codehaus.groovy.grails.commons.ApplicationHolder;
import org.springframework.jdbc.core.JdbcTemplate;

class Pool {

	static private JdbcTemplate jdbcTemplate = createTemplate();
	
	static private createTemplate(){
		DataSource dt = (DataSource) ApplicationHolder.getApplication().getMainContext().getBean("dataSource");
		return new JdbcTemplate(dt);
	}
	
}