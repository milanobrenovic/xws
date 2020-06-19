import { List } from 'lodash';
import { Comment } from './comment';

export class Ad {

	public vehicle: number;
	public pickupLocation: string;
	public pickupFrom: Date;
	public pickupTo: Date;

	constructor($vehicle: number, $pickupLocation: string, $pickupFrom: Date, $pickupTo: Date) {
		this.vehicle = $vehicle;
		this.pickupLocation = $pickupLocation;
		this.pickupFrom = $pickupFrom;
		this.pickupTo = $pickupTo;
	}

}