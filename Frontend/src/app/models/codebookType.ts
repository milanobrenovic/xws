import { List } from 'lodash';

export class CodebookType {

	public id: number;
	public type: string;

	constructor($id: number, $type: string) {
		this.id = $id;
		this.type = $type;
	}

}