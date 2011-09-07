package dal;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import java.sql.Types;

public class SQLCursor {
	
	class Vari {
		Object value;
		String tipo;
	}
	
	String query;
	
	ArrayList<Vari> variables = new ArrayList<Vari>();
	def record;

	public SQLCursor(String query) throws SQLException {		
		this.query = query;						
	}
	
	public void setInt(int pos, int value) throws SQLException {
		Vari dto = new Vari()
		dto.setTipo("int")
		dto.setValue(value) 			
		variables.add(dto);
	}

	public void setString(int pos, String value) throws SQLException {
		Vari dto = new Vari()
		dto.setTipo("string")
		dto.setValue(value) 			
		variables.add(dto);
	}
	
	public boolean next() throws Exception {
		
		if (record==null){		
			Object[] vars = new Object[variables.size()]
			int[] tipos = new int[variables.size()]
			
			int cant = 0;
	
			for (Vari var : variables) {
				if (var.tipo.equals("int")){
					vars[cant] = new Long(var.value);
				}
				
				if (var.tipo.equals("string")){
					vars[cant] = new String(var.value);
				}
				cant++
			}

            record = Pool.jdbcTemplate.queryForRowSet(query, vars)

		}

		return record.next()
	}

	public Integer getInt(String field) throws SQLException {
		return record.getInt(field);
	}

	public Integer getInteger(String field) throws SQLException {

		Integer numero = record.getInt(field);
		if (numero==0){
			if (record.wasNull())
				return null;
		}
		
		return numero;			

	}

	public String getString(String field) throws SQLException {
		return record.getString(field);
	}


	public Double getDouble(String field) throws SQLException {
		
		Double numero = record.getDouble(field);
		if (numero==0){
			if (record.wasNull())
				return null;
		}
		
		return numero;	
		
	}

	public Timestamp getTimestamp(String field) throws SQLException {
		def tim = record.getObject(field); 
		return tim;
	}
	
}
