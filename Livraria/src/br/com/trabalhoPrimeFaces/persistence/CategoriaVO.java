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

/**
 * 
 * Classe principal da representação das categorias, com suas características e métodos
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
@Table( name = "categoria" )
@NamedQueries(value = {@NamedQuery( name = "CategoriaVO.consultarPorId", query = "SELECT categoria FROM CategoriaVO categoria WHERE categoria.id = :idParametro")})
public final class CategoriaVO implements Serializable{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column (name="id")
	private Integer id;

	@Column (name="nome")
	private String nome;

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
	    CategoriaVO other = (CategoriaVO) obj;
	    if ( nome == null ) {
		    if ( other.nome != null )
			    return false;
	    } else if ( !nome.equals( other.nome ) )
		    return false;
	    if ( id == null ) {
		    if ( other.id != null )
			    return false;
	    } else if ( !id.equals( other.id ) )
		    return false;
	    return true;
    }

	@Override
    public String toString() {
	    return "CategoriaVO [id=" + id + ", nome=" + nome + "]";
    }

	public CategoriaVO( Integer id, String nome ){
	    super();
	    setId( id );
	    setNome( nome );
    }
	
	public CategoriaVO(){
	    setId( id );
	    setNome( nome );
    }
}
