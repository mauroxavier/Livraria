package br.com.trabalhoPrimeFaces.abstractdao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * 
 * Classe abstrata responsavél por gerenciar as requisições de conexão ao banco de dados.
 * Utilizando o Hibernate para adquirir uma sessão aberta.
 *
 * @author Augusto César Favaretto Lucianetti
 * @since 13/05/2013 21:44:59
 * @version 1.0
 */
public abstract class AbstractDAO {
	/**
	 * Declarando uma constante que conterá uma fábrica de sessões do hibernate.
	 */
	private static final SessionFactory SESSION_FACTORY;
	
	/**
	 * Bloco estático responsável por carregar um objeto 
	 * "Configuration" com os dados configurados na TAG (<hibernate-configuration>)
	 * do arquivo hibernate.cfg.xml
	 * PS: Bloco estático garante que seu conteúdo será executado
	 * pelo meno uma(1) vez ao instanciar a classe onde foi escrito.
	 */
	static{
		// Responsável por fazer a leitura do XML criado para o Hibernate
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		
		// Carregando as informações do XML na variavel conf.
		Configuration conf = configuration.configure("hibernate.cfg.xml");
		
		//Construindo uma fábrica de Sessão
		SESSION_FACTORY = conf.buildSessionFactory();
	}//Fim do static
	
	/**	
	 * Retorna uma Sessão aberta.
	 * @return Session - Sessão aberta e configurada.
	 */
	public Session getSessaoAberta(){
		return SESSION_FACTORY.openSession();
	}//Fim do método
	
	
}
