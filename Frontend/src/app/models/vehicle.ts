export class Vehicle {

	public brand: string;
	public model: string;
	public fuelType: number;
	public vehicleType: number;
	public transmissionType: number;
	public price: number;
	public travelledMileage: number;
	public plannedMileageToTravel: number;
	public isMileageUnlimited: boolean;
	public hasCollisionDamageWaiver: boolean;
	public numberOfSeats: number;
	public grade: boolean;
	public available: boolean;
	public vehicleDiscount: number;
	public insurancePrice: number;

	constructor($brand: string, $model: string, $fuelType: number, $vehicleType: number, $transmissionType: number, $price: number, $travelledMileage: number, $plannedMileageToTravel: number, $isMileageUnlimited: boolean, $hasCollisionDamageWaiver: boolean, $numberOfSeats: number, $grade: boolean, $available: boolean, $vehicleDiscount: number, $insurancePrice: number) {
		this.brand = $brand;
		this.model = $model;
		this.fuelType = $fuelType;
		this.vehicleType = $vehicleType;
		this.transmissionType = $transmissionType;
		this.price = $price;
		this.travelledMileage = $travelledMileage;
		this.plannedMileageToTravel = $plannedMileageToTravel;
		this.isMileageUnlimited = $isMileageUnlimited;
		this.hasCollisionDamageWaiver = $hasCollisionDamageWaiver;
		this.numberOfSeats = $numberOfSeats;
		this.grade = $grade;
		this.available = $available;
		this.vehicleDiscount = $vehicleDiscount;
		this.insurancePrice = $insurancePrice;
	}

}