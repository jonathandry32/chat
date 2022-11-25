package outil;
import java.net.*;
import java.io.*;
import affichage.*;
public class Serveur{
	int port;

	public Serveur(int port){
		set_port(port);
	}
	public void set_port(int port){
		if (port>0) {
			this.port=port;
		}
	}
	public int get_port(){
		return this.port=port;
	}

	public Socket connect_client(ServerSocket ss)throws Exception{
		Socket client=ss.accept();
		return client;
	}

	public String get_client_message(Socket ss)throws Exception{
		DataInputStream isr=new DataInputStream(ss.getInputStream());
		String mess=isr.readUTF();
		return mess;
	}

	public static void main(String[] args) {
		try{
			new Recever();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
			/*Serveur serv=new Serveur(3333);
			ServerSocket ss=new ServerSocket(serv.get_port());
			
				InetAddress local=InetAddress.getLocalHost();
				ServerSocket ss=new ServerSocket(serv.get_port(),3,local);
			
			Socket s=serv.connect_client(ss);
			System.out.println(serv.get_client_message(s));*/
	}
}