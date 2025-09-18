package com.kanchana.requestdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
private	int productid;
private	String name;
private	int price;
private	int stock;
}
