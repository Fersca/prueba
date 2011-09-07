package dal;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.sql.Types;

public class SQLExecute {
	
	class Vari {
		Object value;
		String tipo;
	}
	
	String query;
	
	ArrayList<Vari> variables = new ArrayList<Vari>();
	
	public SQLExecute(String query) throws SQLException {
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

	public void setDate(int pos, Date value) throws SQLException {
		Vari dto = new Vari()
		dto.setTipo("date")
		dto.setValue(value)
		variables.add(dto);
	}

	public boolean execute() throws Exception {
		
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

			if (var.tipo.equals("date")){
				vars[cant] = var.value;
			}

			cant++
		}

        Pool.jdbcTemplate.update(query, vars);

	}

}
