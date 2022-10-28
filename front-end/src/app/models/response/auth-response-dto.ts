import { RoleResponseDTO } from "./role-response-dto";
import { TokenResponseDTO } from "./token-response-dto";
import { UserAuthResponseDTO } from "./user-auth-response-dto";

export interface AuthResponseDTO{ 
  user: UserAuthResponseDTO,
  role: RoleResponseDTO,
  token: TokenResponseDTO,
}