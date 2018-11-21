package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Usuario;

public class UsuarioDao extends Dao{
	
	
	public void create(Usuario u)throws Exception{
		open();
		stmt= con.prepareStatement("insert into usuario values(null, ?, ?, ?, ?, ?)");
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getSobrenome());
		stmt.setString(3, u.getEmail());
		stmt.setString(4, u.getSenha());
		stmt.setString(5, u.getImagem());
		stmt.execute();
		close();
	}
	
	public List<Usuario> findAll()throws Exception{
		open();
		stmt= con.prepareStatement("select * from usuario");
		rs= stmt.executeQuery();
		List<Usuario> lista= new ArrayList<>();
		while (rs.next()) {
			lista.add(new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
		}
		close();
		return lista;
	}
	
	public Usuario findByCode(Integer id)throws Exception{
		open();
		stmt= con.prepareStatement("select * from usuario where id=?");
		stmt.setInt(1, id);
		rs= stmt.executeQuery();
		Usuario user= null;
		if (rs.next()) {
			user=new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
		}
		close();
		return user;
	}
	
	public Usuario logar(Usuario u)throws Exception{
		open();
		stmt= con.prepareStatement("select * from usuario where email=? and senha=?");
		stmt.setString(1, u.getEmail());
		stmt.setString(2, u.getSenha());
		rs= stmt.executeQuery();
		Usuario user= null;
		if (rs.next()) {
			user= new Usuario(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)   );
		}
		close();
		return user;
	}
	


}
