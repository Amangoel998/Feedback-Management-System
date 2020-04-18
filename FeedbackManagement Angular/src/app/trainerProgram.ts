export class TrainerPrograms{
    trainerId:string;
    programId:string;
    batch:string

    constructor(trainerId:string,programId:string,batch:string)
    {
        this.trainerId=trainerId;
        this.programId=programId;
        this.batch=batch;
    }
}