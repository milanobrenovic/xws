export class RequestToRent {

	public normalUserId: number;
	public vehicleId: number;
	public rentDateFrom: Date;
	public rentDateTo: Date;

	constructor($normalUserId: number, $vehicleId: number, $rentDateFrom: Date, $rentDateTo: Date) {
		this.normalUserId = $normalUserId;
		this.vehicleId = $vehicleId;
		this.rentDateFrom = $rentDateFrom;
		this.rentDateTo = $rentDateTo;
	}

}