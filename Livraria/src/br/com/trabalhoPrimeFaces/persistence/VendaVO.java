package br.com.trabalhoPrimeFaces.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import ManagedBeans.MBCliente;
import ManagedBeans.MBFuncionario;
import ManagedBeans.MBLivro;

/**
 * 
 * Classe principal da representação das vendas, com suas características e métodos
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
@Table(name = "venda")
@NamedQueries( value = {@NamedQuery(name = "VendaVO.consultarPorId", query ="SELECT venda FROM VendaVO venda WHERE venda.id = :idParametro")})
public final class VendaVO implements Serializable{
	
	@Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
	
	@Column(name = "data", nullable = false)
	private Date data;
	
	@JoinColumn(name = "funcionario", referencedColumnName="id")
	public Integer funcionario;
	
	@JoinColumn(name = "cliente", referencedColumnName="id")
	public Integer cliente;
	
	@JoinColumn(name = "livro", referencedColumnName="id")
	public Integer livro;
	
    public final Integer getId() {
    	return id;
    }

    public final void setId( Integer id ) {
    	this.id = id;
    }

    public final Date getData() {
    	return data;
    }

    public final void setData( Date data ) {
    	this.data = data;
    }

    public final void setToday() {
    	Date today = new Date();
    	this.data = today;
    }
    
    public final Integer getFuncionario() {
    	return funcionario;
    }

    public final void setFuncionario( Integer funcionario ) {
    	this.funcionario = funcionario;
    }

    public final Integer getCliente() {
    	return cliente;
    }

    public final void setCliente( Integer cliente ) {
    	this.cliente = cliente;
    }
    
    public final Integer getLivro() {
    	return livro;
    }

    public final void setLivro( Integer livro ) {
    	this.livro = livro;
    }

	/**
	 * Retorna nome do funcionario vinculado a venda
	 * @autor Mauro Xavier
	 * @since 09/06/2013
	 */	
	public final String getFuncionarioString() {
		MBFuncionario cFuncionario = new MBFuncionario();
		if (cFuncionario.nome(funcionario) == null) 
			return " ";
		else
			return cFuncionario.nome(funcionario);
	}
	
	/**
	 * Retorna nome do cliente vinculado a venda
	 * @autor Mauro Xavier
	 * @since 09/06/2013
	 */	
	public final String getClienteString() {
		MBCliente cCliente = new MBCliente();
		if (cCliente.nome(cliente) == null) 
			return " ";
		else
			return cCliente.nome(cliente);
	}	
	
	/**
	 * Retorna nome do livro vinculado a venda
	 * @autor Mauro Xavier
	 * @since 09/06/2013
	 */	
	public final String getLivroString() {
		MBLivro cLivro = new MBLivro();
		if (cLivro.descricao(livro) == null) 
			return " ";
		else
			return cLivro.descricao(livro);
	}	

	/**
	 * Retorna nome preço do livro vinculado a venda
	 * @autor Mauro Xavier
	 * @since 09/06/2013
	 */	
	public final Float getPreco() {
		MBLivro cLivro = new MBLivro();
		if (cLivro.preco(livro) == null) 
			return (float) 0.0;
		else
			return cLivro.preco(livro);
	}	
	
	@Override
    public String toString() {
	    return "VendaVO [id=" + id + ", data=" + data + ", funcionario=" + funcionario + ", cliente=" + cliente + ", livro=" + livro + "]";
    }

	public VendaVO( Integer id, Date data, Integer funcionario, Integer cliente, Integer livro ){
	    super();
	    this.id = id;
	    this.data = data;
	    this.funcionario = funcionario;
	    this.cliente = cliente;
	    this.livro = livro;
    }

	public VendaVO(){
	    super();
	    setId(id);
	    setData(data);
	    setFuncionario(funcionario);
	    setCliente(cliente);
	    setLivro(livro);
    }

	/**
     * Polimorfico
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ( ( cliente == null ) ? 0 : cliente.hashCode() );
	    result = prime * result + ( ( data == null ) ? 0 : data.hashCode() );
	    result = prime * result + ( ( funcionario == null ) ? 0 : funcionario.hashCode() );
	    result = prime * result + ( ( livro == null ) ? 0 : livro.hashCode() );
	    result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
	    return result;
    }

	/**
     * Polimorfico
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj ) {
	    if ( this == obj )
		    return true;
	    if ( obj == null )
		    return false;
	    if ( getClass() != obj.getClass() )
		    return false;
	    VendaVO other = (VendaVO) obj;
	    if ( cliente == null ) {
		    if ( other.cliente != null )
			    return false;
	    } else if ( !cliente.equals( other.cliente ) )
		    return false;
	    if ( data == null ) {
		    if ( other.data != null )
			    return false;
	    } else if ( !data.equals( other.data ) )
		    return false;
	    if ( funcionario == null ) {
		    if ( other.funcionario != null )
			    return false;
	    } else if ( !funcionario.equals( other.funcionario ) )
		    return false;
	    if ( id == null ) {
		    if ( other.id != null )
			    return false;
	    } else if ( !id.equals( other.id ) )
		    return false;
	    if ( livro == null ) {
		    if ( other.livro != null )
			    return false;
	    } else if ( !livro.equals( other.livro ) )
		    return false;
	    
	    return true;
    }

}//Fim da Classe
