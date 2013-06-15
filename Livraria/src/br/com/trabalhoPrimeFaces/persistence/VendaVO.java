package br.com.trabalhoPrimeFaces.persistence;

import java.io.Serializable;
import java.sql.Date;

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
	
	@Column(name = "data")
	private Date data;
	
	@Column(name ="funcionario_id")
	private FuncionarioVO funcionario;
	
	@Column(name = "cliente_id")
	private ClienteVO cliente;
	
	@Transient
	private String variavelGlobalAuxiliar;

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

    public final FuncionarioVO getFuncionario() {
    	return funcionario;
    }

    public final void setFuncionario( FuncionarioVO funcionario ) {
    	this.funcionario = funcionario;
    }

    public final ClienteVO getCliente() {
    	return cliente;
    }

    public final void setCliente( ClienteVO cliente ) {
    	this.cliente = cliente;
    }

    public final String getVariavelGlobalAuxiliar() {
    	return variavelGlobalAuxiliar;
    }

    public final void setVariavelGlobalAuxiliar( String variavelGlobalAuxiliar ) {
    	this.variavelGlobalAuxiliar = variavelGlobalAuxiliar;
    }

	public VendaVO( Integer id, Date data, FuncionarioVO funcionario, ClienteVO cliente, String variavelGlobalAuxiliar ){
	    super();
	    this.id = id;
	    this.data = data;
	    this.funcionario = funcionario;
	    this.cliente = cliente;
	    this.variavelGlobalAuxiliar = variavelGlobalAuxiliar;
    }

	public VendaVO(){
	    super();
	    setId(id);
	    setData(data);
	    setFuncionario(funcionario);
	    setCliente(cliente);
	    setVariavelGlobalAuxiliar(variavelGlobalAuxiliar);
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
	    result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
	    result = prime * result + ( ( variavelGlobalAuxiliar == null ) ? 0 : variavelGlobalAuxiliar.hashCode() );
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
	    if ( variavelGlobalAuxiliar == null ) {
		    if ( other.variavelGlobalAuxiliar != null )
			    return false;
	    } else if ( !variavelGlobalAuxiliar.equals( other.variavelGlobalAuxiliar ) )
		    return false;
	    return true;
    }

	/**
     * Polimorfico
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	    return "VendaVO [id=" + id + ", data=" + data + ", funcionario=" + funcionario + ", cliente=" + cliente + ", variavelGlobalAuxiliar=" + variavelGlobalAuxiliar + "]";
    }

	@Transient
	public Integer getNumeroAuxiliar() {
		return new Integer( 200 );
	}
	
}//Fim da Classe
