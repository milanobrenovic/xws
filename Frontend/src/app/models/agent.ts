export class Agent {

	public id: number;
	public username: string;
	public password: string;
	public firstName: string;
	public lastName: string;
	public email: string;
	public companyName: string;
	public businessRegistrationNumber: string;
	public address: string;
	public isBanned: boolean;

	constructor($id: number, $username: string, $password: string, $firstName: string, $lastName: string, $email: string, $companyName: string, $businessRegistrationNumber: string, $address: string, $isBanned: boolean) {
		this.id = $id;
		this.username = $username;
		this.password = $password;
		this.firstName = $firstName;
		this.lastName = $lastName;
		this.email = $email;
		this.companyName = $companyName;
		this.businessRegistrationNumber = $businessRegistrationNumber;
		this.address = $address;
		this.isBanned = $isBanned;
	}

}