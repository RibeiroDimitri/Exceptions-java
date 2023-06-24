package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkin;
		this.checkOut = checkout;
		
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data de Check-out nao pode ser anterior a de Check-in");
		}
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//metodo que pode lançar ume exceçao por isso o throws na assinatura
	public void atualizaDatas(Date checkIn, Date checkOut){
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As Datas precisam estar dentro do ano atual/posteriores para ser atualizada");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data de Check-out nao pode ser anterior a de Check-in");
		}
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
			 + " noites";
	}
}
