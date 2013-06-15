package br.com.trabalhoPrimeFaces.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.trabalhoPrimeFaces.abstractdao.AbstractDAO;
import br.com.trabalhoPrimeFaces.persistence.FuncionarioVO;
import br.com.trabalhoPrimeFaces.persistence.VendaVO;

/**
 * DAO - Data Access Object
 * Classe de conexão ao banco para os funcionários
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

public class FuncionarioDAO extends AbstractDAO{
	
	private String error;
	
	public void inserir( FuncionarioVO vo ) {

		// Declarando uma variavel que armazenará uma Transação
		Transaction transacao = null;

		/* Declarando uma variavál que armazenará uma Sessão do 
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
			vo.setId( (Integer) sessao.save( vo ) );
			// Confirma a ação executada e fecha a Transação.
			transacao.commit();
		} catch ( Exception e ) {

			/*Caso ocorra algum erro no processo, se a transação tiver sido criada, será
			 * 			efetuado um Rollback na mesma.*/
			if ( transacao != null ) {
				transacao.rollback();
			}
		} finally {
			// Fecha a Sessão com o BD.	
			if ( sessao != null ) {
				sessao.close();
			}
		}//Fim do finally
	}//Fim do método
	
	
	/**
	 * 
	 * Método responsável por alterar uma FuncionarioVO na base de dados com o auxílio
	 * da framework Hibernate.
	 * 
	 * @param FuncionarioVO vo - Objeto contendo os dados a serem alterados.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 */
	
	public void alterar( FuncionarioVO vo ) {

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
				e.printStackTrace();
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
	 * Método responsável por excluir um FuncionarioVO na base de dados com o auxílio da
	 * framework Hibernate.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1 
	 * 
	 * @param FuncionarioVO vo - Objeto contendo os dados a serem excluidos. 
	 */
	public void excluir( FuncionarioVO vo ) {

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

		} // Fim da verificação do livro
		
	}//Fim do método	
	/**
	 * Método que verifica se o funcionário já efetuou alguma venda
	 * @return Retorna verdadeiro caso o funcionário já tenha vendido algum livro 
	 * @author Mauro da Rocha Xavier Neto
	 * @since 10/06/2013
	 */
	public boolean deny( Integer id ) {
		ArrayList< VendaVO > listaVenda = new VendaDAO().consultarTodos();
	    for (int i = 0; i < listaVenda.size(); i++) {  
	        if ( id.equals(listaVenda.get(i).getFuncionario()) ) {
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
	 * Método responsável por consultar um funcionario na base de dados com base em seu codigo.
	 * Este método de consulta utilizou uma NamedQuery para seu funcionamento.
	 * 
	 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013
	 * @author Mauro Xavier
	 * @since 07/06/2013
	 * @version 1.1
	 * 
	 * @param Integer id - Id do funcionário a ser consultado.
	 * @return FuncionarioVO - Funcionário encontrado com o código informado.
	 */
	public FuncionarioVO consultarPorId( Integer id ) {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			/*Criando e inicializando uma variavel responsável por buscar a nossa 
			NamedQuery criada no VO deixando-a preparada para o Hibernate executa-la.*/
			Query query = sessao.getNamedQuery( "FuncionarioVO.consultarPorId" );
			query.setInteger( "idParametro", id );

			// Executando a Query retornando o casting de seu resultado.
			return (FuncionarioVO) query.uniqueResult();
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
	public ArrayList< FuncionarioVO > consultarTodos() {

		/*Declarando uma variavel que armazenará uma Sessão do 
		 * hibernate contendo uma conexão aberta e válida.*/
		Session sessao = null;

		try {
			// Pega uma Sessão aberta com o Hibernate.
			sessao = getSessaoAberta();

			// Crimando uma HQL(Hibernate Qury Language) como se estivessemos criando uma NamedQuery
			final String HQL = "SELECT funcionario FROM FuncionarioVO funcionario ORDER BY funcionario.nome";

			/*Criando e inicializando uma variavel responsável por criar uma Query
			com base na nossa HQL criada acima deixando-a preparada para o 
			Hibernate executa-la.*/
			Query query = sessao.createQuery( HQL );

			return (ArrayList< FuncionarioVO >) query.list();
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
