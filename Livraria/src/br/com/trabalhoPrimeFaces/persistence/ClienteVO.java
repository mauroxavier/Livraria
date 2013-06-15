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
 * Classe principal da representação dos clientes, com suas características e métodos
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
@Table(name = "cliente")
@NamedQueries(value = { @NamedQuery(name = "ClienteVO.consultarPorId", query = "SELECT cliente FROM ClienteVO cliente WHERE cliente.id = :idParametro") })
public final class ClienteVO implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
	
	@Column( name = "nome")
	String nome;
	
	@Column
	String logradouro;
	
	@Column
	Integer numero;
	
	@Column
	String cidade;
	
	@Column
	String estado;
	
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

	public final String getLogradouro() {
    	return logradouro;
    }

	public final void setLogradouro( String logradouro ) {
    	this.logradouro = logradouro;
    }

	public final Integer getNumero() {
    	return numero;
    }

	public final void setNumero( Integer numero ) {
    	this.numero = numero;
    }

	public final String getCidade() {
    	return cidade;
    }

	public final void setCidade( String cidade ) {
    	this.cidade = cidade;
    }

	public final String getEstado() {
    	return estado;
    }

	public final void setEstado( String estado ) {
    	this.estado = estado;
    }

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ( ( cidade == null ) ? 0 : cidade.hashCode() );
	    result = prime * result + ( ( estado == null ) ? 0 : estado.hashCode() );
	    result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
	    result = prime * result + ( ( logradouro == null ) ? 0 : logradouro.hashCode() );
	    result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
	    result = prime * result + ( ( numero == null ) ? 0 : numero.hashCode() );
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
	    ClienteVO other = (ClienteVO) obj;
	    if ( cidade == null ) {
		    if ( other.cidade != null )
			    return false;
	    } else if ( !cidade.equals( other.cidade ) )
		    return false;
	    if ( estado == null ) {
		    if ( other.estado != null )
			    return false;
	    } else if ( !estado.equals( other.estado ) )
		    return false;
	    if ( id == null ) {
		    if ( other.id != null )
			    return false;
	    } else if ( !id.equals( other.id ) )
		    return false;
	    if ( logradouro == null ) {
		    if ( other.logradouro != null )
			    return false;
	    } else if ( !logradouro.equals( other.logradouro ) )
		    return false;
	    if ( nome == null ) {
		    if ( other.nome != null )
			    return false;
	    } else if ( !nome.equals( other.nome ) )
		    return false;
	    if ( numero == null ) {
		    if ( other.numero != null )
			    return false;
	    } else if ( !numero.equals( other.numero ) )
		    return false;
	    return true;
    }

	@Override
    public String toString() {
	    return "Cliente [id=" + id + ", nome=" + nome + ", logradouro=" + logradouro + ", numero=" + numero + ", cidade=" + cidade + ", estado=" + estado + "]";
    }
	
	public ClienteVO(){
	    super();
	    setId( id );
	    setNome( nome );
	    setLogradouro( logradouro );
	    setNumero( numero );
	    setCidade( cidade );
	    setEstado( estado );
    }
	
	
	public ClienteVO( Integer id, String nome, String logradouro, Integer numero, String cidade, String estado ){
	    super();
	    setId( id );
	    setNome( nome );
	    setLogradouro( logradouro );
	    setNumero( numero );
	    setCidade( cidade );
	    setEstado( estado );
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
