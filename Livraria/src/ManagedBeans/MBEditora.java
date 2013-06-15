package ManagedBeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.trabalhoPrimeFaces.dao.EditoraDAO;
import br.com.trabalhoPrimeFaces.persistence.EditoraVO;

/**
 * 
 * MB - Managed Bean - classe das editoras
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@ManagedBean(name = "MBEditora")
@SessionScoped
public final class MBEditora{
	
	private EditoraVO beanEditora;
	private EditoraDAO daoEditora;
	
	@SuppressWarnings("rawtypes")
	private DataModel consultarEditora;
	
	public MBEditora(){
		
		beanEditora = new EditoraVO();
		daoEditora = new EditoraDAO();
    }// Fim do construtor
	
	public String prepararAdd() {
		beanEditora = new EditoraVO();
		return "addEditora";
	}

	public String inserir() {
		daoEditora.inserir( beanEditora );
		return "editora";
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public DataModel getConsultarEditora(){
		ArrayList< EditoraVO > listaEditora = new EditoraDAO().consultarTodos();
		consultarEditora = new ListDataModel(listaEditora);
		return consultarEditora;
	}

	public ArrayList <EditoraVO> getEditoras() {
		ArrayList< EditoraVO > listaEditora = new EditoraDAO().consultarTodos();		
		return listaEditora;
	}
	
	public String prepararAlterar() {
		beanEditora = (EditoraVO) ( consultarEditora.getRowData() );
		return "alterarEditora";
	}

	public String alterar() {
		daoEditora.alterar( beanEditora );
		return "editora";
	}
	
	public String excluir(){
		beanEditora = (EditoraVO) ( consultarEditora.getRowData() );
		daoEditora.excluir( beanEditora );
		return "editora";
	}

	public String nome( int id ) {
		EditoraVO editora = daoEditora.consultarPorId( id );
		return editora.getNome();		
	}
	
	/**
     * Método responsável por retornar o valor do atributo beanEditora.
     * @return EditoraVO beanEditora - beanEditora a ser retornado(a).
     */
    public final EditoraVO getBeanEditora() {
    	return beanEditora;
    }
	/**
     * Método responsável por atribuir o valor ao atributo beanEditora.
     * @param EditoraVO beanEditora - beanEditora a ser atribuido(a).
     */
    public final void setBeanEditora( EditoraVO beanEditora ) {
    	this.beanEditora = beanEditora;
    }
	/**
     * Método responsável por retornar o valor do atributo daoEditora.
     * @return EditoraDAO daoEditora - daoEditora a ser retornado(a).
     */
    public final EditoraDAO getDaoEditora() {
    	return daoEditora;
    }
	/**
     * Método responsável por atribuir o valor ao atributo daoEditora.
     * @param EditoraDAO daoEditora - daoEditora a ser atribuido(a).
     */
    public final void setDaoEditora( EditoraDAO daoEditora ) {
    	this.daoEditora = daoEditora;
    }
	
	public String returnError( Integer id ) {
		return daoEditora.returnError( id );
	}	   
	
}
