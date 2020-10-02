export class Agency {

	public id: number;
	public agencyName: string;
	
	
	constructor($agencyName: string,   $id?: number  ) {
		this.id = $id;
		this.agencyName = $agencyName;
    }
}