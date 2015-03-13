package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.WorldCupController;

public class AddPlayerDialog extends JDialog {
	
	public static final String NAME_LABEL = "Name : ";
	public static final String AGE_LABEL = "Age : ";
	public static final String CAPS_LABEL = "Caps : ";
	public static final String GOALS_LABEL = "Goals : ";
	public static final String ADD_PLAYER_BUTTON_LABEL = "Add Player";
	public static final String CLOSE_BUTTON_LABEL = "Close";
	
	//These are declared at this level so that when the data 
	//from these fields is being "gathered", they can be seen
	//by the ActionListener which will be responding to a click
	//on the "Add Player" button.
	private JTextField nameField;
	private JTextField ageField;
	private JTextField capsField;
	private JTextField goalsScoredField;
	
	private JButton addPlayerButton;
	
	public AddPlayerDialog(JFrame owner, String title)
	{
		super(owner, title);
		this.getContentPane().add(createPlayerDetailsPanel());
	}
	
	private JPanel createPlayerDetailsPanel()
	{
		JPanel playerDetailsPanel = new JPanel();
		BoxLayout boxL = 
				new BoxLayout(playerDetailsPanel, BoxLayout.Y_AXIS);
		playerDetailsPanel.setLayout(boxL);
		
		//Create Name Panel
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel nameLabel = new JLabel(AddPlayerDialog.NAME_LABEL);
		this.nameField = new JTextField(30);
		namePanel.add(nameLabel);
		namePanel.add(this.nameField);
		
		playerDetailsPanel.add(namePanel);
		
		//Create Age Panel
		JPanel agePanel = new JPanel();
		agePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel ageLabel = new JLabel(AddPlayerDialog.AGE_LABEL);
		this.ageField = new JTextField(3);
		agePanel.add(ageLabel);
		agePanel.add(this.ageField);
		
		playerDetailsPanel.add(agePanel);
		
		//Create Caps Panel
		JPanel capsPanel = new JPanel();
		capsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel capsLabel = new JLabel(AddPlayerDialog.CAPS_LABEL);
		this.capsField = new JTextField(3);
		capsPanel.add(capsLabel);
		capsPanel.add(this.capsField);
		
		playerDetailsPanel.add(capsPanel);

		//Create Goals Panel
		JPanel goalsPanel = new JPanel();
		goalsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel goalsLabel = new JLabel(AddPlayerDialog.GOALS_LABEL);
		this.goalsScoredField = new JTextField(3);
		goalsPanel.add(goalsLabel);
		goalsPanel.add(this.goalsScoredField);
		
		playerDetailsPanel.add(goalsPanel);
		
		//Create a button panel
		JPanel buttonPanel = new JPanel();		
		this.addPlayerButton = new JButton(AddPlayerDialog.ADD_PLAYER_BUTTON_LABEL);
		
		AddPlayerButtonListener buttonListener = new AddPlayerButtonListener();
		this.addPlayerButton.addActionListener(buttonListener);
		
		buttonPanel.add(addPlayerButton);
		
		JButton closeButton = new JButton(AddPlayerDialog.CLOSE_BUTTON_LABEL);
		//Anonymous inner class for close button listener
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		
		buttonPanel.add(closeButton);
		playerDetailsPanel.add(buttonPanel);
		
		return playerDetailsPanel;
	}
	
	//Inner class as ActionListener for "Add Player" button
	private class AddPlayerButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Gather the information entered in the text
			//fields of the Add Player dialog. 
			//Use Integer.parseInt to convert String representations
			//of numbers to their int equivalent.
			String name = nameField.getText();
			int age = Integer.parseInt(ageField.getText());
			int caps = Integer.parseInt(capsField.getText());
			int goals = Integer.parseInt(goalsScoredField.getText());
			
			//Call the createPlayer method of the controller and
			//pass it the data gathered from the GUI.
			WorldCupController.getInstance().
				createPlayer(name, age, caps, goals);
			
			dispose();
		}
	}
}
