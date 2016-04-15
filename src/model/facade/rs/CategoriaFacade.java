package model.facade.rs;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.domain.Categoria;
import model.service.CategoriaService;

@Path("/categoria")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CategoriaFacade {

	@Inject
	private CategoriaService categoriaService;
	
	@GET
	public List<Categoria> getCategoriasSemParametros(){
		return categoriaService.getCategorias(new Categoria());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Categoria> getCategorias(@PathParam("codigo") Integer codigo){
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigo);
		return categoriaService.getCategorias(categoria);
	}
	
	@POST
	public Categoria salvar(Categoria categoria){
		return categoriaService.salvar(categoria);
	}
	
	@PUT
	public void atualizar(Categoria categoria){
		categoriaService.atualizar(categoria);
	}
}
