package controller;

import model.Country;

public interface IPersistor 
{
	public void write(Country dataModel);

	public Country read();

}
