package br.com.trabalhoPrimeFaces.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import ManagedBeans.MBAutor;
import ManagedBeans.MBCategoria;
import ManagedBeans.MBEditora;

/**
 * 
 * Classe principal da representação dos livros, com suas características e métodos
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
@Table( name = "livro" )
@NamedQueries( value = { @NamedQuery( name = "LivroVO.consultarPorId", query = "SELECT livro FROM LivroVO livro WHERE livro.id = :idParametro" ) } )
public final class LivroVO implements Serializable{

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name = "id")
	private Integer id;
	@Column(name = "descricao")
	private String descricao;
	@Column(name = "preco")
	private Float preco;
	
	@JoinColumn(name = "categoria", referencedColumnName="id")
	private Integer categoria;
	
	@JoinColumn(name = "autor", referencedColumnName="id")
	private Integer autor;

	@JoinColumn(name = "editora", referencedColumnName="id")
	private Integer editora;
		

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

	public final Integer getCategoria() {
		return categoria;
	}

	public final Integer getAutor() {
		return autor;
	}

	/**
	 * Retorna nome do autor vinculado ao livro
	 * @autor Mauro Xavier
	 * @since 09/06/2013
	 */	
	public final String getAutorString() {
		MBAutor cAutor = new MBAutor();
		if (cAutor.nome(autor) == null) 
			return " ";
		else
			return cAutor.nome(autor);
	}

	/**
	 * Retorna nome da categoria vinculado ao livro
	 * @autor Mauro Xavier
	 * @since 09/06/2013
	 */	
	public final String getCategoriaString() {
		MBCategoria cCategoria = new MBCategoria();
		if (cCategoria.nome(categoria) == null) 
			return " ";
		else
			return cCategoria.nome(categoria);
	}

	/**
	 * Retorna nome da editora vinculado ao livro
	 * @autor Mauro Xavier
	 * @since 09/06/2013
	 */	
	public final String getEditoraString() {
		MBEditora cEditora = new MBEditora();
		if (cEditora.nome(editora) == null) 
			return " ";
		else
			return cEditora.nome(editora);
	}
	
	public final Integer getEditora() {
		return editora;
	}
	
	public final void setId( Integer id ) {
		this.id = id;
	}

	public final void setCategoria( Integer categoria ) {
		this.categoria = categoria;
	}

	public final void setEditora( Integer editora ) {
		this.editora = editora;
	}

	public final void setAutor( Integer autor ) {
		this.autor = autor;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final void setDescricao( String descricao ) {
		this.descricao = descricao;
	}

	public final Float getPreco() {
		return preco;
	}

	public final void setPreco( Float preco ) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( descricao == null ) ? 0 : descricao.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( preco == null ) ? 0 : preco.hashCode() );
		result = prime * result + ( ( autor == null ) ? 0 : autor.hashCode() );
		result = prime * result + ( ( categoria == null ) ? 0 : categoria.hashCode() );
		result = prime * result + ( ( editora == null ) ? 0 : editora.hashCode() );
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
		LivroVO other = (LivroVO) obj;
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
		if ( preco == null ) {
			if ( other.preco != null )
				return false;
		} else if ( !preco.equals( other.preco ) )
			return false;
		if ( autor == null ) {
			if ( other.autor != null )
				return false;
		} else if ( !autor.equals( other.autor ) )
			return false;
		if ( categoria == null ) {
			if ( other.categoria != null )
				return false;
		} else if ( !categoria.equals( other.categoria ) )
			return false;
		if ( editora == null ) {
			if ( other.editora != null )
				return false;
		} else if ( !editora.equals( other.editora ) )
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "LivroVO [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", autor=" + autor + ", categoria=" + categoria + ", editora=" + editora + "]";
	}

	/**
	 * 
	 * M�todo padr�o do Hibernate
	 * 
	 * 
	 * @author Augusto C�sar
	 * @since 14/05/2013 13:58:42
	 * @version 1.0
	 */
	public LivroVO(){
		super();
		setId( id );
		setDescricao( descricao );
		setPreco( preco );
		setAutor( autor );
		setCategoria ( categoria );
		setEditora ( editora );
	}

	public LivroVO( Integer id, String descricao, Float preco, Integer autor, Integer categoria, Integer editora ){
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.autor = autor;
		this.categoria = categoria;
		this.editora = editora;
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
