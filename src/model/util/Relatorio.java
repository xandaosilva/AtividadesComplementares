package model.util;

import java.util.List;

import javax.inject.Inject;

import model.dao.AlunoDao;
import model.dao.LancamentoDao;
import model.domain.Aluno;
import model.domain.Lancamento;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoDao alunoDao;
	
	@Inject
	private LancamentoDao lancamentoDao;
	
	public void gerarRelatorioDeAlunosPorTurma(int codigo) throws JRException{
		try {
			List<Aluno> alunos = alunoDao.getAlunosPorTurma(codigo);
			String arquivo = System.getProperty("user.dir") + "/resources/relatorio/alunosDaTurma.jasper";
			JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(alunos);
			JasperPrint impressao = JasperFillManager.fillReport(arquivo, null,beanDataSource);
			JasperViewer.viewReport(impressao,false);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}
	
	public void gerarRelatorioDeLancamentosPorTurma(int codigo) throws JRException{
		try {
			List<Lancamento> lancamentos = lancamentoDao.getLancamentosPorAluno(codigo);
			String arquivo = System.getProperty("user.dir") + "/resources/relatorio/lancamentosDoAluno.jasper";
			JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource(lancamentos);
			JasperPrint impressao = JasperFillManager.fillReport(arquivo, null,beanDataSource);
			JasperViewer.viewReport(impressao,false);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}	
}