package br.com.trabalhoPrimeFaces.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.trabalhoPrimeFaces.abstractdao.AbstractDAO;
import br.com.trabalhoPrimeFaces.persistence.LivroVO;

/**
 * 
 * DAO - Data Access Object
 * Classe de conexão ao banco para os livros
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

public class LivroDAO extends AbstractDAO{
	
	public void inserir( LivroVO vo ) {

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
	 * Método responsável por alterar uma LivroVO na base de dados com o auxílio
	 * da framework Hibernate.
	 * 
	 * @param LivroVO vo - Objeto contendo os dados a serem alterados.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 */
	
	public void alterar( LivroVO vo ) {

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
	 * Método responsável por excluir um LivroVO na base de dados com o auxílio da
	 * framework Hibernate.
	 * 
	 * @param LivroVO vo - Objeto contendo os dados a serem excluidos.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 *
	 */
	public void excluir( LivroVO vo ) {

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

	}//Fim do método

	/**
	 * Método responsável por consultar um livro na base de dados com base em seu codigo.
	 * Este método de consulta utilizou uma NamedQuery para seu funcionamento.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1	 
	 * 
	 * @param Integer id - Id do livro a ser consultado.
	 * @return LivroVO - Livro encontrado com o código informado.
	 */
	public LivroVO consultarPorId( Integer id ) {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			/*Criando e inicializando uma variavel responsável por buscar a nossa 
			NamedQuery criada no VO deixando-a preparada para o Hibernate executa-la.*/
			Query query = sessao.getNamedQuery( "LivroVO.consultarPorId" );
			query.setInteger( "idParametro", id );

			// Executando a Query retornando o casting de seu resultado.
			return (LivroVO) query.uniqueResult();
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
	public ArrayList< LivroVO > consultarTodos() {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Crimando uma HQL(Hibernate Qury Language) como se estivessemos criando uma NamedQuery
			final String HQL = "SELECT livro FROM LivroVO livro ORDER BY livro.descricao";

			/*Criando e inicializando uma variavel responsável por criar uma Query
			com base na nossa HQL criada acima deixando-a preparada para o 
			Hibernate executa-la.*/
			Query query = sessao.createQuery( HQL );

			return (ArrayList< LivroVO >) query.list();
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
