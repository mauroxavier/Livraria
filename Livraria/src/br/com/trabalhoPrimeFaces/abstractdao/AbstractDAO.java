package br.com.trabalhoPrimeFaces.abstractdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Classe abstrata responsav�l por gerenciar as requisi��es de conex�o ao banco de dados.
 * Utilizando o Hibernate para adquirir uma sess�o aberta.
 *
 * @author Augusto C�sar Favaretto Lucianetti
 * @since 13/05/2013 21:44:59
 * @version 1.0
 */
public abstract class AbstractDAO {
	/**
	 * Declarando uma constante que conter� uma f�brica de sess�es do hibernate.
	 */
	private static final SessionFactory SESSION_FACTORY;
	
	/**
	 * Bloco est�tico respons�vel por carregar um objeto 
	 * "Configuration" com os dados configurados na TAG (<hibernate-configuration>)
	 * do arquivo hibernate.cfg.xml
	 * PS: Bloco est�tico garante que seu conte�do ser� executado
	 * pelo meno uma(1) vez ao instanciar a classe onde foi escrito.
	 */
	static{
		// Respons�vel por fazer a leitura do XML criado para o Hibernate
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		// Carregando as informa��es do XML na variavel conf.
		Configuration conf = configuration.configure("hibernate.cfg.xml");
		
		//Construindo uma f�brica de Sess�o
		SESSION_FACTORY = conf.buildSessionFactory();
	}//Fim do static
	
	/**	
	 * Retorna uma Sess�o aberta.
	 * @return Session - Sess�o aberta e configurada.
	 */
	public Session getSessaoAberta(){
		return SESSION_FACTORY.openSession();
	}//Fim do m�todo
	
	
}
