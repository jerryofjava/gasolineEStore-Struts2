package edu.ust.ics.action;
import edu.ust.ics.model.GasolineBean;
import edu.ust.ics.utility.ConnectionUtil;
import java.sql.Connection;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class ComputeGasoline extends ActionSupport implements ModelDriven<GasolineBean>{

	private GasolineBean gas=new GasolineBean();
	
	public GasolineBean getGasolineBean()
	{
		return gas;
	}
	
	public void setGasolineBean(GasolineBean gas)
	{
		this.gas=gas;
	}
	
	public String execute()
	{
		Connection connection = ConnectionUtil.getDBConnection();
		gas.process(connection);
		return SUCCESS;
	}
	
	@Override
	public void validate()
	{
		if(gas.getGasType().trim().length()==0)
		{
			addFieldError("gasType", "Missing entry for gas type");
		}
		if(gas.getLiters()<0)
		{
			addFieldError("liters", "Liters must not be negative");
		}
		if(gas.getCreditNumber().trim().length()==0)
		{
			addFieldError("creditNumber", "Missing entry for credit card number");
		}
		try
		{
			if(gas.luhnTest(gas.getCreditNumber())==false)
			{
				throw new InvalidCreditCardNumberException();
			}
		}
		catch(InvalidCreditCardNumberException e)
		{
			System.out.println("An InvalidCreditCardNumberException occurred");
		}
	}
	
	@Override
	public GasolineBean getModel() {
		return gas;
	}
}

class InvalidCreditCardNumberException extends Exception
{
	public InvalidCreditCardNumberException() 
	{ 
		super(); 
	}
	
	public InvalidCreditCardNumberException(String message) 
	{ 
		super(message); 
	}
}