package com.assignment1;

import java.util.ArrayList;

public class ProductService {
	
	// copying the products in prod ArrayList
	public static ArrayList<Product> prod = Product.productsData();

	// data members to store results from different methods
	 String prodName;
	 Product prodObject;
	 double maxPrice = 0.0;
	 ArrayList<Product> tempList = new ArrayList<>();
	 
	 
	// Should take product code as parameter and return the name of the product
    // from the list of products present in ProductRepository
    // If no product is found for the given product code, return null
	public String findNameByCode(int productCode) {
		
		try {
			prod.forEach(
					data-> {
						// checking if provided product code matches any product's code in data
						if(productCode == data.getProductCode()) {
							prodName = data.getName();
						}
						
					});
			return ("Product Name with the given code : " + prodName);
		} catch (Exception e) {
			prodName = null;
			return ("Product Name with the given code : " + prodName);
		}
	}
	
	
//	Should take product category as a parameter and return the product object having the maximum
//	price in the category provided
//	If no product is found for the given category, return null
	public Product findMaxPriceProduct(String category) {
		try {
			prod.forEach(data->{
				// checking if given category exists in data 
				if(category.equals(data.getCategory())) {
					// if category exists then getting the product with max price in that category
					if(maxPrice < data.getPrice()) {
						maxPrice = data.getPrice();
						prodObject  = data;
					}
					
				}
				
			});
			System.out.println("the name of the product is : "+prodObject.getName() + " and price : "+prodObject.getPrice());
		} catch (Exception e) {
			prodObject = null;
		}
		
		return prodObject;
	}
	
	
//	Should take product category as parameter and return the array of products in the category 
//	provided
//  If no product are found for the given category, return null
	
	public ArrayList<Product> getProductsByCategory(String category){
		try {
			prod.forEach(data->{
				
				// checking if category exists and storing it's products objects in the list
				if(category.equals(data.getCategory())) {
					tempList.add(data);
				}
			});
		} catch (Exception e) {
			tempList = null;
		}
		return tempList;
	}
}
