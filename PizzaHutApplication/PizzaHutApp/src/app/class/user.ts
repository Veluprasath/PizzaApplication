export class User {

    emailId?: string | undefined
    userName?: string | undefined
    password?: string | undefined
    address?: string | undefined
    contactNumber?: string | undefined
    pizzaList?: Pizza[] | undefined;
    constructor() { }
}
export class Pizza {
    pizzaName?: string | undefined
    pizzaSize?: string | undefined
    pizzaPrice?: number | null
    pizzaQuantity?: number | null

    constructor() { }
}

