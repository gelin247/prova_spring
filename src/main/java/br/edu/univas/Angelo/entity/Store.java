package br.edu.univas.Angelo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name = "store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

	@Column(name = "QTD_ESTOQUE")
	private double amountStored;

	@Column(name = "QTD_MIN")
	private double minimumAmount;

	@Column(name = "LOCAL")
	private String location;

	@Column(name = "DATA_ENTRADA")
	private String joinDate;

	@Column(name = "ATIVO")
	private boolean active;

}
