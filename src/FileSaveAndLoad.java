import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FileSaveAndLoad implements ActionListener {
	JFrame frame;
	JButton button;
	JButton button2;
	JTextArea j;
	JPanel panel;
	FileWriter fw;
	BufferedReader br;
	File f;
	JFileChooser jfc;

	public static void main(String[] args) {
		FileSaveAndLoad f = new FileSaveAndLoad();
		f.start();
	}

	void start() {
		frame = new JFrame();
		panel = new JPanel();
		button = new JButton("SAVE");
		button2 = new JButton("LOAD");
		button.addActionListener(this);
		button2.addActionListener(this);
		j = new JTextArea(100, 100);
		panel.add(button);
		panel.add(button2);
		panel.add(j);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed == button) {
			String input = JOptionPane.showInputDialog("name ur file plez");

			try {
				fw = new FileWriter("src/" + input, true);
				System.out.println(j.getText());
				fw.write(j.getText());
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			jfc = new JFileChooser();

			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = jfc.getSelectedFile().getAbsolutePath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(fileName));
					String s = "";
					String l = br.readLine();
					while (l != null) {
						s += l;
						s += "\n";
						l = br.readLine();
					}
					j.setText(s);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}
}
