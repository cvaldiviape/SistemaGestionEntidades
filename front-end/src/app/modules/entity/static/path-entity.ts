import { environment } from "../../../../environments/environment";

export class PathEntity {
  static readonly ROOT = `${environment.endPoint}/entity`;
  static readonly GET_ALL = `${this.ROOT}`;
  static readonly GET_BY_ID = `${this.ROOT}`;
  static readonly CREATE = `${this.ROOT}`;
  static readonly UPDATE = `${this.ROOT}`;
  static readonly DELETE = `${this.ROOT}`;
}