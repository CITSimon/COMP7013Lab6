package view;

import model.Country;
import controller.CountryFilePersistor;
import controller.IPersistor;
import controller.WorldCupController;

public class WorldCupApplication {

	public static void main(String[] args) 
	{
		//CREATE THE PERSISTOR
		IPersistor persistor = new CountryFilePersistor();
		WorldCupController.getInstance().setPersistor(persistor);
		
		//CREATE THE MODEL
		Country theDataModel = persistor.read();
		
		//CONNECT THE CONTROLLER TO THE MODEL
		WorldCupController.getInstance().setDataModel(theDataModel);
		
		//CREATE THE VIEW
		WorldCupFrame wcf = new WorldCupFrame("World Cup 2015");
		wcf.setSize(600, 300);
		wcf.setVisible(true);
		
		//CONNECT THE CONTROLLER TO THE VIEW
		WorldCupController.getInstance().setGuiReference(wcf);

	}

}
