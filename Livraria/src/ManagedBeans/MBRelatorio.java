package ManagedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.trabalhoPrimeFaces.dao.LivroDAO;
import br.com.trabalhoPrimeFaces.dao.RelatorioDAO;

@ManagedBean(name="MBRelatorio")
@SessionScoped
public class MBRelatorio {
	LivroDAO livroDAO = new LivroDAO();
	RelatorioDAO relatorioDAO = new RelatorioDAO();
	
	
	public void gerarRelatorioProd(){		
			RelatorioDAO.gerarRelatorio("RelatorioLivros");
	}
}
