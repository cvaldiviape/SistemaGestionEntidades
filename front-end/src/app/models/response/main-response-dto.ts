export interface MainResponseDTO <T> {
  data: T,
  message: string,
  success: boolean,
}