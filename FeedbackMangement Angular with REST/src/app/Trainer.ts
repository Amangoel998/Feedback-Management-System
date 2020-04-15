export class Trainer{
    id:string;
    trainerName:string;
    trainerEmail:string;
    password:string;
    active:boolean;
    skills:string[];

    
    constructor(trainerId:string,trainerName:string,trainerEmail:string,pass:string,active:boolean,skills:string[]) {
        this.active=active;
        this.skills=skills;
        this.trainerName=trainerName;
        this.id=trainerId;
        this.trainerEmail=trainerEmail;
        this.password=pass;
        
    }
}