package br.com.allen.agropopshop.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="pedido_produto")
public class PedidoProduto implements Serializable{

	private static final long serialVersionUID = 7845590417454017403L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long idPedido, idProduto;
	
	private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setId_pedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setId_produto(long idProduto) {
		this.idProduto = idProduto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
