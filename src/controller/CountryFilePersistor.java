package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Country;

public class CountryFilePersistor implements IPersistor
{		
	private static final String FILE_LOCATION = "C:\\WorldCup\\country.dat";
		
	public void write(Country theCountry)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(FILE_LOCATION);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(theCountry);
			oos.close();
		}
		catch(IOException ioex)
		{
			System.out.println(ioex.getMessage());
		}
		
	}
	
	public Country read()
	{
		try
		{
			FileInputStream fis = new FileInputStream(FILE_LOCATION);
			ObjectInputStream ois = new ObjectInputStream(fis);
			//We know that a Country object was serialized INTO
			//the file, therefore a Country object MUST be coming
			//out of the file => We can cast it to a Country object.
			Country serializedObject = (Country)ois.readObject();
			return serializedObject;
		}
		catch(IOException ioex)
		{
			System.out.println(ioex.getMessage());
		}
		catch(ClassNotFoundException cnfe)
		{
			System.out.println(cnfe.getMessage());
		}
		//We will only come to this piece of code if something has
		//failed in relation to reading the serialized file above.
		//If we arrive here we still must return something. 
		return null;
	}
	
}
