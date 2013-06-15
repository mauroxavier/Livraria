package testes;

import org.junit.Test;

import br.com.trabalhoPrimeFaces.dao.FuncionarioDAO;
import br.com.trabalhoPrimeFaces.persistence.FuncionarioVO;

/**
 * 
 * Classe responsável por realizar os testes unitarios do sistema.
 * 
 * Estamos utilizando aqui o JUnit 4.10
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013 16:58:40
 * @version 1.0
 */
public class TestaFuncionario{

	@Test
	public void testaInserir() {
		//Criando funcionario de inserção
		FuncionarioVO vo = new FuncionarioVO( null, "Augusto", "augusto", "12345" );

		//Instanciando DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.inserir( vo );
	}//Fim do método

	public void testaAlterar() {

		FuncionarioVO vo = new FuncionarioVO( null, "André", "andre", "123" );

		FuncionarioDAO dao = new FuncionarioDAO();
		dao.alterar( vo );
	}//Fim do método

	public void testarConsultarPorId() {
		// Instanciando nosso DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		System.out.println( dao.consultarPorId( 1 ) );
	}

	public void testarConsultarTodos() {
		// Instanciando nosso DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		System.out.println( dao.consultarTodos() );
	}
	
	public void testarExcluir(){		
		// Criando o Idioma a ser inserido.
		FuncionarioVO vo = new FuncionarioVO(1,"UlaUla", "lá", "123");
		
		// Instanciando nosso DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.excluir(vo);
	}
	
}
