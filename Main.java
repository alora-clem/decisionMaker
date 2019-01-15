package decisionMaker;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Main {
	static ArrayList<String> rest = new ArrayList<String>();
	static ArrayList<String> dessert = new ArrayList<String>();
	static ArrayList<String> activity = new ArrayList<String>();
	static Random rand = new Random(System.currentTimeMillis());
	static JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		rest.add("Mods");
		rest.add("Gay Nineties");
		rest.add("Homeroom");
		rest.add("House of Chicken and Waffles");
		rest.add("Ike's");
		rest.add("Rigatonis");
		rest.add("Chipotle");
		rest.add("Panda Express");
		rest.add("Zacharies");
		rest.add("Iguanas");
		rest.add("Vick's");
		
		dessert.add("Smittens");
		dessert.add("Lords");
		dessert.add("Rita's");
		dessert.add("Quickly");
		dessert.add("T-4");
		dessert.add("Gong Cha");
		
		activity.add("Mini-golf");
		activity.add("Mall");
		activity.add("Bowling");
		activity.add("Mall");
		activity.add("Get coffee");
		activity.add("Get boba");
		activity.add("Watch television");
		activity.add("Play PS4");

		JPanel main = new JPanel(new BorderLayout());
		JButton go = new JButton("Go");
		JComboBox<String> drop = new JComboBox<String>();
		
		drop.addItem("Restaurant");
		drop.addItem("Dessert");
		drop.addItem("Activity");
		drop.addItem("A person to pick what to do");
		
		go.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String choice = (String) drop.getSelectedItem();
				executeChoice(choice);
			}
		});

		JTextField intro = new JTextField("Welcome to Decision Maker!"
				+ " Using the drop down below, choose a topic to generate a decision for.");

		main.add(intro, BorderLayout.NORTH);
		main.add(drop, BorderLayout.CENTER);
		main.add(go, BorderLayout.SOUTH);
		main.setVisible(true);
		intro.setEditable(false);
		frame.add(main);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void executeChoice(String choice) {
		frame.setVisible(false);
		JFrame second = new JFrame();
		JPanel execute = new JPanel(new BorderLayout());
		JButton redo = new JButton("Redo");
		JButton back = new JButton("Back");
		JButton displayAllChoices = new JButton("Display all choices for this topic");
		JTextField theChoice = new JTextField(choice);
		JTextField result = new JTextField("Result: ");
		
		second.setVisible(true);
		second.add(execute);
		theChoice.setEditable(false);
		result.setEditable(false);

		if(choice.equals("A person to pick what to do")){
			theChoice.setText(choice + ": Type names seperated by commas below.");
			
			JTextField input = new JTextField("");
			JButton go = new JButton("Go");
			go.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					ArrayList<String> names = new ArrayList<String>();
					String theInput = input.getText();
					String nameArray[] = theInput.split(", ");
					for(String s : nameArray){
						names.add(s);
					}
					int max = names.size();
					int ans = rand.nextInt(max);
					result.setText("Result: "+ names.get(ans));
				}
			});
			
			execute.add(theChoice, BorderLayout.NORTH);
			execute.add(input, BorderLayout.CENTER);
			execute.add(result, BorderLayout.SOUTH);
			execute.add(go, BorderLayout.EAST);
			execute.add(back, BorderLayout.WEST);
			second.pack();
		}
		else{
			execute.add(theChoice, BorderLayout.NORTH);
			execute.add(result, BorderLayout.CENTER);
			execute.add(redo, BorderLayout.SOUTH);
			execute.add(back, BorderLayout.WEST);
			execute.add(displayAllChoices, BorderLayout.EAST);
			
			if(choice.equals("Restaurant")){
				int max = rest.size();
				int ans = rand.nextInt(max);
				result.setText("Result: "+ rest.get(ans));
			}
			else if(choice.equals("Dessert")){
				int max = dessert.size();
				int ans = rand.nextInt(max);
				result.setText("Result: "+ dessert.get(ans));
			}
			else if(choice.equals("Activity")){
				int max = activity.size();
				int ans = rand.nextInt(max);
				result.setText("Result: "+ activity.get(ans));
			}
			second.pack();
		}
		
		displayAllChoices.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(choice.equals("Restaurant")){
					String list = "";
					for(String s: rest){
						list += s +", ";
					}
					list = list.substring(0, list.length()-2);
					result.setText("Choices: " + list);
				}
				else if(choice.equals("Dessert")){
					String list = "";
					for(String s: dessert){
						list += s +", ";
					}
					list = list.substring(0, list.length()-2);
					result.setText("Choices: " + list);
				}
				else if(choice.equals("Activity")){
					String list = "";
					for(String s: activity){
						list += s +", ";
					}
					list = list.substring(0, list.length()-2);
					result.setText("Choices: " + list);
				}
				second.pack();
			}
		});
		redo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(choice.equals("Restaurant")){
					int max = rest.size();
					int ans = rand.nextInt(max);
					result.setText("Result: "+ rest.get(ans));
				}
				else if(choice.equals("Dessert")){
					int max = dessert.size();
					int ans = rand.nextInt(max);
					result.setText("Result: "+ dessert.get(ans));
				}
				else if(choice.equals("Activity")){
					int max = activity.size();
					int ans = rand.nextInt(max);
					result.setText("Result: "+ activity.get(ans));
				}
				second.pack();
			}
		});
		back.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				second.setVisible(false);
			}
		});
		second.pack();
		second.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

