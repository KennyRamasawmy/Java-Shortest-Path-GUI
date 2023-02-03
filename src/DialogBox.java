import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogBox {

	private JFrame frmInputDialog;
	private JTextField Num;
	static int NumberNodes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogBox window = new DialogBox();
					window.frmInputDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DialogBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmInputDialog = new JFrame();
		frmInputDialog.setTitle("Input Dialog");
		frmInputDialog.setBounds(100, 100, 331, 155);
		frmInputDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInputDialog.getContentPane().setLayout(null);
		
		JLabel lblPrompt = new JLabel("Enter the number of nodes:");
		lblPrompt.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrompt.setBounds(20, 10, 153, 13);
		frmInputDialog.getContentPane().add(lblPrompt);
		
		Num = new JTextField();
		Num.setBounds(20, 33, 96, 29);
		frmInputDialog.getContentPane().add(Num);
		Num.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NumberNodes = Integer.parseInt(Num.getText());

				frmInputDialog.dispose();
				CoordinatesFrame coordinatesframes1 = new CoordinatesFrame();
				coordinatesframes1.setVisible(true);
				
			}
		});
		btnConfirm.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConfirm.setBounds(20, 72, 85, 29);
		frmInputDialog.getContentPane().add(btnConfirm);
	}
	
}
