package br.com.trabalhoPrimeFaces.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.trabalhoPrimeFaces.abstractdao.AbstractDAO;
import br.com.trabalhoPrimeFaces.persistence.EditoraVO;
import br.com.trabalhoPrimeFaces.persistence.LivroVO;

/**
 * 
 * DAO - Data Access Object
 * Classe de conexão ao banco para as editoras dos livros
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

public class EditoraDAO extends AbstractDAO{
	
	private String error;
	
	public void inserir( EditoraVO vo ) {

		Transaction transacao = null;

		Session sessao = null;

		try {
			//Pega uma sessão aberta com o Hibernate
			sessao = getSessaoAberta();

			// Iniciando uma bloco de transação
			transacao = sessao.beginTransaction();

			/*
			 * Ação desejada a ser executada no BD.
			 * Após inserir, o método 'save' retorna o id no qual o objeto 
			 * foi inserido.
			 */
			vo.setId( (Integer) sessao.save( vo ) );
			// Confirma a ação executada e fecha a Transação.
			transacao.commit();
		} catch ( Exception e ) {
			/*Caso ocorra algum erro no processo, se a transação tiver sido criada, será
			efetuado um Rollback na mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}
		} finally {
			// Fecha a Sessão com o BD.	
			if ( sessao != null ) {
				sessao.close();
			}
		}
	}//Fim do método

	/**
	 * 
	 * Método responsável por alterar uma EditoraVO na base de dados com o auxílio
	 * da framework Hibernate.
	 * 
	 * @param EditoraVO vo - Objeto contendo os dados a serem alterados.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 */
	
	public void alterar( EditoraVO vo ) {

		// Declarando uma variavel que armazenará uma Transação
		Transaction transacao = null;

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();
			// Iniciando uma bloco de transação
			transacao = sessao.beginTransaction();

			/*
			 * Ação desejada a ser executada no BD.
			 * Após inserir, o método 'save' retorna o id no qual o objeto 
			 * foi inserido.
			 */
			sessao.update( vo );
			// Confirma a após executada e fecha a Transação.
			transacao.commit();
		} catch ( Exception e ) {

			/*Caso ocorra algum erro no processo, se a transação tiver sido criada, será
			efetuado um Rollback na mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}
		} finally {//Fim do catch
			// Fecha a Sessão com o BD.	
			if ( sessao != null ) {
				sessao.close();
			}
		}//Fim do finally
	}//Fim do método

	/**
	 * 
	 * Método responsável por excluir uma EditoraVO na base de dados com o auxílio da
	 * framework Hibernate.
	 * 
	 * @param EditoraVO vo - Objeto contendo os dados a serem excluidos.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 *  
	 */
	public void excluir( EditoraVO vo ) {
		
		if ( deny(vo.getId()) == false ) {

			// Declarando uma variavel que armazenará uma Transação
			Transaction transacao = null;
	
			/*Declarando uma variavel que armazenará uma Sessão do 
			 * hibernate contendo uma conexão aberta e válida.*/
			Session sessao = null;
	
			try {
				// Pega uma Sessão aberta com o Hibernate.
				sessao = getSessaoAberta();
				// Iniciando uma bloco de transação
				transacao = sessao.beginTransaction();
	
				/*
				 * Ação desejada a ser executada no BD.
				 * Após inserir, o método 'save' retorna o id no qual o objeto 
				 * foi inserido.
				 */
				sessao.delete( vo );
				// Confirma a após executada e fecha a Transação.
				transacao.commit();
			} catch ( Exception e ) {
	
				/*Caso ocorra algum erro no processo, se a transação tiver sido criada, será
				efetuado um Rollback na mesma.*/
				if ( transacao != null ) {
					transacao.rollback();
				}
			} finally {//Fim do catch
				// Fecha a Sessão com o BD.	
				if ( sessao != null ) {
					sessao.close();
				}
			}
		} 

	}//Fim do método

	/**
	 * Método que verifica se a categoria está sendo utilizada por um livro
	 * @return Retorna verdadeiro caso a categoria esteja em uso 
	 * @author Mauro da Rocha Xavier Neto
	 * @since 10/06/2013
	 */
	public boolean deny( Integer id ) {
		ArrayList< LivroVO > listaLivro = new LivroDAO().consultarTodos();
	    for (int i = 0; i < listaLivro.size(); i++) {  
	        if (id.equals(listaLivro.get(i).getEditora())) {
				error = "message.show()";
				return true;
	    	}
	    }
   		error = "message.hide()";
		return false;
	} // Fim do método

	public String returnError( Integer id ) {
		deny (id);
		return error;
	}
	
	/**
	 * Método responsável por consultar uma EditoraVO na base de dados com base em seu codigo.
	 * Este método de consulta utilizou uma NamedQuery para seu funcionamento.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 * 
	 * @param Integer id - Id da editora a ser consultado.
	 * @return EditoraVO - Editora encontrada com o código informado.
	 */
	public EditoraVO consultarPorId( Integer id ) {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			/*Criando e inicializando uma variavel responsável por buscar a nossa 
			NamedQuery criada no VO deixando-a preparada para o Hibernate executa-la.*/
			Query query = sessao.getNamedQuery( "EditoraVO.consultarPorId" );
			query.setInteger( "idParametro", id );

			// Executando a Query retornando o casting de seu resultado.
			return (EditoraVO) query.uniqueResult();
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		} finally {//Fim do catch
			// Fecha a Sessão com o BD.	
			if ( sessao != null ) {
				sessao.close();
			}
		}
	}//Fim do método

	@SuppressWarnings("unchecked")
	public ArrayList< EditoraVO > consultarTodos() {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Crimando uma HQL(Hibernate Qury Language) como se estivessemos criando uma NamedQuery
			final String HQL = "SELECT editora FROM EditoraVO editora ORDER BY editora.nome";

			/*Criando e inicializando uma variavel responsável por criar uma Query
			com base na nossa HQL criada acima deixando-a preparada para o 
			Hibernate executa-la.*/
			Query query = sessao.createQuery( HQL );

			return (ArrayList< EditoraVO >) query.list();
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		} finally {//Fim do catch
			// Fecha a Sessão com o BD.	
			if ( sessao != null ) {
				sessao.close();
			}
		}
	}//Fim do método
}
