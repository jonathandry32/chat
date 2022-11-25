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
public class Lis_sv implements ActionListener{
JTextField jtf_log;
Recever rec;
	public Lis_sv(JTextField jtf_log,Recever rec)throws Exception{
		this.jtf_log=jtf_log;
		this.rec=rec;
	}

	public void actionPerformed(ActionEvent e){
		try{
			if (e.getSource()==rec.get_jb()) {
				out_vide(jtf_log.getText());
			/*
				InetAddress local=InetAddress.getLocalHost();
				ServerSocket ss=new ServerSocket(serv.get_port(),3,local);
			*/
				
				Thread getm=new Thread(new Runnable(){
					Serveur serv=new Serveur(Integer.valueOf(jtf_log.getText()));
					ServerSocket ss=new ServerSocket(serv.get_port());
					Socket s=serv.connect_client(ss);
					String mess;
					DataInputStream isr=new DataInputStream(s.getInputStream());
					public void run(){
						try{	
							mess=isr.readUTF();
							while(mess!=null){
								rec.set_error(mess);
								System.out.println(mess);
								break;
							}
							isr.close();
							s.close();
						}
						catch(Exception e){}
					}
				});
				getm.start();
			}
		}
		catch(Exception ex){
			rec.set_error(ex.getMessage());
			System.out.println(ex.getMessage());
		}
	}

	public void out_vide(String alt)throws Exception{
		if (alt.equals("")||alt.equals(" ")) {
			throw new Exception("veuillez remplir les champs");
		}
	}
}