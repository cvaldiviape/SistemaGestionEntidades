import { environment } from "../../../../environments/environment";

export class PathTypeDocument {
  static readonly ROOT = `${environment.endPoint}/type-document`;
  static readonly GET_ALL = `${this.ROOT}`;
  static readonly GET_BY_ID = `${this.ROOT}`;
  static readonly CREATE = `${this.ROOT}`;
  static readonly UPDATE = `${this.ROOT}`;
  static readonly DELETE = `${this.ROOT}`;
}