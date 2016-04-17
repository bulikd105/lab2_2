package lab2_2;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.invoicing.BookKeeper;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceFactory;
import pl.com.bottega.ecommerce.sales.domain.invoicing.InvoiceRequest;

public class BookKeeperTest {

	@Test
	public final void testIssuance_grosAndNetCalculation() 
	{
		//Deklaracje obiektow do testowania
		InvoiceFactory invoiceFactory = new InvoiceFactory();
		BookKeeper bookKeeper = new BookKeeper(invoiceFactory);
		ClientData client = new ClientData(Id.generate(), "New Client");
		InvoiceRequest request = new InvoiceRequest(client);
		
	}	
}
