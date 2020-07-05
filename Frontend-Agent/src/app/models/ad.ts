import { List } from 'lodash';
import { Comment } from './comment';
import { Vehicle } from './vehicle';

export class Ad {

	public vehicle: Vehicle;
	public pickupLocation: string;
	public pickupFrom: Date;
	public pickupTo: Date;
	public details: string;

	constructor($vehicle: Vehicle, $pickupLocation: string, $pickupFrom: Date, $pickupTo: Date) {
		this.vehicle = $vehicle;
		this.pickupLocation = $pickupLocation;
		this.pickupFrom = $pickupFrom;
		this.pickupTo = $pickupTo;
	}

}