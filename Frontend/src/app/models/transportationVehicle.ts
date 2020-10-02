export class TransportationVehicle {

	public id: number;
	public brand: string;
	public model: string;
	public type : number
	
	constructor($brand: string, $model: string,$type? : number,  $id?: number  ) {
		this.id = $id;
		this.brand = $brand;
		this.model = $model;
		this.type = $type;
	}

}