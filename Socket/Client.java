package outil;
import java.net.*;
import java.io.*;
import affichage.*;
public class Client{
	String name;
	String enter;
	int port;
	Serveur my_serv;

	public Client(String name,String entrer,int port){
		set_name(name);
		set_enter(entrer);
		set_port(port);
	}
	public void set_my_serv(Serveur ms){
		if (ms!=null) {
			this.my_serv=ms;
		}
	}
	public void set_name(String name){
		if (name!="") {
			this.name=name;
		}
	}
	public void set_enter(String enter){
		if (enter!="") {
			this.enter=enter;
		}
	}
	public void set_port(int port){
		if (port>0) {
			this.port=port;
		}
	}
	public String get_name(){
		return this.name;
	}
	public String get_enter(){
		return this.enter;
	}
	public int get_port(){
		return this.port;
	}
	public Serveur get_my_serv(){
		return this.my_serv;
	}

	public void write_message(Socket s,String message)throws Exception{
		DataOutputStream pw=new DataOutputStream(s.getOutputStream());
		pw.writeUTF(this.get_name()+": "+message);
		pw.flush();
	}

	public static void main(String[] args){
		try{
			new Sender();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		/*Client c1=new Client("192.168.20.69",3333);
			Socket s=new Socket(c1.get_enter(),c1.get_port());
			c1.write_message(s,"Dia ahoana lty");
		*/
	}
}
