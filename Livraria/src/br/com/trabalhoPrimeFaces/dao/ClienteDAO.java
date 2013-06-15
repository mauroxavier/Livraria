package br.com.trabalhoPrimeFaces.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.trabalhoPrimeFaces.abstractdao.AbstractDAO;
import br.com.trabalhoPrimeFaces.persistence.ClienteVO;

/**
 * 
 * DAO - Data Access Object
 * Classe de conexão ao banco para os clientes
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

public final class ClienteDAO extends AbstractDAO{

	public void inserir( ClienteVO vo ) {

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
	 * Método responsável por alterar um ClienteVO na base de dados com o auxílio
	 * da framework Hibernate.
	 * 
	 * @param ClienteVO vo - Objeto contendo os dados a serem alterados.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 */
	
	public void alterar( ClienteVO vo ) {

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
	 * Método responsável por excluir um ClienteVO na base de dados com o auxílio da
	 * framework Hibernate.
	 * 
	 * @param ClienteVO vo - Objeto contendo os dados a serem excluidos.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 * 
	 */
	public void excluir( ClienteVO vo ) {

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
	 * Método responsável por consultar um idioma na base de dados com base em seu codigo.
	 * Este método de consulta utilizou uma NamedQuery para seu funcionamento.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1 
	 * 
	 * @param Integer id - Id do cliente a ser consultado.
	 * @return ClienteVO - Cliente encontrado com o código informado.
	 */
	public ClienteVO consultarPorId( Integer id ) {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			/*Criando e inicializando uma variavel responsável por buscar a nossa 
			NamedQuery criada no VO deixando-a preparada para o Hibernate executa-la.*/
			Query query = sessao.getNamedQuery( "ClienteVO.consultarPorId" );
			query.setInteger( "idParametro", id );

			// Executando a Query retornando o casting de seu resultado.
			return (ClienteVO) query.uniqueResult();
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
	public ArrayList< ClienteVO > consultarTodos() {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Crimando uma HQL(Hibernate Qury Language) como se estivessemos criando uma NamedQuery
			final String HQL = "SELECT cliente FROM ClienteVO cliente ORDER BY cliente.nome";

			/*Criando e inicializando uma variavel responsável por criar uma Query
			com base na nossa HQL criada acima deixando-a preparada para o 
			Hibernate executa-la.*/
			Query query = sessao.createQuery( HQL );

			return (ArrayList< ClienteVO >) query.list();
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
}//Fim da Classe
