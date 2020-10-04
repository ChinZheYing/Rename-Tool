package batchrename;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class RenameMachine extends JFrame {

	JLabel jlb0;
	JLabel jlb1;
	JLabel jlb2;
	JTextField jt0;
	JTextField jt1;
	JTextField jt2;
	JButton bt0;
	JButton bt1;
	JButton bt2;
	JButton bt3;
	GridLayout lg;
	JFileChooser fc;
	
	public RenameMachine() {
		
		this.setSize(450, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Rename Machine");
		this.setVisible(true);
		
		lg = new GridLayout(4,3);	
		this.setLayout(null);

		
		
		jlb0 = new JLabel("File");
		this.add(jlb0);
		jlb0.setBounds(30, 10, 50, 30);
		
		jt0 = new JTextField();
		this.add(jt0);
		jt0.setBounds(80, 10, 240, 30);
		
		bt0 = new JButton("Browse");
		this.add(bt0);
		bt0.setBounds(320, 10, 100, 30);
		
		
		
		jlb1 = new JLabel("Search");
		this.add(jlb1);
		jlb1.setBounds(30, 50, 50, 30);
		
		jt1 = new JTextField();
		this.add(jt1);
		jt1.setBounds(80, 50, 340, 30);
		
		
		
		jlb2 = new JLabel("Replace");
		this.add(jlb2);
		jlb2.setBounds(30, 90, 50, 30);
		
		jt2 = new JTextField();
		this.add(jt2);
		jt2.setBounds(80, 90, 340, 30);
		
		
		
		bt1 = new JButton("Start");
		this.add(bt1);
		bt1.setBounds(100, 130, 70, 30);
		
		bt2 = new JButton("Clear");
		this.add(bt2);
		bt2.setBounds(165, 130, 70, 30);
		
		bt3 = new JButton("Exit");
		this.add(bt3);
		bt3.setBounds(230, 130, 70, 30);
		
		bt0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = fc.showOpenDialog(RenameMachine.this);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					String path = fc.getSelectedFile().getAbsolutePath();
					jt0.setText(path);
				}
			}
		});
		
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File file = new File(jt0.getText());
				File[] list = file.listFiles();
				
				for(File f:list) {
					String oldname = f.getName();
					String newname = oldname.replace(jt1.getText(), jt2.getText());
					newname = jt0.getText() + File.separator + newname;
					f.renameTo(new File(newname));
				}
				JOptionPane.showMessageDialog(RenameMachine.this,"File Renamed!");
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jt0.setText("");
				jt1.setText("");
				jt2.setText("");
				
			}
		});
		
		bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
				
	}
	
	public static void main(String[] args) {
		
		RenameMachine r = new RenameMachine();
		
	}

}
