import { Student } from './student';
import { Trainer } from './Trainer';
import { Program } from './Program';

export class Feedback{
    id:string;
    studentId:string;
    trainerId:string;
    programId:string;
    questions:number[];
    comments:string;
    suggestions:string;

    
    constructor(feedbackId:string,studentId:string,trainerId:string,programId:string,questions:number[],suggestions:string,comments:string){

        this.id=feedbackId;
        this.comments=comments;
        this.studentId=studentId;
        this.trainerId=trainerId;
        this.programId=programId;
        this.questions=questions;
        this.suggestions=suggestions;


    }
    
}

    
