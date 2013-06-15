package ManagedBeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.trabalhoPrimeFaces.dao.ClienteDAO;
import br.com.trabalhoPrimeFaces.persistence.ClienteVO;

/**
 * 
 * MB - Managed Bean - classe dos clientes
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@ManagedBean(name = "MBCliente")
@SessionScoped
public final class MBCliente{

	private ClienteVO beanCliente;
	private ClienteDAO daoCliente;
	
	@SuppressWarnings( "rawtypes" )
	private DataModel consultarCliente;
	
	public MBCliente(){
		
		beanCliente = new ClienteVO();
		daoCliente = new ClienteDAO();
	}
	
	public String prepararAdd() {
		beanCliente = new ClienteVO();
		return "addCliente";
	}

	public String inserir() {
		daoCliente.inserir( beanCliente );
		return "cliente";
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public DataModel getConsultarCliente(){
		ArrayList< ClienteVO > listaCliente = new ClienteDAO().consultarTodos();
		consultarCliente = new ListDataModel(listaCliente);
		return consultarCliente;
	}

	public ArrayList <ClienteVO> getClientes() {
		ArrayList< ClienteVO > listaCliente = new ClienteDAO().consultarTodos();		
		return listaCliente;
	}
	
	public String prepararAlterar() {
		beanCliente = (ClienteVO) ( consultarCliente.getRowData() );
		return "alterarCliente";
	}

	public String alterar() {
		daoCliente.alterar( beanCliente );
		return "cliente";
	}
	
	public String excluir(){
		beanCliente = (ClienteVO) (consultarCliente.getRowData() );
		daoCliente.excluir( beanCliente );
		return "cliente";
	}
	
	public String nome(int id){
		ClienteVO cliente = daoCliente.consultarPorId( id );
		return cliente.getNome();
	}
	
	//Get e Setters
	
	/**
     * Método responsável por retornar o valor do atributo beanCliente.
     * @return ClienteVO beanCliente - beanCliente a ser retornado(a).
     */
    public final ClienteVO getBeanCliente() {
    	return beanCliente;
    }

	/**
     * Método responsável por atribuir o valor ao atributo beanCliente.
     * @param ClienteVO beanCliente - beanCliente a ser atribuido(a).
     */
    public final void setBeanCliente( ClienteVO beanCliente ) {
    	this.beanCliente = beanCliente;
    }

	/**
     * Método responsável por retornar o valor do atributo daoCliente.
     * @return ClienteDAO daoCliente - daoCliente a ser retornado(a).
     */
    public final ClienteDAO getDaoCliente() {
    	return daoCliente;
    }

	/**
     * Método responsável por atribuir o valor ao atributo daoCliente.
     * @param ClienteDAO daoCliente - daoCliente a ser atribuido(a).
     */
    public final void setDaoCliente( ClienteDAO daoCliente ) {
    	this.daoCliente = daoCliente;
    }

	/**
     * Método responsável por retornar o valor do atributo consultarCliente.
     * @return DataModel consultarCliente - consultarCliente a ser retornado(a).
     */
   
	/**
     * Método responsável por atribuir o valor ao atributo consultarCliente.
     * @param DataModel consultarCliente - consultarCliente a ser atribuido(a).
     */
    @SuppressWarnings("rawtypes")
	public final void setConsultarCliente( DataModel consultarCliente ) {
    	this.consultarCliente = consultarCliente;
    }
    
}//Fim da Classe
