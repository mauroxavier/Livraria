package ManagedBeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.trabalhoPrimeFaces.dao.AutorDAO;
import br.com.trabalhoPrimeFaces.persistence.AutorVO;

/**
 * 
 * MB - Managed Bean - classe dos autores 
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@ManagedBean( name = "MBAutor" )
@SessionScoped
public class MBAutor{

	private AutorDAO daoAutor;
	private AutorVO beanAutor;

	@SuppressWarnings( "rawtypes" )
	private DataModel consultarAutor;

	public MBAutor(){

		daoAutor = new AutorDAO();
		beanAutor = new AutorVO();
	}

	public String prepararAdd() {
		beanAutor = new AutorVO();
		return "addAutor";
	}

	public String inserir() {
		daoAutor.inserir( beanAutor );
		return "autor";
	}

	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public DataModel getConsultarAutor() {
		ArrayList< AutorVO > listaAutor = new AutorDAO().consultarTodos();
		consultarAutor = new ListDataModel( listaAutor );
		return consultarAutor;
	}

	public ArrayList <AutorVO> getAutores() {
		ArrayList< AutorVO > listaAutor = new AutorDAO().consultarTodos();		
		return listaAutor;
	}
	
	public String prepararAlterar() {
		beanAutor = (AutorVO) ( consultarAutor.getRowData() );
		return "alterarAutor";
	}

	public String alterar() {
		daoAutor.alterar( beanAutor );
		return "autor";
	}

	public String excluir() {
		beanAutor = (AutorVO) ( consultarAutor.getRowData() );
		daoAutor.excluir( beanAutor );
		return "autor";
	}

	public String nome( int id ) {
		AutorVO autor = daoAutor.consultarPorId( id );
		return autor.getNome();
	}

	//Get e Setters
	/**
	 * Método responsável por retornar o valor do atributo daoAutor.
	 * 
	 * @return AutorDAO daoAutor - daoAutor a ser retornado(a).
	 */
	public final AutorDAO getDaoAutor() {
		return daoAutor;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo daoAutor.
	 * 
	 * @param AutorDAO daoAutor - daoAutor a ser atribuido(a).
	 */
	public final void setDaoAutor( AutorDAO daoAutor ) {
		this.daoAutor = daoAutor;
	}

	/**
	 * Método responsável por retornar o valor do atributo beanAutor.
	 * 
	 * @return AutorVO beanAutor - beanAutor a ser retornado(a).
	 */
	public final AutorVO getBeanAutor() {
		return beanAutor;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo beanAutor.
	 * 
	 * @param AutorVO beanAutor - beanAutor a ser atribuido(a).
	 */
	public final void setBeanAutor( AutorVO beanAutor ) {
		this.beanAutor = beanAutor;
	}

	/**
	 * Método responsável por atribuir o valor ao atributo consultarAutor.
	 * 
	 * @param DataModel consultarAutor - consultarAutor a ser atribuido(a).
	 */
	public final void setConsultarAutor( @SuppressWarnings("rawtypes") DataModel consultarAutor ) {
		this.consultarAutor = consultarAutor;
	}

}//Fim da Classe
