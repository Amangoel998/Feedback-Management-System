export class Program{
    id:string;
    programName:string;
    active:boolean;

    constructor(programId:string,programName:string,active:boolean){
        this.id=programId;
        this.programName=programName;
        this.active=active;
    }
}