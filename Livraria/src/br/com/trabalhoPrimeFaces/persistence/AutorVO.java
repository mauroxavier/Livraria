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
 * Classe principal da representação dos autores, com suas características e métodos
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
@Table(name = "autor") 
@NamedQueries(value = { @NamedQuery(name= "AutorVO.consultarPorId", query = "SELECT autor FROM AutorVO autor WHERE autor.id = :idParametro")} )
public final class AutorVO implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	
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

	public final String getDescricao() {
    	return descricao;
    }

	public final void setDescricao( String descricao ) {
    	this.descricao = descricao;
    }

	@Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ( ( descricao == null ) ? 0 : descricao.hashCode() );
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
	    AutorVO other = (AutorVO) obj;
	    if ( descricao == null ) {
		    if ( other.descricao != null )
			    return false;
	    } else if ( !descricao.equals( other.descricao ) )
		    return false;
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
	    return "AutorVO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
    }

	public AutorVO( Integer id, String nome, String descricao ){
	    super();
	    setId( id );
	    setNome( nome );
	    setDescricao( descricao );
    }
	
	public AutorVO(){
	    super();
	    setId( id );
	    setNome( nome );
	    setDescricao( descricao );
    }
}//Fim da Classe
