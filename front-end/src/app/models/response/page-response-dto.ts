export interface PageResponseDTO<E> { 
 numberPage: number,
 sizePage: number,
 totalPages: number,
 isLastPage: boolean,
 elements: E[],
}