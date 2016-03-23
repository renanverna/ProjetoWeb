package classenegocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataacessobject.VendaDAO;
import transferobject.VendaTO;

public class Venda {
	
	private int id;
	private Date data;
	private int login;
	private DateFormat sourcerData = new SimpleDateFormat("dd/MM/yyyy");
	
	public Venda(){
	this.id = 0;	
	this.data = new Date();
	this.login = 5;
	}
	
	public Venda(int id, String data, int login) throws ParseException{	
		this.id = id;
		this.data = sourcerData.parse(data);
		this.login = login;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public int getLogin() {
		return login;
	}


	public void setLogin(int login) {
		this.login = login;
	}
	
	
	public void criar(){
		VendaDAO dao = new VendaDAO();
		VendaTO to = new VendaTO();
		to.setId(id);
		to.setData(data);
		to.setLogin(login);
		dao.incluir(to);
		this.id = to.getId();
	}	
	
	public void carregar(){
		VendaDAO dao = new VendaDAO();
		VendaTO to = dao.carregar(id);
		id = to.getId();
		data = to.getData();
		login = to.getLogin();
	}
	
	@Override
	public String toString() {
	return "Venda [id=" + id + ", Data=" + data + ",  Login=" + login  + "]";
	}

	
}
