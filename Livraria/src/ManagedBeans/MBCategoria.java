package ManagedBeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.trabalhoPrimeFaces.dao.CategoriaDAO;
import br.com.trabalhoPrimeFaces.persistence.CategoriaVO;

/**
 * 
 * MB - Managed Bean - classe das categorias
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@ManagedBean(name = "MBCategoria")
@SessionScoped
public final class MBCategoria{
	
	private CategoriaVO beanCategoria;
	private CategoriaDAO daoCategoria;
	
	@SuppressWarnings( "rawtypes" )
	private DataModel consultarCategoria;
	
	public MBCategoria(){
		beanCategoria = new CategoriaVO();
		daoCategoria = new CategoriaDAO();
	}//Fim do construtor
	
	public String prepararAdd() {
		beanCategoria = new CategoriaVO();
		return "addCategoria";
	}

	public String inserir() {
		daoCategoria.inserir( beanCategoria );
		return "categoria";
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public DataModel getConsultarCategoria(){
		ArrayList< CategoriaVO > listaCategoria = new CategoriaDAO().consultarTodos();
		consultarCategoria = new ListDataModel(listaCategoria);
		return consultarCategoria;
	}

	public ArrayList <CategoriaVO> getCategorias() {
		ArrayList< CategoriaVO > listaCategoria = new CategoriaDAO().consultarTodos();		
		return listaCategoria;
	}
	
	public String prepararAlterar() {
		beanCategoria = (CategoriaVO) ( consultarCategoria.getRowData() );
		return "alterarCategoria";
	}

	public String alterar() {
		daoCategoria.alterar( beanCategoria );
		return "categoria";
	}
	
	public String excluir(){
		beanCategoria = (CategoriaVO) (consultarCategoria.getRowData() );
		daoCategoria.excluir( beanCategoria );
		return "categoria";
	}

	public String nome(int id){
		CategoriaVO categoria = daoCategoria.consultarPorId( id );
		return categoria.getNome();	
	}		

	/**
     * Método responsável por retornar o valor do atributo beanCategoria.
     * @return CategoriaVO beanCategoria - beanCategoria a ser retornado(a).
     */
    public final CategoriaVO getBeanCategoria() {
    	return beanCategoria;
    }

	/**
     * Método responsável por atribuir o valor ao atributo beanCategoria.
     * @param CategoriaVO beanCategoria - beanCategoria a ser atribuido(a).
     */
    public final void setBeanCategoria( CategoriaVO beanCategoria ) {
    	this.beanCategoria = beanCategoria;
    }

	/**
     * Método responsável por retornar o valor do atributo daoCategoria.
     * @return CategoriaDAO daoCategoria - daoCategoria a ser retornado(a).
     */
    public final CategoriaDAO getDaoCategoria() {
    	return daoCategoria;
    }

	/**
     * Método responsável por atribuir o valor ao atributo daoCategoria.
     * @param CategoriaDAO daoCategoria - daoCategoria a ser atribuido(a).
     */
    public final void setDaoCategoria( CategoriaDAO daoCategoria ) {
    	this.daoCategoria = daoCategoria;
    }

	/**
     * Método responsável por atribuir o valor ao atributo consultarCategoria.
     * @param DataModel consultarCategoria - consultarCategoria a ser atribuido(a).
     */
    public final void setConsultarCategoria( @SuppressWarnings("rawtypes") DataModel consultarCategoria ) {
    	this.consultarCategoria = consultarCategoria;
    }
	
	public String returnError( Integer id ) {
		return daoCategoria.returnError( id );
	}	   
	
}//Fim da Classe
