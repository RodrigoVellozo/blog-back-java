package persistence;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import entity.Publicacao;

public class PublicacaoDao extends Dao {
	
	public void create(Publicacao p, Integer id_usuario)throws Exception {
		open();
		stmt= con.prepareStatement("insert into publicacao values(null, ?, ?, ?, ?, ?)");
		stmt.setString(1, p.getTitulo());
		stmt.setString(2, p.getTexto());
		stmt.setString(3, p.getImagem());
		Date data = new Date(p.getData().getTime());
		stmt.setDate(4, data);
		stmt.setInt(5, id_usuario);
		stmt.execute();
		close();
	}
	
	public void delete(Integer id)throws Exception{
		open();
		stmt=con.prepareStatement("delete from publicacao where id=?");
		stmt.setInt(1, id);
		stmt.execute();
		close();
	}
	
	public void update(Publicacao p)throws Exception{
		open();
		stmt= con.prepareStatement("update publicacao set titulo=?, texto=?, imagem=? where id =?");
		stmt.setString(1, p.getTitulo());
		stmt.setString(2, p.getTexto());
		stmt.setString(3, p.getImagem());
		stmt.setInt(4, p.getId());
		stmt.execute();
		close();
	}
	
	public List<Publicacao> findAll() throws Exception{
		open();
		stmt= con.prepareStatement("select * from publicacao");
		rs=stmt.executeQuery();
		List<Publicacao>lista= new ArrayList<>();
		while(rs.next()) {
			lista.add(new Publicacao(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			
		}
		close();
		return lista;
		
	}
	
	public List<Publicacao> findByUserId(Integer id) throws Exception{
		open();
		stmt= con.prepareStatement("select * from publicacao where id_usuario=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		List<Publicacao>lista= new ArrayList<>();
		while(rs.next()) {
			lista.add(new Publicacao(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		close();
		return lista;
	}
	
	public List<Publicacao> findById(Integer id) throws Exception{
		open();
		stmt= con.prepareStatement("select * from publicacao where id=?");
		stmt.setInt(1, id);
		rs=stmt.executeQuery();
		List<Publicacao>lista= new ArrayList<>();
		while(rs.next()) {
			lista.add(new Publicacao(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		close();
		return lista;
		
	}
	
	
	

}
