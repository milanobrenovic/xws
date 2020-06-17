export class UserTokenState {

  public id: number;
  public role: string;
  public jwtAccessToken: string;
  public expiresIn: number;
  public username: string;

	constructor($id: number, $role: string, $jwtAccessToken: string, $expiresIn: number, $username: string) {
		this.id = $id;
		this.role = $role;
		this.jwtAccessToken = $jwtAccessToken;
		this.expiresIn = $expiresIn;
		this.username = $username;
	}

}