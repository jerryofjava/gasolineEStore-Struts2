package edu.ust.ics.model;
import java.sql.*;

public class GasolineBean {

	private String gasType;
	private double liters;
	private double pricePerLiter;
	private String creditCard;
	private String creditNumber;
	private double purchase;
	private double vat;
	private double total;
	private String tagalog="(none)";
	
	public String getGasType() {
		return gasType;
	}
	
	public void setGasType(String gasType) {
		this.gasType = gasType;
	}
	
	public double getLiters() {
		return liters;
	}
	
	public void setLiters(double liters) {
		this.liters = liters;
	}
	
	public double getPricePerLiter() {
		return pricePerLiter;
	}
	
	public void identifyPrice()
	{
		if(gasType.equals("Unlieded"))
		{
			setPricePerLiter(44);
		}
		else if(gasType.equals("Diesel"))
		{
			setPricePerLiter(38);
		}
		else if(gasType.equals("Premium"))
		{
			setPricePerLiter(50);
		}
	}

	public void setPricePerLiter(double pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}

	public String getCreditCard() {
		return creditCard;
	}
	
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	public String getCreditNumber() {
		return creditNumber;
	}
	
	public static boolean luhnTest(String number){
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++)
        {
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0)
            {
                s1 += digit;
            }
            else
            {
                s2 += 2 * digit;
                if(digit >= 5)
                {
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }
	
	public void setCreditNumber(String creditNumber) {
		this.creditNumber = creditNumber;
	}

	public double getPurchase() {
		return purchase;
	}
	
	public void computePurchase()
	{
		double price;
		price=getLiters()*getPricePerLiter();
		setPurchase(price);
	}

	public void setPurchase(double purchase) {
		this.purchase = purchase;
	}

	public double getVat() {
		return vat;
	}

	public void computeVat()
	{
		double vat;
		vat=purchase*0.12;
		setVat(vat);
	}
	
	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getTotal() {
		return total;
	}
	
	public void computeTotal()
	{
		double total;
		total=purchase+vat;
		setTotal(total);
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void findTagalog()
	{
		String tagalogTotal="";
		boolean isDecimal=false;
		int counter=0;
		for(int i=0;i<=String.valueOf(total).toCharArray().length-1;i++)
		{
			if(String.valueOf(total).toCharArray()[i]=='.')
			{
				isDecimal=true;
				break;
			}
			counter++;
		}
		
		if(counter==1)
		{
			if(String.valueOf(total).toCharArray()[0]=='1')
			{
				tagalogTotal="isang";
			}
			else if(String.valueOf(total).toCharArray()[0]=='2')
			{
				tagalogTotal="dalawang";
			}
			else if(String.valueOf(total).toCharArray()[0]=='3')
			{
				tagalogTotal="tatlong";
			}
			else if(String.valueOf(total).toCharArray()[0]=='4')
			{
				tagalogTotal="apat na";
			}
			else if(String.valueOf(total).toCharArray()[0]=='5')
			{
				tagalogTotal="limang";
			}
			else if(String.valueOf(total).toCharArray()[0]=='6')
			{
				tagalogTotal="anim na";
			}
			else if(String.valueOf(total).toCharArray()[0]=='7')
			{
				tagalogTotal="pitong";
			}
			else if(String.valueOf(total).toCharArray()[0]=='8')
			{
				tagalogTotal="walong";
			}
			else if(String.valueOf(total).toCharArray()[0]=='9')
			{
				tagalogTotal="siyam na";
			}
		}
		else if(counter==2)
		{
			if(String.valueOf(total).toCharArray()[0]=='1')
			{
				tagalogTotal="sampung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='2')
			{
				tagalogTotal="dalawampung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='3')
			{
				tagalogTotal="tatlumpung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='4')
			{
				tagalogTotal="apatnapung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='5')
			{
				tagalogTotal="limampung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='6')
			{
				tagalogTotal="animnapung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='7')
			{
				tagalogTotal="pitumpung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='8')
			{
				tagalogTotal="walompung";
			}
			else if(String.valueOf(total).toCharArray()[0]=='9')
			{
				tagalogTotal="siyamnapung";
			}
			
			tagalogTotal+=" at ";
			
			if(String.valueOf(total).toCharArray()[1]=='1')
			{
				tagalogTotal+="isang";
			}
			else if(String.valueOf(total).toCharArray()[1]=='2')
			{
				tagalogTotal+="dalawang";
			}
			else if(String.valueOf(total).toCharArray()[1]=='3')
			{
				tagalogTotal+="tatlong";
			}
			else if(String.valueOf(total).toCharArray()[1]=='4')
			{
				tagalogTotal+="apat na";
			}
			else if(String.valueOf(total).toCharArray()[1]=='5')
			{
				tagalogTotal+="limang";
			}
			else if(String.valueOf(total).toCharArray()[1]=='6')
			{
				tagalogTotal+="anim na";
			}
			else if(String.valueOf(total).toCharArray()[1]=='7')
			{
				tagalogTotal+="pitong";
			}
			else if(String.valueOf(total).toCharArray()[1]=='8')
			{
				tagalogTotal+="walong";
			}
			else if(String.valueOf(total).toCharArray()[1]=='9')
			{
				tagalogTotal+="siyam na";
			}
		}
		else if(counter==3)
		{
			if(String.valueOf(total).toCharArray()[0]=='1')
			{
				tagalogTotal="isang daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='2')
			{
				tagalogTotal="dalawang daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='3')
			{
				tagalogTotal="tatlong daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='4')
			{
				tagalogTotal="apat na daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='5')
			{
				tagalogTotal="limang daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='6')
			{
				tagalogTotal="anim na daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='7')
			{
				tagalogTotal="pitong daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='8')
			{
				tagalogTotal="walong daan";
			}
			else if(String.valueOf(total).toCharArray()[0]=='9')
			{
				tagalogTotal="siyam na daan";
			}
			
			tagalogTotal+=" at ";
			
			if(String.valueOf(total).toCharArray()[1]=='1')
			{
				tagalogTotal+="sampung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='2')
			{
				tagalogTotal+="dalawampung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='3')
			{
				tagalogTotal+="tatlumpung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='4')
			{
				tagalogTotal+="apatnapung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='5')
			{
				tagalogTotal+="limampung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='6')
			{
				tagalogTotal+="animnapung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='7')
			{
				tagalogTotal+="pitumpung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='8')
			{
				tagalogTotal+="walompung";
			}
			else if(String.valueOf(total).toCharArray()[1]=='9')
			{
				tagalogTotal+="siyamnapung";
			}
			
			tagalogTotal+=" ";
			
			if(String.valueOf(total).toCharArray()[2]=='1')
			{
				tagalogTotal+="isang";
			}
			else if(String.valueOf(total).toCharArray()[2]=='2')
			{
				tagalogTotal+="dalawang";
			}
			else if(String.valueOf(total).toCharArray()[2]=='3')
			{
				tagalogTotal+="tatlong";
			}
			else if(String.valueOf(total).toCharArray()[2]=='4')
			{
				tagalogTotal+="at apat na";
			}
			else if(String.valueOf(total).toCharArray()[2]=='5')
			{
				tagalogTotal+="limang";
			}
			else if(String.valueOf(total).toCharArray()[2]=='6')
			{
				tagalogTotal+="at anim na";
			}
			else if(String.valueOf(total).toCharArray()[2]=='7')
			{
				tagalogTotal+="pitong";
			}
			else if(String.valueOf(total).toCharArray()[2]=='8')
			{
				tagalogTotal+="walong";
			}
			else if(String.valueOf(total).toCharArray()[2]=='9')
			{
				tagalogTotal+="at siyam na";
			}			
		}
		else if(counter==4)
		{
			if(String.valueOf(total).toCharArray()[0]=='1')
			{
				tagalogTotal="isang libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='2')
			{
				tagalogTotal="dalawang libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='3')
			{
				tagalogTotal="tatlong libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='4')
			{
				tagalogTotal="apat na libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='5')
			{
				tagalogTotal="limang libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='6')
			{
				tagalogTotal="anim na libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='7')
			{
				tagalogTotal="pitong libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='8')
			{
				tagalogTotal="walong libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='9')
			{
				tagalogTotal="siyam na libo";
			}
			
			tagalogTotal+=" at ";
			
			if(String.valueOf(total).toCharArray()[1]=='1')
			{
				tagalogTotal+="isang daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='2')
			{
				tagalogTotal+="dalawang daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='3')
			{
				tagalogTotal+="tatlong daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='4')
			{
				tagalogTotal+="apat na daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='5')
			{
				tagalogTotal+="limang daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='6')
			{
				tagalogTotal+="anim na daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='7')
			{
				tagalogTotal+="pitong daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='8')
			{
				tagalogTotal+="walong daan";
			}
			else if(String.valueOf(total).toCharArray()[1]=='9')
			{
				tagalogTotal+="siyam na daan";
			}
			
			tagalogTotal+=" ";
			
			if(String.valueOf(total).toCharArray()[2]=='1')
			{
				tagalogTotal+="sampung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='2')
			{
				tagalogTotal+="dalawampung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='3')
			{
				tagalogTotal+="tatlumpung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='4')
			{
				tagalogTotal+="apatnapung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='5')
			{
				tagalogTotal+="limampung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='6')
			{
				tagalogTotal+="animnapung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='7')
			{
				tagalogTotal+="pitumpung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='8')
			{
				tagalogTotal+="walompung";
			}
			else if(String.valueOf(total).toCharArray()[2]=='9')
			{
				tagalogTotal+="siyamnapung";
			}
			
			tagalogTotal+=" ";
			
			if(String.valueOf(total).toCharArray()[3]=='1')
			{
				tagalogTotal+="isang";
			}
			else if(String.valueOf(total).toCharArray()[3]=='2')
			{
				tagalogTotal+="dalawang";
			}
			else if(String.valueOf(total).toCharArray()[3]=='3')
			{
				tagalogTotal+="tatlong";
			}
			else if(String.valueOf(total).toCharArray()[3]=='4')
			{
				tagalogTotal+="at apat na";
			}
			else if(String.valueOf(total).toCharArray()[3]=='5')
			{
				tagalogTotal+="limang";
			}
			else if(String.valueOf(total).toCharArray()[3]=='6')
			{
				tagalogTotal+="at anim na";
			}
			else if(String.valueOf(total).toCharArray()[3]=='7')
			{
				tagalogTotal+="pitong";
			}
			else if(String.valueOf(total).toCharArray()[3]=='8')
			{
				tagalogTotal+="walong";
			}
			else if(String.valueOf(total).toCharArray()[3]=='9')
			{
				tagalogTotal+="at siyam na";
			}			
		}
		else if(counter==5)
		{
			if(String.valueOf(total).toCharArray()[0]=='1')
			{
				tagalogTotal="sampung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='2')
			{
				tagalogTotal="dalawampung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='3')
			{
				tagalogTotal="tatlumpung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='4')
			{
				tagalogTotal="apatnapung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='5')
			{
				tagalogTotal="limampung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='6')
			{
				tagalogTotal="animnapung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='7')
			{
				tagalogTotal="pitongpung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='8')
			{
				tagalogTotal="walongpung libo";
			}
			else if(String.valueOf(total).toCharArray()[0]=='9')
			{
				tagalogTotal="siyamnampung libo";
			}
			
			tagalogTotal+=" at ";
			
			if(String.valueOf(total).toCharArray()[1]=='1')
			{
				tagalogTotal+="isang libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='2')
			{
				tagalogTotal+="dalawang libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='3')
			{
				tagalogTotal+="tatlong libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='4')
			{
				tagalogTotal+="apat na libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='5')
			{
				tagalogTotal+="limang libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='6')
			{
				tagalogTotal+="anim na libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='7')
			{
				tagalogTotal+="pitong libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='8')
			{
				tagalogTotal+="walong libo";
			}
			else if(String.valueOf(total).toCharArray()[1]=='9')
			{
				tagalogTotal+="siyam na libo";
			}
			
			tagalogTotal+=" ";
			
			if(String.valueOf(total).toCharArray()[2]=='1')
			{
				tagalogTotal+="isang daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='2')
			{
				tagalogTotal+="dalawang daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='3')
			{
				tagalogTotal+="tatlong daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='4')
			{
				tagalogTotal+="apat na daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='5')
			{
				tagalogTotal+="limang daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='6')
			{
				tagalogTotal+="anim na daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='7')
			{
				tagalogTotal+="pitong daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='8')
			{
				tagalogTotal+="walong daan";
			}
			else if(String.valueOf(total).toCharArray()[2]=='9')
			{
				tagalogTotal+="siyam na daan";
			}
			
			tagalogTotal+=" ";
			
			if(String.valueOf(total).toCharArray()[3]=='1')
			{
				tagalogTotal+="sampung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='2')
			{
				tagalogTotal+="dalawampung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='3')
			{
				tagalogTotal+="tatlumpung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='4')
			{
				tagalogTotal+="apatnapung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='5')
			{
				tagalogTotal+="limampung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='6')
			{
				tagalogTotal+="animnapung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='7')
			{
				tagalogTotal+="pitumpung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='8')
			{
				tagalogTotal+="walompung";
			}
			else if(String.valueOf(total).toCharArray()[3]=='9')
			{
				tagalogTotal+="siyamnapung";
			}
			
			tagalogTotal+=" ";
			
			if(String.valueOf(total).toCharArray()[4]=='1')
			{
				tagalogTotal+="isang";
			}
			else if(String.valueOf(total).toCharArray()[4]=='2')
			{
				tagalogTotal+="dalawang";
			}
			else if(String.valueOf(total).toCharArray()[4]=='3')
			{
				tagalogTotal+="tatlong";
			}
			else if(String.valueOf(total).toCharArray()[4]=='4')
			{
				tagalogTotal+="at apat na";
			}
			else if(String.valueOf(total).toCharArray()[4]=='5')
			{
				tagalogTotal+="limang";
			}
			else if(String.valueOf(total).toCharArray()[4]=='6')
			{
				tagalogTotal+="at anim na";
			}
			else if(String.valueOf(total).toCharArray()[4]=='7')
			{
				tagalogTotal+="pitong";
			}
			else if(String.valueOf(total).toCharArray()[4]=='8')
			{
				tagalogTotal+="walong";
			}
			else if(String.valueOf(total).toCharArray()[4]=='9')
			{
				tagalogTotal+="at siyam na";
			}			
		}
		
			tagalogTotal+=" piso";
			if(tagalogTotal.equals(" piso"))
			{
				tagalogTotal="(none)";
			}
			setTagalog(tagalogTotal);
		}

	public String getTagalog() {
		return tagalog;
	}

	public void setTagalog(String tagalog) {
		this.tagalog = tagalog;
	}
	
	public void process(Connection connection)
	{
		identifyPrice();
		computePurchase();
		computeVat();
		computeTotal();
		findTagalog();
		insertToDB(connection);
	}
	
	public void insertToDB(Connection connection)
	{
		try {
			String sql = "Insert into customerpurchase(gasType, liters, creditCard, " +
				"creditNumber, purchase, vat, total, tagalog) " +
				"values (?,?,?,?,?,?,?,?)";
			
			PreparedStatement ptsmnt = connection.prepareStatement(sql);
			ptsmnt.setString(1, gasType);
			ptsmnt.setDouble(2, liters);
			ptsmnt.setString(3, creditCard);
			ptsmnt.setString(4, creditNumber);
			ptsmnt.setDouble(5, purchase);
			ptsmnt.setDouble(6, vat);
			ptsmnt.setDouble(7, total);
			ptsmnt.setString(8, tagalog);
			
			//turn-off the auto-commit mode
			connection.setAutoCommit(false);
			
			//now commit to the database
			ptsmnt.executeUpdate();
			connection.commit();
		} catch (SQLException sqle) 
		{
			sqle.printStackTrace();
		}	
			try 
			{
				connection.rollback();
			}	
			 catch (SQLException sqle1) 
			{
				sqle1.printStackTrace();
			}
		}
	
	public ResultSet getGasoline(Connection connection)
	{
		ResultSet gasoline=null;
		try {
		String sql = "select * from customerpurchase";
			
		PreparedStatement ptstmnt = connection.prepareStatement(sql);
		gasoline = ptstmnt.executeQuery();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return gasoline;
	}
}

