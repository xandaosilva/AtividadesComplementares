package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RelatorioTurma")
public class RelatorioTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private AlunoFacade alunoFacade;
//  private TurmaFacade turmaFacade;
	public RelatorioTurma() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Aluno aluno = alunoFacade.getAlunos(codigo);
//		aluno.setLancamentos(lancamentoFacade.getLancamentosAtivosPorAluno(codigo));
//		aluno.calcularAtividades();
//		JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(aluno.getLancamentos());
//		Relatorio retornavel = new Relatorio("lancamentosDoAluno.jasper", null, beanDataSource);
//		retornavel.executaRetorno(response,getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}