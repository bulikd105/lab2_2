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
		ProductData product = new ProductData(Id.generate(), new Money(10d), "Product1", ProductType.DRUG, new Date());
		Money net = new Money(15d);
		Tax tax = taxPolicy.calculateTax(product.getType(), net);

	}

}
