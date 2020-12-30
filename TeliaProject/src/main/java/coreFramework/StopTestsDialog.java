package coreFramework;


import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;




public class StopTestsDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private TestStopper testStopper;



	public StopTestsDialog(TestStopper testStopper) {
			super();
			this.testStopper = testStopper;
			System.out.println("creating the window..");
			// set the position of the window
			Point p = new Point(400, 400);
			setLocation(p.x, p.y);

			// Create a message
			JPanel messagePane = new JPanel();
			messagePane.add(new JLabel("If you want to end the test early and the test reoprt should be written..."));
			// get content pane, which is usually the
			// Container of all the dialog's components.
			getContentPane().add(messagePane);

			// Create a button
			JPanel buttonPane = new JPanel();
			JButton button = new JButton("Stop tests");
			buttonPane.add(button);
			// set action listener on the button
			button.addActionListener(new MyActionListener());
			getContentPane().add(buttonPane, BorderLayout.PAGE_END);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			pack();
			setVisible(true);
		}

		// override the createRootPane inherited by the JDialog, to create the rootPane.
		// create functionality to close the window when "Escape" button is pressed
		public JRootPane createRootPane() {
			JRootPane rootPane = new JRootPane();
			KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
			Action action = new AbstractAction() {
				
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e) {
					System.out.println("escaping..");
					setVisible(false);
					dispose();
				}
			};
			InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap.put(stroke, "ESCAPE");
			rootPane.getActionMap().put("ESCAPE", action);
			return rootPane;
		}

		// an action listener to be used when an action is performed
		// (e.g. button is pressed)
		class MyActionListener implements ActionListener {

			//close and dispose of the window.
			public void actionPerformed(ActionEvent e) {
				testStopper.setStopTest(Boolean.TRUE);
				System.out.println("Stopping the running tests...");
				setVisible(false);
				dispose();
			}
		}
		public static void main(String[] a) {
			StopTestsDialog dialog = new StopTestsDialog(new TestStopper());
			// set the size of the window
			dialog.setSize(300, 150);
		}
}
