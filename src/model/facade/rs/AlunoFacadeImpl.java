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

import model.domain.Aluno;
import model.domain.Lancamento;
import model.facade.AlunoFacade;
import model.service.AlunoService;
import model.service.LancamentoService;

@Path("/aluno")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AlunoFacadeImpl implements AlunoFacade{

	@Inject
	private AlunoService alunoService;
	
	@Inject
	private LancamentoService lancamentoService;
	
	@Override
	@GET
	public List<Aluno> getAlunosSemParametros(){
		return alunoService.getAlunos(new Aluno());
	}
	
	@Override
	@GET
	@Path("/ativos")
	public List<Aluno> getAlunosAtivos(){
		return alunoService.getAlunosAtivos();
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Aluno> getAlunos(@PathParam("codigo") Integer codigo){
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		return alunoService.getAlunos(aluno);
	}
	
	@Override
	@POST
	public Aluno salvar(Aluno aluno){
		return alunoService.salvar(aluno);
	}
	
	@Override
	@PUT
	public void atualizar(Aluno aluno){
		alunoService.atualizar(aluno);
	}
	
	@Override
	@GET
	@Path("/calcular/{codigo}")
	public void calcularAproveitamento(@PathParam("codigo") Integer codigo){
		int horasAproveitadas = 0;
		int totalHoras = 0;
		Aluno aluno = alunoService.getAlunoPorCodigo(codigo);
		List<Lancamento> lancamentos = lancamentoService.getLancamentosAtivosPorAluno(codigo);
		horasAproveitadas = aluno.calcularHorasAproveitadas(lancamentos);
		totalHoras = aluno.somarTotalHoras(lancamentos);
		aluno.setTotalHoras(totalHoras);
		aluno.setHorasAproveitadas(horasAproveitadas);
		aluno.aprovarAluno();
		alunoService.atualizar(aluno);
	}
	
	@Override
	@GET
	@Path("/relatorio/{codigo}")
	public void gerarRelatorio(int codigo){
//		Aluno aluno = alunoService.getAlunoPorCodigo(codigo);
//		aluno.setLancamentos(lancamentoService.getLancamentosAtivosPorAluno(codigo));
//		aluno.calcularAtividades();
//		JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(aluno.getLancamentos());
//		Relatorio retornavel = new Relatorio("lancamentosDoAluno.jasper", null, beanDataSource);
//		HttpServletResponse response;
//		retornavel.executaRetorno(response,getServletContext());
	}
}