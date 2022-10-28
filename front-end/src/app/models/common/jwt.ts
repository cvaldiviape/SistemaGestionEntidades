export interface Jwt {
	exp: number;
	role: string[];
	username: string;
}