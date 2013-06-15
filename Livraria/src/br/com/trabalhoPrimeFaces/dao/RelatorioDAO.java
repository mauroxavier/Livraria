package br.com.trabalhoPrimeFaces.dao;

import java.sql.Connection;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.com.trabalhoPrimeFaces.abstractdao.AbstractDAO;

import Utils.ConexaoRelatorios;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class RelatorioDAO extends AbstractDAO {
	
	public static void gerarRelatorio(String nome) {
		Connection conn = ConexaoRelatorios.getConnection();
        String reportPath = FacesContext.getCurrentInstance()
        		.getExternalContext()
        		.getRealPath("/relatorios/" + nome + ".jasper");
        
        try{
        	JasperPrint jp = JasperFillManager.fillReport(reportPath, null, conn);
        	
        	HttpServletResponse hsr = (HttpServletResponse) 
        			FacesContext.getCurrentInstance().getExternalContext().getResponse();
        	
        	ServletOutputStream sos = hsr.getOutputStream();
        	JasperExportManager.exportReportToPdfStream(jp, sos);
        	
        	conn.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        FacesContext.getCurrentInstance().responseComplete();
	}
}	
