import { Category } from "./Category";

export interface Product{
    id? : number, 
    name: string, 
    price: number,
    quantity: number, 
    image: string, 
    description: string, 
    productCategory: Category,
    categoryId? : number
}