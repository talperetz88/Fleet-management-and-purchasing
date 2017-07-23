package unittests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import entity.Invoice;
import entity.OrderHomeFuel;
import entity.Rates;

public class homeFuelTestOver800 {

	@Test
	public void homeFuelTestOver800() throws SQLException, ParseException  
	{
	Invoice invoice1 = new Invoice();
	OrderHomeFuel homefuelorder1 = new OrderHomeFuel();
	Rates rates = new Rates();
	rates.setMaxHomeFuel((float) 5.23);
	
	
	//---------------- Test number 2-----------------///
		homefuelorder1.setAddressToSupply("ort Braude");
		homefuelorder1.setInvitedById(1);
		homefuelorder1.setOrderId(1);
		homefuelorder1.setOrderType("800+");
		homefuelorder1.setQuantity(850);
		homefuelorder1.setSupplyDate("2016/02/03");
		homefuelorder1.setSupplyTime("10:00");

		float price = (float)  ((850*5.23)*0.96);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		invoice1.setPrice((float) ((homefuelorder1.getQuantity()*rates.getMaxHomeFuel())*0.96));
		invoice1.setFuelType("HomeFuel");
		invoice1.setInvoiceId(1);
		invoice1.setOrderDate(dateFormat.parse(homefuelorder1.getSupplyDate()));
		invoice1.setQuantity(850);
		invoice1.SetCustomerId(homefuelorder1.getInvitedById());
		invoice1.setTime(homefuelorder1.getSupplyTime());
		
		assertEquals(invoice1.getPrice(), price,0.0001);
		assertEquals(invoice1.getCustomerId(),1);
		assertEquals(invoice1.getQuantity(),850);
		assertEquals(invoice1.getOrderDate(), dateFormat.parse("2016/02/03"));
		assertEquals(invoice1.getTime(), "10:00");
		}
	
}
