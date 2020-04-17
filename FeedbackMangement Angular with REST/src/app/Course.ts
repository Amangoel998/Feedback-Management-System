export class Course{
    id:string;
 courseName:string;
 active:boolean;
 
 constructor(courseId:string,courseName:string,active:boolean)
 {
     this.id=courseId;
     this.active=active;
     this.courseName=courseName;
 }
}