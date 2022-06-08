package com.assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
	
	// Data members
	private int productCode;
	private String name;
	private double price;
	private String category;
	
	// parameterized constructor
	public Product(int productCode, String name, double price, String category) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	// getters and setters
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	// method for accessing products
	public static ArrayList<Product> productsData(){
		
		// creating user-defined arrayList of Product type
		ArrayList<Product> products = new ArrayList<>();
		
		// adding values in the arrayList
		products.add(new Product(101,"parle-g",10.0,"biscuit"));
		products.add(new Product(102,"monaco",25.0,"biscuit"));
		products.add(new Product(103,"good-day",50.0,"biscuit"));
		products.add(new Product(501,"Taza",150.0,"tea"));
		products.add(new Product(502,"red label",200.0,"tea"));
		products.add(new Product(504,"Taj mahal",300.0,"tea"));
		products.add(new Product(400,"goldex",10.0,"pen"));
		products.add(new Product(405,"montex",20.0,"pen"));
		return products;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Creating the object of the class ProductServices
		ProductService productServices = new ProductService();
		
		// taking input of product code to get the name of the product
		System.out.println("Enter the product code you want name : ");
		int code = sc.nextInt();
		System.out.println(productServices.findNameByCode(code));
		
		// taking the input of product category 
		System.out.println("Enter the product category : ");
		String category = sc.next();
		System.out.println("The object of product with max price in this category is : " + productServices.findMaxPriceProduct(category));
		
		
		// taking the input of category to get all the products of that category
		System.out.println("Enter the product category : ");
		category = sc.next();
		// Storing the arrayList of product objects in a arrayList to access it here
		ArrayList<Product> result =  productServices.getProductsByCategory(category);
		System.out.println("The list of products belonging to the category are : ");
		// using for each loop to access elements
		for(Product x : result ) {
			System.out.println("[\nProduct Code : "+x.productCode+"\nProduct name : "+x.name+"\nProduct Price : "+x.price+"\nProduct Category : "+x.category+"\n]");
		}
		
		
	}
}
