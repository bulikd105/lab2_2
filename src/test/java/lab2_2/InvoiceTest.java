package lab2_2;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Invoice;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceLine;
import pl.com.bottega.ecommerce.sales.domain.invoicing.Tax;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxPolicy;
import pl.com.bottega.ecommerce.sales.domain.invoicing.TaxPolicyImpl;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class InvoiceTest 
{
	@Test
	public void testGrosAndNetCalculation() 
	{
		//Deklaracje obiektow ktore beda uzywane w testach
		ClientData client = new ClientData(Id.generate(), "New Client");
		Invoice invoice = new InvoiceFactory().create(client);
		TaxPolicy taxPolicy = new TaxPolicyImpl();
		ProductData product; 
		Money net;
		Tax tax;
		int quantity;
		
		//Zestaw danych nr 1
		product = new ProductData(Id.generate(), new Money(10d), "Product1", ProductType.DRUG, new Date());
		net = new Money(15d);	
		tax = taxPolicy.calculateTax(product.getType(), net);
		quantity = 7;
		invoice.addItem(new InvoiceLine(product, quantity, net, tax));
		
		//Zestaw danych nr 2
		product = new ProductData(Id.generate(), new Money(5d), "Product2", ProductType.DRUG, new Date());
		quantity = 10;
		net = new Money(10d);
		tax = taxPolicy.calculateTax(product.getType(), net);
		invoice.addItem(new InvoiceLine(product, quantity, net, tax));

		//Zestaw danych nr 3
		product = new ProductData(Id.generate(), new Money(4.5d), "Product3", ProductType.DRUG, new Date());
		quantity = 22;
		net = new Money(5d);
		tax = taxPolicy.calculateTax(product.getType(), net);
		invoice.addItem(new InvoiceLine(product, quantity, net, tax));
		
		//asserThat
		assertThat(invoice.getItems().size(), is(3));
		assertThat(invoice.getGros(), is(new Money(31.5)));
		assertThat(invoice.getNet(), is(new Money(30.0)));
	}
}
