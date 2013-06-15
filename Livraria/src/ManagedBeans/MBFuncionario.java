package ManagedBeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.trabalhoPrimeFaces.dao.FuncionarioDAO;
import br.com.trabalhoPrimeFaces.persistence.FuncionarioVO;

/**
 * 
 * MB - Managed Bean - classe dos funcionários 
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@ManagedBean(name = "MBFuncionario")
@SessionScoped
public class MBFuncionario{

	private FuncionarioVO beanFuncionario;
	private FuncionarioDAO daoFuncionario;

	@SuppressWarnings( "rawtypes" )
	private DataModel consultarFuncionario;

	public MBFuncionario(){
		beanFuncionario = new FuncionarioVO();
		daoFuncionario = new FuncionarioDAO();
	}

	public String prepararAdd() {
		beanFuncionario = new FuncionarioVO();
		return "addFuncionario";
	}

	public String inserir() {
		daoFuncionario.inserir( beanFuncionario );
		return "funcionario";
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public DataModel getConsultarFuncionario() {
		ArrayList< FuncionarioVO > listaFuncionario = new FuncionarioDAO().consultarTodos();
		consultarFuncionario=new ListDataModel(listaFuncionario);
		return consultarFuncionario;
	}

	public ArrayList <FuncionarioVO> getFuncionarios() {
		ArrayList< FuncionarioVO > listaFuncionario = new FuncionarioDAO().consultarTodos();		
		return listaFuncionario;
	}
	
	public String prepararAlterar() {
		beanFuncionario = (FuncionarioVO) ( consultarFuncionario.getRowData() );
		return "alterarFuncionario";
	}

	public String alterarFuncionario() {
		daoFuncionario.alterar( beanFuncionario );
		return "funcionario";
	}
	
	public String excluir(){
		beanFuncionario = (FuncionarioVO) (consultarFuncionario.getRowData() );
		daoFuncionario.excluir( beanFuncionario );
		return "funcionario";
	}
	
	public String nome(int id){
		FuncionarioVO funcionario = daoFuncionario.consultarPorId( id );
		return funcionario.getNome();
	}

	/**
     * Método responsável por retornar o valor do atributo beanFuncionario.
     * @return FuncionarioVO beanFuncionario - beanFuncionario a ser retornado(a).
     */
    public final FuncionarioVO getBeanFuncionario() {
    	return beanFuncionario;
    }

	/**
     * Método responsável por atribuir o valor ao atributo beanFuncionario.
     * @param FuncionarioVO beanFuncionario - beanFuncionario a ser atribuido(a).
     */
    public final void setBeanFuncionario( FuncionarioVO beanFuncionario ) {
    	this.beanFuncionario = beanFuncionario;
    }

	/**
     * Método responsável por retornar o valor do atributo daoFuncionario.
     * @return FuncionarioDAO daoFuncionario - daoFuncionario a ser retornado(a).
     */
    public final FuncionarioDAO getDaoFuncionario() {
    	return daoFuncionario;
    }

	/**
     * Método responsável por atribuir o valor ao atributo daoFuncionario.
     * @param FuncionarioDAO daoFuncionario - daoFuncionario a ser atribuido(a).
     */
    public final void setDaoFuncionario( FuncionarioDAO daoFuncionario ) {
    	this.daoFuncionario = daoFuncionario;
    }

	/**
     * Método responsável por atribuir o valor ao atributo consultarFuncionario.
     * @param DataModel consultarFuncionario - consultarFuncionario a ser atribuido(a).
     */
    @SuppressWarnings("rawtypes")
	public final void setConsultarFuncionario( DataModel consultarFuncionario ) {
    	this.consultarFuncionario = consultarFuncionario;
    }
	
	public String returnError( Integer id ) {
		return daoFuncionario.returnError( id );
	}	   
	
}//Fim da Classe 
