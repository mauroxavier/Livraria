package ManagedBeans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.trabalhoPrimeFaces.dao.LivroDAO;
import br.com.trabalhoPrimeFaces.persistence.LivroVO;

/**
 * 
 * MB - Managed Bean - classe dos livros 
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@ManagedBean(name = "MBLivro")
@SessionScoped
public final class MBLivro{
	
	private LivroVO beanLivro;
	private LivroDAO daoLivro;
	
	@SuppressWarnings( "rawtypes" )
	private DataModel consultarLivro;
	
	public MBLivro(){
		beanLivro = new LivroVO();
		daoLivro = new LivroDAO();
	}//Fim do construtor
	
	public String prepararAdd() {
		beanLivro = new LivroVO();
		return "addLivro";
	}

	public String inserir() {
		daoLivro.inserir( beanLivro );
		return "livro";
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public DataModel getConsultarLivro(){
		ArrayList< LivroVO > listaLivro = new LivroDAO().consultarTodos();
		consultarLivro = new ListDataModel(listaLivro);
		return consultarLivro;
	}

	public ArrayList <LivroVO> getLivros() {
		ArrayList< LivroVO > listaLivro = new LivroDAO().consultarTodos();		
		return listaLivro;
	}	
	
	public String prepararAlterar() {
		beanLivro = (LivroVO) ( consultarLivro.getRowData() );
		return "alterarLivro";
	}

	public String alterar() {
		daoLivro.alterar( beanLivro );
		return "livro";
	}
	
	public String excluir(){
		beanLivro = (LivroVO) (consultarLivro.getRowData() );
		daoLivro.excluir( beanLivro );
		return "livro";
	}

	public String descricao(int id){
		LivroVO livro = daoLivro.consultarPorId( id );
		return livro.getDescricao();
	}
	
	/**
     * Método responsável por retornar o valor do atributo beanLivro.
     * @return LivroVO beanLivro - beanLivro a ser retornado(a).
     */
    public final LivroVO getBeanLivro() {
    	return beanLivro;
    }

	/**
     * Método responsável por atribuir o valor ao atributo beanLivro.
     * @param LivroVO beanLivro - beanLivro a ser atribuido(a).
     */
    public final void setBeanLivro( LivroVO beanLivro ) {
    	this.beanLivro = beanLivro;
    }

	/**
     * Método responsável por retornar o valor do atributo daoLivro.
     * @return LivroDAO daoLivro - daoLivro a ser retornado(a).
     */
    public final LivroDAO getDaoLivro() {
    	return daoLivro;
    }

	/**
     * Método responsável por atribuir o valor ao atributo daoLivro.
     * @param LivroDAO daoLivro - daoLivro a ser atribuido(a).
     */
    public final void setDaoLivro( LivroDAO daoLivro ) {
    	this.daoLivro = daoLivro;
    }

	/**
     * Método responsável por atribuir o valor ao atributo consultarLivro.
     * @param DataModel consultarLivro - consultarLivro a ser atribuido(a).
     */
    public final void setConsultarLivro( @SuppressWarnings("rawtypes") DataModel consultarLivro ) {
    	this.consultarLivro = consultarLivro;
    }
	
	
}//Fim da Classe
