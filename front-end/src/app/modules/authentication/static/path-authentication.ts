import { environment } from "src/environments/environment";

export class PathAuthentication {
  static readonly ROOT = `${environment.endPoint}/user`;
  static readonly LOGIN = `${this.ROOT}/login`;
  static readonly REGISTER = `${this.ROOT}/register`;
  
}