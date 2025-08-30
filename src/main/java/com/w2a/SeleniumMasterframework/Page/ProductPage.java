package com.w2a.SeleniumMasterframework.Page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.w2a.SeleniumMasterframework.testsetup.TestSetup;
import com.w2a.SeleniumMasterframework.utils.ElementUtils;

public class ProductPage extends TestSetup {

	private By productPageHeader = By.className("product_label");
	private By addproductToCart = By.xpath("(//button[text()='ADD TO CART'])[1]");
	private By cartlogo = By.xpath("//*[@data-icon='shopping-cart']");
	private String AddToCartXpath = "//div[text()='ProductName']//ancestor::div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']/button";

	public String getHeaderText() {
		return ElementUtils.getElementText(productPageHeader);
	}

	public boolean isPageHeaderDisplayed() {
		return ElementUtils.getWebElement(productPageHeader).isDisplayed();
	}

	public void addProductToCart() {
		ElementUtils.click(addproductToCart);
	}

	public CartPage clickOnCartLogo() {
		ElementUtils.click(cartlogo);
		return new CartPage();
	}

	public void addProductToCart(String productName) {
		By addToCart = By.xpath(AddToCartXpath.replace("ProductName", productName));
		System.out.println("Is Product Displayed->"+ElementUtils.getWebElement(addToCart).isDisplayed());
		ElementUtils.click(addToCart);
		System.out.println("clicked On product");


	}

	public void addProductsToCart(List<String> products) {

		for (int i = 0; i < products.size(); i++) {
			addProductToCart(products.get(i));
		}

	}

	public void addProductsToCart(String products) {

		String[] listOfproducts = products.split(",");

		for (int i = 0; i < listOfproducts.length; i++) {
			System.out.println(listOfproducts[i]);
			addProductToCart(listOfproducts[i]);
		}

	}

}
