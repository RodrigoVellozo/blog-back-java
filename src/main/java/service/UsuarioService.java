package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Usuario;
import persistence.UsuarioDao;

@Path("/usuarios")
public class UsuarioService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() throws Exception {
		return new Gson().toJson(new UsuarioDao().findAll());
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id")String id) throws Exception {
		return new Gson().toJson(new UsuarioDao().findByCode(Integer.parseInt(id)));
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String gravar(Usuario u) {
		try {
			new UsuarioDao().create(u);
		} catch (Exception e) {
			e.printStackTrace();
			return "Falha na gravação";
		}
		return "Dados inseridos com sucesso!";
	}
	
	@POST
	@Path("/logar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String logar(Usuario u) {
		try {
			Usuario user = new UsuarioDao().logar(u);
			return new Gson().toJson(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "nulo";
		}
		
	}
	
}
