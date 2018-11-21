package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Publicacao;
import entity.Usuario;
import persistence.PublicacaoDao;

@Path("/publicacoes")
public class PublicacaoService {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() throws Exception {
		return new Gson().toJson(new PublicacaoDao().findAll());
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getByUserId(@PathParam("id")String id) throws Exception {
		return new Gson().toJson(new PublicacaoDao().findByUserId(Integer.parseInt(id)));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(Publicacao p) {
		try {
			new PublicacaoDao().update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Dados Alterados com sucesso";
	}
	
	@DELETE
	@Path("/{id}")
	public String delete(@PathParam("id") String id) {
		try {
			new PublicacaoDao().delete(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@POST
	@Path("/{id_usuario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String gravar(Publicacao p,@PathParam("id_usuario")String id_usuario) {
		try {
			p.setUsuario(new Usuario());
			p.getUsuario().setId(Integer.parseInt(id_usuario));
			new PublicacaoDao().create(p, p.getUsuario().getId());
		
		} catch (Exception e) {
			e.printStackTrace();
			return "Algo deuu errado..."+e.getMessage();
		}
	
		return "Dados inseridos com sucesso!";
	}
	
	

}
