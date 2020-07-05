export class Agent {

	private id: number;
	private username: string;
	private password: string;
	private firstName: string;
	private lastName: string;
	private email: string;
	private companyName: string;
	private businessRegistrationNumber: string;
	private address: string;
	private isBanned: boolean;

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

    /**
     * Getter $id
     * @return {number}
     */
	public get $id(): number {
		return this.id;
	}

    /**
     * Getter $username
     * @return {string}
     */
	public get $username(): string {
		return this.username;
	}

    /**
     * Getter $password
     * @return {string}
     */
	public get $password(): string {
		return this.password;
	}

    /**
     * Getter $firstName
     * @return {string}
     */
	public get $firstName(): string {
		return this.firstName;
	}

    /**
     * Getter $lastName
     * @return {string}
     */
	public get $lastName(): string {
		return this.lastName;
	}

    /**
     * Getter $email
     * @return {string}
     */
	public get $email(): string {
		return this.email;
	}

    /**
     * Getter $companyName
     * @return {string}
     */
	public get $companyName(): string {
		return this.companyName;
	}

    /**
     * Getter $businessRegistrationNumber
     * @return {string}
     */
	public get $businessRegistrationNumber(): string {
		return this.businessRegistrationNumber;
	}

    /**
     * Getter $address
     * @return {string}
     */
	public get $address(): string {
		return this.address;
	}

    /**
     * Getter $isBanned
     * @return {boolean}
     */
	public get $isBanned(): boolean {
		return this.isBanned;
	}

    /**
     * Setter $id
     * @param {number} value
     */
	public set $id(value: number) {
		this.id = value;
	}

    /**
     * Setter $username
     * @param {string} value
     */
	public set $username(value: string) {
		this.username = value;
	}

    /**
     * Setter $password
     * @param {string} value
     */
	public set $password(value: string) {
		this.password = value;
	}

    /**
     * Setter $firstName
     * @param {string} value
     */
	public set $firstName(value: string) {
		this.firstName = value;
	}

    /**
     * Setter $lastName
     * @param {string} value
     */
	public set $lastName(value: string) {
		this.lastName = value;
	}

    /**
     * Setter $email
     * @param {string} value
     */
	public set $email(value: string) {
		this.email = value;
	}

    /**
     * Setter $companyName
     * @param {string} value
     */
	public set $companyName(value: string) {
		this.companyName = value;
	}

    /**
     * Setter $businessRegistrationNumber
     * @param {string} value
     */
	public set $businessRegistrationNumber(value: string) {
		this.businessRegistrationNumber = value;
	}

    /**
     * Setter $address
     * @param {string} value
     */
	public set $address(value: string) {
		this.address = value;
	}

    /**
     * Setter $isBanned
     * @param {boolean} value
     */
	public set $isBanned(value: boolean) {
		this.isBanned = value;
	}

}