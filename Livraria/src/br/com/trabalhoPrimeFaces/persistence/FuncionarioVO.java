package br.com.trabalhoPrimeFaces.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Classe principal da representação dos funcionários, com suas características e métodos
 * framework Hibernate.
 * 
 * 
 * @author Augusto César Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
 * @since 05/05/2013
 * @author Mauro Xavier
 * @since 07/06/2013
 * @version 1.1
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "funcionario")
@NamedQueries(value = { @NamedQuery(name= "FuncionarioVO.consultarPorId", query = "SELECT funcionario FROM FuncionarioVO funcionario WHERE funcionario.id = :idParametro")} )
public final class FuncionarioVO implements Serializable{
	
	@Id
	/** Informa que o atributo referenciiiia um campo que � primary key no banco de dados */
	@GeneratedValue( strategy = GenerationType.AUTO )
	/** Informa que a coluna deste campo ser� auto-incrementavel */
	@Column( name = "id" )
	/** Informa a qual coluna da tabela do banco de dados o atributo em questa se refere. */
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "senha")
	private String senha;
	/**
	 * @Transient - Informa que a vari�vel em quest�o n�o dever� ser levada em conta pelo
	 *            Hibernate, ou seja, n�o ser� tratada como um atributo e com isso o hibernate saber�
	 *            que ela n�o possui uma coluna no banco de dados relacionado a ela.
	 */
	@Transient
	private String variavelGlobalAuxiliar;
	
	
	public final Integer getId() {
    	return id;
    }
	public final void setId( Integer id ) {
    	this.id = id;
    }
	public final String getNome() {
    	return nome;
    }
	public final void setNome( String nome ) {
    	this.nome = nome;
    }
	public final String getLogin() {
    	return login;
    }
	public final void setLogin( String login ) {
    	this.login = login;
    }
	public final String getSenha() {
    	return senha;
    }
	public final void setSenha( String senha ) {
    	this.senha = senha;
    }
	
	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
	    result = prime * result + ( ( login == null ) ? 0 : login.hashCode() );
	    result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
	    result = prime * result + ( ( senha == null ) ? 0 : senha.hashCode() );
	    return result;
    }
	@Override
    public boolean equals( Object obj ) {
	    if ( this == obj )
		    return true;
	    if ( obj == null )
		    return false;
	    if ( getClass() != obj.getClass() )
		    return false;
	    FuncionarioVO other = (FuncionarioVO) obj;
	    if ( id == null ) {
		    if ( other.id != null )
			    return false;
	    } else if ( !id.equals( other.id ) )
		    return false;
	    if ( login == null ) {
		    if ( other.login != null )
			    return false;
	    } else if ( !login.equals( other.login ) )
		    return false;
	    if ( nome == null ) {
		    if ( other.nome != null )
			    return false;
	    } else if ( !nome.equals( other.nome ) )
		    return false;
	    if ( senha == null ) {
		    if ( other.senha != null )
			    return false;
	    } else if ( !senha.equals( other.senha ) )
		    return false;
	    return true;
    }
	@Override
    public String toString() {
	    return "FuncionarioVO [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + "]";
    }
	
	
	public FuncionarioVO( Integer id, String nome, String login, String senha ){
	    super();
	    setId( id );
	    setNome( nome );
	    setLogin( login );
	    setSenha( senha );
    }
	
	/**
	 * Construtor padr�o exigido pelo Hibernate.
	 * 
	 * M�todo construtor respos�vel por inicializar os atributos e/ou
	 * executar qualquer a��o no momento da cria��o da classe.
	 * 
	 * @author Augusto C�sar Favaretto Lucianetti <augusto_lucianetti@hotmail.de>
	 * @since 05/05/2013 14:32:36
	 * @version 1.0
	 \*/
	public FuncionarioVO(){
	    super();
	    setId( id );
	    setNome( nome );
	    setLogin( login );
	    setSenha( senha );
    }
	
	/**
	 * @Transient - Informa que a vari�vel em quest�o n�o dever� ser levada em conta pelo
	 *            Hibernate, ou seja, n�o ser� tratada como um atributo e com isso o hibernate saber�
	 *            que ela n�o possui uma coluna no banco de dados relacionado a ela.
	 */
	@Transient
	public Integer getNumeroAuxiliar() {
		return new Integer( 200 );
	}
	
	
}//Fim da Classe
