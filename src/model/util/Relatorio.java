package model.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class Relatorio{
	
	private String nomeRelatorio;
	private Map<String,Object> parametros;
	private JRDataSource dataSource;
	
	public Relatorio(String nomeRelatorio,Map<String,Object> parametros,JRDataSource dataSource) {
		this.nomeRelatorio = nomeRelatorio;
		this.parametros = parametros;
		this.dataSource = dataSource;
	}

	public void executaRetorno(HttpServletResponse response,ServletContext context) throws ServletException,IOException {
		try {
			ServletOutputStream servletOutputStream = response.getOutputStream();
			String caminho = "/report/";
			InputStream reportStream = context.getResourceAsStream(caminho + nomeRelatorio);    		 
			byte[] retorno = JasperRunManager.runReportToPdf(reportStream, parametros,dataSource);
			response.setContentType("application/pdf");
			servletOutputStream.write(retorno, 0, retorno.length);  
			servletOutputStream.flush();
			servletOutputStream.close();		
		} catch (JRException e) {
			throw new IOException("Erro ao tentar executar o relatório "+e);
		} 
	}
}