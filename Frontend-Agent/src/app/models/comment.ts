export class Comment {

	public id: number;
	public normalUser: number;
	public agent: number;
	public admin: number;
	public comment: string;
	public vehicleId: number;
	
	constructor($id: number, $normalUser: number, $agent: number, $admin: number, $comment: string, $vehicleId: number) {
		this.id = $id;
		this.normalUser = $normalUser;
		this.agent = $agent;
		this.admin = $admin;
		this.comment = $comment;
		this.vehicleId = $vehicleId;
	}

}