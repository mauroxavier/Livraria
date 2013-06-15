package ManagedBeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.trabalhoPrimeFaces.dao.VendaDAO;
import br.com.trabalhoPrimeFaces.persistence.VendaVO;

/**
 * 
 * MB - Managed Bean - classe das vendas 
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@ManagedBean(name = "MBVenda")
@SessionScoped
public final class MBVenda{
	
	private VendaVO beanVenda;
	private VendaDAO daoVenda;
	
	
	@SuppressWarnings("rawtypes")
	private DataModel consultarVenda;
	
	public MBVenda(){
	    
		beanVenda = new VendaVO();
		daoVenda = new VendaDAO();
    }// Fim do construtor
	
	public String prepararAdd() {
		beanVenda = new VendaVO();
		return "addVenda";
	}

	public String inserir() {
		daoVenda.inserir( beanVenda );
		return "venda";
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public DataModel getConsultarVenda(){
		ArrayList< VendaVO > listaVenda = new VendaDAO().consultarTodos();
		consultarVenda = new ListDataModel(listaVenda);
		return consultarVenda;
	}

	public String prepararAlterar() {
		beanVenda = (VendaVO) ( consultarVenda.getRowData() );
		return "alterarVenda";
	}

	public String alterar() {
		daoVenda.alterar( beanVenda );
		return "venda";
	}
	
	public String excluir(){
		beanVenda = (VendaVO) (consultarVenda.getRowData() );
		daoVenda.excluir( beanVenda );
		return "venda";
	}
	
	/**
     * Método responsável por retornar o valor do atributo beanVenda.
     * @return VendaVO beanVenda - beanVenda a ser retornado(a).
     */
    public final VendaVO getBeanVenda() {
    	return beanVenda;
    }
	/**
     * Método responsável por atribuir o valor ao atributo beanVenda.
     * @param VendaVO beanVenda - beanVenda a ser atribuido(a).
     */
    public final void setBeanVenda( VendaVO beanVenda ) {
    	this.beanVenda = beanVenda;
    }
	/**
     * Método responsável por retornar o valor do atributo daoVenda.
     * @return VendaDAO daoVenda - daoVenda a ser retornado(a).
     */
    public final VendaDAO getDaoVenda() {
    	return daoVenda;
    }
	/**
     * Método responsável por atribuir o valor ao atributo daoVenda.
     * @param VendaDAO daoVenda - daoVenda a ser atribuido(a).
     */
    public final void setDaoVenda( VendaDAO daoVenda ) {
    	this.daoVenda = daoVenda;
    }
	
	
}
