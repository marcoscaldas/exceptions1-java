package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 
	//declara como estatio para que nao seja necessario toda Reservation precisar de um sdf
	
	
	public Reservation(){
		}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) /*throws DomainException so se tiver so Exception
	 no DomainException*/ {
		if (!checkOut.after(checkIn))
		{
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");	
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

    public long duration() {
    	long diff = checkOut.getTime() - checkIn.getTime();
    	return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
	
	public void updateDates(Date checkIn, Date checkOut) /*throws DomainException*/ {
		Date now = new Date();
		
		if (checkIn.before(now) || checkOut.before(now)) {
			//para instanciar a excecao colocar Throw   (erro nos argumentos dos metodos IllegalArgumentException )
			// IllegalArgumentException nativa do java
			throw new DomainException("Error in reservation: Reservation dates for update must be future dates ");
		}
		if (!checkOut.after(checkIn))
		{
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");	
		}
		
		this.checkIn = checkIn;    // chechIn do objeto receber o checkin do argumento
		this.checkOut = checkOut;  // checkOut do objeto receber o checkOut do argumento
		//return null;// compilador informa que pode retornar erro  entao tem que colocar nulo
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out:"
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
		
	
}
