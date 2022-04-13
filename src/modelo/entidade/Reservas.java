package modelo.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.ExcecaoDominio;

public class Reservas {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas() {
	}

	public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut){
		if (!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("check-out precisa ser ter a data posterior ao check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut){
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new ExcecaoDominio("as datas precisam ser futuras a hoje");
		}
		if (!checkOut.after(checkIn)) {
			throw new ExcecaoDominio("check-out precisa ser ter a data posterior ao check-in");
		}	
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto "
			+ numeroQuarto
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duracao()
			+ " noite(s).";
	}
}
