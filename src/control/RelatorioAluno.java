package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RelatorioAluno")
public class RelatorioAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
//	private AlunoFacade alunoFacade;
//	private LancamentoFacade lancamentoFacade;
	
	
    public RelatorioAluno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Aluno aluno = alunoFacade.getAlunos(codigo);
//		aluno.setLancamentos(lancamentoFacade.getLancamentosAtivosPorAluno(codigo));
//		aluno.calcularAtividades();
//		JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(aluno.getLancamentos());
//		Relatorio retornavel = new Relatorio("lancamentosDoAluno.jasper", codigo, beanDataSource);
//		retornavel.executaRetorno(response,getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}