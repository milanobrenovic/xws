export class ContractRequest {

	public id: number;
    public agencyId1: number;
    public agencyId2: number;
	
	
	constructor($agencyId1: number,$agencyId2: number,   $id?: number  ) {
		this.id = $id;
        this.agencyId1 = $agencyId1;
        this.agencyId2 = $agencyId2;
    }
}