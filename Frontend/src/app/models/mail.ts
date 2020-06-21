export class Mail {

	public subject: string;
	public content: string;
	public date: Date;

	constructor($subject: string, $content: string, $date: Date) {
		this.subject = $subject;
		this.content = $content;
		this.date = $date;
	}

}