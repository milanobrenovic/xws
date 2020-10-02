export class ReservationDate {

	public rentDateFrom: Date;
	public rentDateTo: Date;

	constructor($rentDateFrom: Date, $rentDateTo: Date) {
		this.rentDateFrom = $rentDateFrom;
		this.rentDateTo = $rentDateTo;
	}

}