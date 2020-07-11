export class Review {

	public stars: number;
	public subject: string;
	public description: string;

	constructor($stars: number, $subject: string, $description: string) {
		this.stars = $stars;
		this.subject = $subject;
		this.description = $description;
	}

}