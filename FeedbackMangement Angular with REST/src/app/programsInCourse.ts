export class ProgramInCourse{
    id:any
    programID:string;
    courseId:string;
    startDate:string;
    endDate: string;
    
    /**
     *
     */
    constructor(programID:string,
        courseId:string,
        startDate:string,
        endDate: string) {

            this.programID=programID;
            this.courseId=courseId;
            this.startDate=startDate;
            this.endDate=endDate;
        
        
    }
}