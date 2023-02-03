import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.Random;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class CoordinatesFrame extends JFrame {

	public String shortestpath;
	public float shortestdistance;
	
	private JPanel contentPane;
	
	DialogBox Dbox = new DialogBox(); //accessing NumNodes from DialogBox
	int NumNodes = Dbox.NumberNodes;

	int NodeSize = 10;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoordinatesFrame frame = new CoordinatesFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	/**
	 * Create the frame.
	 */
	public CoordinatesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel CPanel = new JPanel();
		CPanel.setBounds(41, 59, 820, 449);
		contentPane.add(CPanel);
		
		
		
		JLabel lblNewLabel = new JLabel("The shortest path is: ");
		lblNewLabel.setBounds(41, 544, 98, 13);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("The shortest distance is: ");
		lblNewLabel_1.setBounds(38, 521, 116, 13);
		contentPane.add(lblNewLabel_1);
		
	}
	
	public void paintComponent (Graphics g) {
		
		//declare all the variables
		StoreNode[] nodes = new StoreNode[NumNodes];
		float shortestPath = 999999999;
		
		//declaration of array to store different path
		String[] differentPath = new String[NumNodes];
		
		//declaration of array for the shortest distance starting from each nodes
		float[] shortestDistance = new float[NumNodes];
		int shortestPathIndex = 0;
		
		
		g.setColor(Color.BLUE);  // set the nodes color to red
	
		//declaration of array
		int[] x_axis;         
		int[] y_axis;         
		
		//initializing the array 
		x_axis = new int [NumNodes];   
		y_axis = new int [NumNodes];
		
		//random generator
		Random random = new Random();
		
		//assigning each array a random number
		for (int i = 0; i <NumNodes; i++) {
			
			x_axis[i] = random.nextInt(860);
			y_axis[i] = random.nextInt(573);
			nodes[i] = new StoreNode(x_axis[i],y_axis[i],i+1,false);
			System.out.println("Node " + nodes[i].getnodeIndex() + "is X: " + x_axis[i] + " Y: " + y_axis[i]);
			
			//System.out.println("Node"+nodes[i].getnodeIndex()+" X:"+nodes[i].getx() +"," + " Y:"+nodes[i].gety());
		}
		
		//checking for repetition in array
		int count = NumNodes - 1;
		
		for(int j = 0; j < NumNodes; j++) {
			
			while (count != -1) {
			
				if ((x_axis[j] == x_axis[count]) && (y_axis[j] == y_axis[count])){
					
					//x_axis[j] = random.nextInt(860);
					//y_axis[j] = random.nextInt(573);
					//overwrite x and y with new values
					nodes[j].setx(random.nextInt(860));
					nodes[j].sety(random.nextInt(573));
				}
				
				count--;
			
			}
			
			//draw the coordinates using [x,y] and thickness with nodesize
			//g.fillOval(x_axis[j], y_axis[j], NodeSize, NodeSize);
		}
		
		//draw a line in between each nodes
		for (int x = 0; x < NumNodes; x++) {
			for (int y = 0; y < NumNodes; y++) {
				//random colors
		        //int red = random.nextInt(256);
		      //  int green = random.nextInt(256);
		       // int blue = random.nextInt(256);
		       // g.setColor(new Color(red, green, blue));
		        //draw the lines

				g.drawLine(x_axis[x], y_axis[x], x_axis[y], y_axis[y]);
			}
		}
		
		
		//float[] distancearr;
		//distancearr = new float [NumNodes]; //array containing 
		//int counter = 0;
		//for (int x = 0; x < NumNodes; x++) {
		//for (int y = 0; y < NumNodes; y++) {
														//x2    	//x1		 //x2   		//x1			//y2		//y1		//y2		//y1
		//		float distance =(float) Math.sqrt( ((x_axis[x] - x_axis[y]) * (x_axis[x] - x_axis[y]))  + ((y_axis[x] - y_axis[y]) * (y_axis[x] - y_axis[y])) );
		//		distancearr[counter]=distance;
		//		counter++;
		//		System.out.println("Distance " + counter + "is " + distance);	
		//}
		
		for (int i =0; i < NumNodes; i++) {
			
			//make the first node passed
			nodes[i].setpassed(true);
			
			//add first visited node to description
			differentPath[i] = Integer.toString(i+1);
			
			//call to method to find shortest distance from starting node to other node
			shortestDistance[i] = Distance.findDistance(nodes ,NumNodes ,i , differentPath, i);
			
			//making all nodes unvisited to be able to search again 
			for(int j = 0; j < NumNodes; j++) {
				nodes[j].setpassed(false);
			}
		}
		
		//shortest distance with all nodes
		for(int i = 0; i < NumNodes; i++) {
			
			//output all shortest distance path from each path
			System.out.println("Shortest path starting from  the Node " + (i+1) + " is: (" + differentPath[i] + " ) and the distance is :" + (shortestDistance[i])); 
			
			if (shortestDistance[i] < shortestPath) {
				shortestPath = shortestDistance[i];
				shortestPathIndex = i;
			}
		}
		
		//output final path
		System.out.println("");
		System.out.println("Shortest path passing through all nodes is : (" + differentPath[shortestPathIndex]+ ") and the distance is: " + shortestPath);
		
		shortestpath=differentPath[shortestPathIndex];
		shortestdistance=shortestPath;
	
	}
	}
	
