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
 * Classe principal da representação das editoras, com suas características e métodos
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
@Table(name = "editora")
@NamedQueries(value = { @NamedQuery(name = "EditoraVO.consultarPorId", query = "SELECT editora FROM EditoraVO editora WHERE editora.id = :idParametro")})
public final class EditoraVO implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
	
	@Column (name = "nome")
	String nome;
	
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
	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
	    result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
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
	    EditoraVO other = (EditoraVO) obj;
	    if ( id == null ) {
		    if ( other.id != null )
			    return false;
	    } else if ( !id.equals( other.id ) )
		    return false;
	    if ( nome == null ) {
		    if ( other.nome != null )
			    return false;
	    } else if ( !nome.equals( other.nome ) )
		    return false;
	    return true;
    }
	
	
	@Override
    public String toString() {
	    return "EditoraVO [id=" + id + ", nome=" + nome + "]";
    }
	
	
	public EditoraVO( Integer id, String nome ){
	    super();
	    setId( id );
	    setNome( nome );
    }
	public EditoraVO(){
	    super();
	    setId( id );
	    setNome( nome );
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
	
}
