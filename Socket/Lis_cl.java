package listener;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.reflect.*;
import affichage.*;
import outil.*;
public class Lis_cl implements ActionListener{
JTextField[] jtf_log;
Sender sen;
	public Lis_cl(JTextField[] jtf_log,Sender sen)throws Exception{
		this.jtf_log=jtf_log;
		this.sen=sen;
	}

	public void actionPerformed(ActionEvent e){
		try{
			if (e.getSource()==sen.get_jb()) {
				for (int i=0;i<jtf_log.length;i++) {
					out_vide(jtf_log[i].getText());
				}
				Thread setm=new Thread(new Runnable(){
					Client c1=new Client(jtf_log[0].getText(),jtf_log[1].getText(),Integer.valueOf(jtf_log[2].getText()));
					Socket s=new Socket(c1.get_enter(),c1.get_port());
					DataOutputStream pw=new DataOutputStream(s.getOutputStream());
					public void run(){
						try{	
							while(true){
								pw.writeUTF(c1.get_name()+": "+jtf_log[3].getText());
								pw.flush();
								break;
							}
						}
						catch(Exception e){}
					}
				});
				setm.start();
			}
		}
		catch(Exception ex){
			sen.set_error(ex.getMessage());
			System.out.println(ex.getMessage());
		}
	}

	public void out_vide(String alt)throws Exception{
		if (alt.equals("")||alt.equals(" ")) {
			throw new Exception("veuillez remplir les champs");
		}
	}
}