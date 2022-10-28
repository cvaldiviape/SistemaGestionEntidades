import { TypeContributorResponseDTO } from "./type-contributor-response-dto";
import { TypeDocumentResponseDTO } from "./type-document-response-dto";

export interface EntityResponseDTO {
  id: number;
  nroDocument: string,
  companyName: string,
  commercialName: string,
  address: string,
  phone: string,
  typeContributor: TypeContributorResponseDTO,
  typeDocument: TypeDocumentResponseDTO,
}