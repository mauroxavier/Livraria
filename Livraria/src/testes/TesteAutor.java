package testes;

import br.com.trabalhoPrimeFaces.dao.AutorDAO;
import br.com.trabalhoPrimeFaces.persistence.AutorVO;




public class TesteAutor{
	
	public static void main( String[ ] args ) {
	    
		//Criando funcionario de inser��o
		AutorVO vo = new AutorVO( null, "teste", "d� certo" );

		//Instanciando DAO
		AutorDAO dao = new AutorDAO();
		dao.inserir( vo );
    }
}
