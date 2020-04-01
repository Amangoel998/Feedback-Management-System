import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Program } from './Program';

@Injectable({
  providedIn: 'root'
})
export class ProgramService {
  programDB:any[]=[];
  localProgram:Program;

  constructor(private http:HttpClient) { }

  loadPrograms()
  {
    return this.http.get<Program[]>('http://localhost:3000/programs').subscribe(resp=>{
      for(const d of(resp as any)){
        this.programDB.push({ id: d.id,
          programName:d.programName,
          active:d.active
        })
      }
     console.log(this.programDB);
     
     
    });;
  }

  addProgram(Program:Program)
  {
    return this.http.post('http://localhost:3000/programs',Program);
  }
  
  deleteProgram(programId:any)
  {
    return this.http.delete('http://localhost:3000/programs/'+programId);
  }
  updateProgram(id:any,program:Program)
  {
    return this.http.put('http://localhost:3000/programs/'+id,program);
  }
}
