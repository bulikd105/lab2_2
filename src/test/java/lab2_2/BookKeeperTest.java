package lab2_2;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import pl.com.bottega.ecommerce.sales.domain.invoicing.RequestItem;

public class BookKeeperTest {

	@Test
	public final void testIssuance_grosAndNetCalculation() 
	{
		//Deklaracje obiektow do testowania
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		BookKeeper bookKeeper = new BookKeeper(invoiceFactory);
		ClientData client = new ClientData(Id.generate(), "New Client");
		InvoiceRequest request = new InvoiceRequest(client);
		
		ProductData product;
		RequestItem item; 
		
		//zestaw danych 1
		product = new ProductData(Id.generate(), new Money(10d), "Product1", ProductType.DRUG, new Date());
		item = new RequestItem(product, 100, new Money(123.5d));
		request.add(item);
		
		//zestaw danych 2
		product = new ProductData(Id.generate(), new Money(2.5), "Product2", ProductType.FOOD, new Date());
		item = new RequestItem(product, 100, new Money(13.6d));
		request.add(item);

		//zestaw danych 3
		product = new ProductData(Id.generate(), new Money(22.5), "Product3", ProductType.FOOD, new Date());
		item = new RequestItem(product, 100, new Money(133.63d));
		request.add(item);
	}	
}
