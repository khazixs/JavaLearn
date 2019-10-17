package com.Dandelion.Project.InterviewSecrectary.src.interviewSecretary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UI extends JFrame{
	
	private JPanel panel;
	//private JLabel tip_label;
	private JButton button_input, button_output, button_start;
	private JLabel input_path_tip, output_path_tip, output_type_tip, time_left;
	private JTextField input_path, output_path;
	private JCheckBox plain_text, json_file;
	private JMenuBar menu_bar;
	private JMenu option, about;
	private JMenuItem account, default_path, swap_path, bug_report, about_content_1, about_content_2, about_content_3, about_content_4;
	private String default_inpath_value, default_outpath_value, default_swappath_value;
	private boolean output_type_plain, output_type_json;
	
	public UI(String frame_name){
		super(frame_name);
		setBounds(200,200,500,400);
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e){}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//
		panel = new JPanel();
		add(panel);
		
		menu_bar = new JMenuBar();
		option = new JMenu("ѡ��(O)");
		about = new JMenu("����(A)");
		
		account = new JMenuItem("�˻�����");
		default_path = new JMenuItem("Ĭ�����·��");
		swap_path = new JMenuItem("Ĭ����ת·��");
		bug_report = new JMenuItem("���ⷴ��");
		about_content_1 = new JMenuItem("����һ�Դ���");
		about_content_2 = new JMenuItem("�����ߣ�Darui");
		about_content_3 = new JMenuItem("����ƽ̨��Java 1.8");
		about_content_4 = new JMenuItem("�������棺�ƴ�Ѷ����������");
		
		option.add(account);
		option.add(default_path);
		option.add(swap_path);
		option.addSeparator();
		option.add(bug_report);
		about.add(about_content_1);
		about.addSeparator();
		about.add(about_content_2);
		about.addSeparator();
		about.add(about_content_3);
		about.addSeparator();
		about.add(about_content_4);
		
		option.setFont(new Font("Serif",Font.PLAIN,15));
		about.setFont(new Font("Serif",Font.PLAIN,15));
		
		menu_bar.add(option);
		menu_bar.add(about);
		
		account.addActionListener(new AccountHandler());
		default_path.addActionListener(new Default_pathHandler());
		swap_path.addActionListener(new Swap_pathHandler());
		bug_report.addActionListener(new Bug_reportHandler());
		setJMenuBar(menu_bar);
		
		//
		button_input = new JButton("��ѡ����Ƶ�ļ�·��");
		button_output = new JButton("��ѡ������ı�·��");
		button_start = new JButton("��ʼת��");
		
		button_input.setFont(new Font("Serif",Font.PLAIN,15));
		button_output.setFont(new Font("Serif",Font.PLAIN,15));
		button_start.setFont(new Font("Serif",Font.PLAIN,15));
		
		panel.add(button_input);
		panel.add(button_start);
		panel.add(button_output);
		
		button_input.addActionListener(new  Button_inputHandler());
		button_output.addActionListener(new Button_outputHandler());
		button_start.addActionListener(new Button_startHandler());
		
		input_path_tip = new JLabel("����·����");
		output_path_tip = new JLabel("���·����");
		input_path_tip.setFont(new Font("Serif",Font.PLAIN,12));
		output_path_tip.setFont(new Font("Serif",Font.PLAIN,12));
		
		input_path = new JTextField(45);
		output_path = new JTextField(45);
		input_path.setFont(new Font("Serif",Font.PLAIN,12));
		output_path.setFont(new Font("Serif",Font.PLAIN,12));
		try{
			Scanner configinfo = new Scanner(new File("configinfo"));
			default_outpath_value = configinfo.nextLine().replace("default_outpath:", "");
			default_swappath_value = configinfo.nextLine().replace("default_swappath:", "");
			output_path.setText(default_outpath_value);
			
			Scanner config = new Scanner(new File("config.properties"));
			String s = new String();
			for (int i=0; i<9; i++){
				s += config.nextLine()+"\n";
			}
			s += "store_path="+default_swappath_value.replace("\\", "\\\\");
			
			PrintWriter outfile = new PrintWriter("config.properties");
			outfile.print(s);
			outfile.close();
		} catch (FileNotFoundException e){System.out.println("No Files");}
		
		panel.add(input_path_tip);
		panel.add(input_path);
		panel.add(output_path_tip);
		panel.add(output_path);
		
		output_type_tip = new JLabel("��ѡ�������ʽ��");
		plain_text = new JCheckBox("���ı�");
		json_file = new JCheckBox("JSON�ļ�");
		plain_text.setFont(new Font("Serif",Font.PLAIN,12));
		json_file.setFont(new Font("Serif",Font.PLAIN,12));
		
		panel.add(output_type_tip);
		panel.add(plain_text);
		panel.add(json_file);
		
		plain_text.addItemListener(new PlainHandler());
		json_file.addItemListener(new JsonHandler());
		
		/*time_left = new JLabel("��ǰ�ʻ�ʣ�����ʱ����XX : XX : XX");
		time_left.setFont(new Font("Serif",Font.PLAIN,12));
		
		panel.add(time_left);*/
		
		setVisible(true);
	}
	
	private class PlainHandler implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if (plain_text.isSelected()) output_type_plain = true;
			else output_type_plain = false;
		}
	}
	
	private class JsonHandler implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if (json_file.isSelected()) output_type_json = true;
			else output_type_json = false;
		}
	}
	
	private class Bug_reportHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JOptionPane.showMessageDialog(UI.this, "1. �����https://www.baidu.com/�ύ��������\n2. ���߷���Email��1966559375@qq.com��������");
		}
	}
	
	private class Button_inputHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JFileChooser infile = new JFileChooser();
			infile.setFileSelectionMode(JFileChooser.FILES_ONLY);
			infile.showDialog(new JLabel(), "ѡ�������ļ�");
			File file = infile.getSelectedFile();
			default_inpath_value = new String(file.getAbsolutePath());
			input_path.setText(default_inpath_value);
		}
	}
	
	private class Button_outputHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JFileChooser infile = new JFileChooser();
			infile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			infile.showDialog(new JLabel(), "ѡ������ļ���");
			File file = infile.getSelectedFile();
			output_path.setText(file.getAbsolutePath());
		}
	}
	
	private class AccountHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			String app_id=JOptionPane.showInputDialog("������APP ID:");
			String secret_key=JOptionPane.showInputDialog("������secret key:");
			try {
				Scanner infile = new Scanner(new File("config.properties"));
				String s = new String();
				for (int i=0; i<10; i++){
					if (i!=1 && i!=3) s+=infile.nextLine()+"\n";
					else if(i==1) {
						s+="app_id="+app_id+"\n";
						infile.nextLine();
					}
					else {
						s+="secret_key="+secret_key+"\n";
						infile.nextLine();
					}
				}
				infile.close();
				
				PrintWriter outfile = new PrintWriter("config.properties");
				outfile.print(s);
				outfile.close();
			} catch (FileNotFoundException e){}
		}
	}
	
	private class Default_pathHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JFileChooser outpath = new JFileChooser();
			outpath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			outpath.showDialog(new JLabel(), "ѡ��Ĭ������ļ���");
			File file = outpath.getSelectedFile();
			default_outpath_value = file.getAbsolutePath();
			output_path.setText(default_outpath_value);
			
			try{
				Scanner configinfo = new Scanner(new File("configinfo"));
				String s = new String();
				configinfo.nextLine();
				s += "default_outpath:"+default_outpath_value+"\n";
				s += configinfo.nextLine()+"\n";
				configinfo.close();
				
				PrintWriter outfile = new PrintWriter("configinfo");
				outfile.print(s);
				outfile.close();
			} catch (FileNotFoundException e){}
		}
	}
	
	private class Swap_pathHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JFileChooser swappath = new JFileChooser();
			swappath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			swappath.showDialog(new JLabel(), "ѡ����ת�ļ���");
			File file = swappath.getSelectedFile();
			default_swappath_value = file.getAbsolutePath();
			
			try{
				Scanner configinfo = new Scanner(new File("configinfo"));
				String s = new String();
				s += configinfo.nextLine()+"\n";
				configinfo.nextLine();
				s += "default_swappath:"+default_swappath_value+"\n";
				configinfo.close();
				
				PrintWriter outfile = new PrintWriter("configinfo");
				outfile.print(s);
				outfile.close();
			} catch (FileNotFoundException e){}
		}
	}
	
	private class Button_startHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			//JOptionPane.showMessageDialog(UI.this, "���ڿ�ʼתд");
			S2Ttest s2t = new S2Ttest(default_inpath_value);
			String result = s2t.start();
			String input_file = default_inpath_value.replace("\\", "\\\\");
			String output_file_name = default_outpath_value.replace("\\", "\\\\") +"\\"+input_file.split("\\\\")[input_file.split("\\\\").length-1]+"_text.txt";
			
			//System.out.println(result);
			if (result.startsWith("failed")){
				JOptionPane.showMessageDialog(UI.this, "����ʧ�ܣ�ʧ����Ϣ��"+result);
			}
			else {
				if (output_type_plain){
					try {
						PrintWriter outfile = new PrintWriter(output_file_name);
						String[] s_array = result.split("\"");
						for (int i=0; i<s_array.length-2; i++){
							if (s_array[i].equals("onebest")){
								try{
									outfile.write(s_array[i+2]);
								} catch (Exception e){
									continue;
								}
							}
						}
						outfile.close();
					} catch (FileNotFoundException e){}
				}
				
				if (output_type_json){
					try {
						PrintWriter outfile = new PrintWriter(output_file_name.replace(".txt", ".json"));
						outfile.print(result);
						outfile.close();
					} catch (FileNotFoundException e){}
				}
				JOptionPane.showMessageDialog(UI.this, "��תд���������");
			}
		}
	}
}


