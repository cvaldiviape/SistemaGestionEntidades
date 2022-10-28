import { RoleResponseDTO } from './role-response-dto';

export interface UserResponseDTO {
  id: number;
  username: string;
  roles: RoleResponseDTO[];
}
