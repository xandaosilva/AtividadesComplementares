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

import model.domain.Lancamento;
import model.facade.LancamentoFacade;
import model.service.LancamentoService;

@Path("/lancamento")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class LancamentoFacadeImpl implements LancamentoFacade{

	@Inject
	private LancamentoService lancamentoService;
	
	@Override
	@GET
	public List<Lancamento> getLancamentosSemParametros(){
		return lancamentoService.getLancamentos(new Lancamento());
	}
	
	@Override
	@GET
	@Path("/ativos")
	public List<Lancamento> getLancamentosAtivos(){
		return lancamentoService.getLancamentosAtivos();
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Lancamento> getLancamentos(@PathParam("codigo") Integer codigo){
		Lancamento lancamento = new Lancamento();
		lancamento.setCodigo(codigo);
		return lancamentoService.getLancamentos(lancamento);
	}
	
	@Override
	@POST
	public Lancamento salvar(Lancamento lancamento){
		return lancamentoService.salvar(lancamento);
	}
	
	@Override
	@PUT
	public void atualizar(Lancamento lancamento){
		lancamentoService.atualizar(lancamento);
	}
}