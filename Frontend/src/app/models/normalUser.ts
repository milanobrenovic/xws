export class NormalUser {

	public id: number;
	public username: string;
	public password: string;
	public firstName: string;
	public lastName: string;
	public email: string;
	public country: string;
	public phoneNumber: string;
	public address: string;
	public city: string;
	public numberOfAds: number;
	public isBanned: boolean;

	constructor($id: number, $username: string, $password: string, $firstName: string, $lastName: string, $email: string, $country: string, $phoneNumber: string, $address: string, $city: string, $numberOfAds: number, $isBanned: boolean) {
		this.id = $id;
		this.username = $username;
		this.password = $password;
		this.firstName = $firstName;
		this.lastName = $lastName;
		this.email = $email;
		this.country = $country;
		this.phoneNumber = $phoneNumber;
		this.address = $address;
		this.city = $city;
		this.numberOfAds = $numberOfAds;
		this.isBanned = $isBanned;
	}

}