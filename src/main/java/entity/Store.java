package entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;



@Data
@Entity
@Table(name = "store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
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
