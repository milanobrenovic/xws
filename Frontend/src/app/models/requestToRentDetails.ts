export class RequestToRentDetails {

	public id: number;
	public vehicleId: number;
	public normalUser: number;
	public requestStatusType: string;
	public rentDateFrom: Date;
	public rentDateTo: Date;

	constructor($id: number, $vehicleId: number, $normalUser: number, $requestStatusType: string, $rentDateFrom: Date, $rentDateTo: Date) {
		this.id = $id;
		this.vehicleId = $vehicleId;
		this.normalUser = $normalUser;
		this.requestStatusType = $requestStatusType;
		this.rentDateFrom = $rentDateFrom;
		this.rentDateTo = $rentDateTo;
	}

}