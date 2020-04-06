interface RestInterface{
    fetchStudent():any[];
    add(Object):any[];
    delete(id:any):any[];
    update(id:any,entity:Object):any[];
}