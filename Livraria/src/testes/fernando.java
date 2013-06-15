package testes;

import br.com.trabalhoPrimeFaces.dao.FuncionarioDAO;
import br.com.trabalhoPrimeFaces.persistence.FuncionarioVO;

public class fernando{

	/**
	 * Método responsável por
	 *
	 * @param args
	 *
	 * @author Gabriel Damiani Carvalheiro <gabriel.carvalheiro@gmail.com.br>
	 * @since 14/05/2013 23:06:10
	 * @version 1.0
	 */
	public static void main( String[ ] args ) {
		
		//Criando funcionario de inserção
		FuncionarioVO vo = new FuncionarioVO( null, "fer", "fer", "2288" );

		//Instanciando DAO
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.inserir( vo );

	}

}
