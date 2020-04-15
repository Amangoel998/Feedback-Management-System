export class Student{
    id:string;
    studentName:string;
    studentEmail:number;
    password:string;
    active:boolean;
    batch:string;
    constructor(studentId,studentName,studentEmail,password,batch,active)
    {
       this.active=active;
       this.batch=batch;
       this.id=studentId;
       this.studentEmail=studentEmail;
       this.studentName=studentName;
       this.password=password;
    }
}