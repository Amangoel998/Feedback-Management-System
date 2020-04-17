package com.cg.feedback;

import java.util.List;
import java.util.Map;

import com.cg.feedback.dao.StudentDAO;
import com.cg.feedback.dto.AdminDTO;
import com.cg.feedback.dto.BatchCourseDTO;
import com.cg.feedback.dto.CourseDTO;
import com.cg.feedback.dto.Credentials;
import com.cg.feedback.dto.FeedbackDTO;
import com.cg.feedback.dto.ProgramCourseDTO;
import com.cg.feedback.dto.ProgramDTO;
import com.cg.feedback.dto.StudentDTO;
import com.cg.feedback.dto.TrainerDTO;
import com.cg.feedback.dto.TrainerProgramDTO;
import com.cg.feedback.exceptions.CustomException;
import com.cg.feedback.service.AdminService;
import com.cg.feedback.service.StudentService;
import com.cg.feedback.service.TrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RequestMapping("/api")
public class SpringRestController {

    private AdminService admService;
    private StudentService stdService;
    private TrainerService trnService;

    @Autowired
    public SpringRestController(AdminService admService, StudentService stdService, TrainerService trnService) {
        this.admService = admService;
        this.stdService = stdService;
        this.trnService = trnService;
    }

    public static void main(String... args) {
        SpringApplication.run(SpringRestController.class, args);
    }

    //------------------ Admin Requests---------------------
    @GetMapping(value = "/admin/programFeedback", produces = "application/json")
    public ResponseEntity<List<FeedbackDTO>> getProgramFeedback(@RequestParam("programID") String programID) {
        try{
            if(programID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            List<FeedbackDTO> result = admService.viewFeedbackByProgram(programID);
            return new ResponseEntity<List<FeedbackDTO>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/trainerFeedback", produces = "application/json")
    public ResponseEntity<List<FeedbackDTO>> getTrainerFeedback(@RequestParam("trainerID") String trainerID) {
        try{
            if(trainerID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            List<FeedbackDTO> result = admService.viewFeedbackByTrainer(trainerID);
            return new ResponseEntity<List<FeedbackDTO>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/programFeedbackDefaulters", produces = "application/json")
    public ResponseEntity<List<StudentDTO>> getProgramFeedbackDefaulters(@RequestParam("programID") String programID) {
        try{
            if(programID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            List<StudentDTO> result = admService.viewFeedbackDefaultersByProgram(programID);
            return new ResponseEntity<List<StudentDTO>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/trainerFeedbackDefaulters", produces = "application/json")
    public ResponseEntity<Map<String, List<StudentDTO>>> getTrainerFeedbackDefaulters(@RequestParam("trainerID") String trainerID) {
        try{
            if(trainerID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            Map<String, List<StudentDTO>> result = admService.viewFeedbackDefaultersByTrainer(trainerID);
            return new ResponseEntity<Map<String, List<StudentDTO>>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/batches", produces = "application/json")
    public ResponseEntity<List<String>> getBatches() {
        try{
            List<String> result = admService.availableBatches();
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/courses", produces = "application/json")
    public ResponseEntity<List<String>> getCourses() {
        try{
            List<String> result = admService.getCourses();
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/programs", produces = "application/json")
    public ResponseEntity<List<String>> getPrograms() {
        try{
            List<String> result = admService.getPrograms();
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/trainers", produces = "application/json")
    public ResponseEntity<List<String>> getTrainers() {
        try{
            List<String> result = admService.getTrainers();
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/students", produces = "application/json")
    public ResponseEntity<List<String>> getStudents() {
        try{
            List<String> result = admService.getStudents();
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/programsByBatch", produces = "application/json")
    public ResponseEntity<List<String>> avaiablePrograms(@RequestParam("batchID") String batchID){
        try{
            if(batchID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            List<String> result = admService.availablePrograms(batchID);
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @GetMapping(value = "/admin/trainersByBatch", produces = "application/json")
    public ResponseEntity<List<String>> avaiableTrainers(@RequestParam("batchID") String batchID){
        try{
            if(batchID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            List<String> result = admService.getAvailableTrainers(batchID);
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    // ----------------Admin POST methods-------------------
    @PostMapping(value = "/admin/addProgram", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ProgramDTO> addProgram(@RequestBody ProgramDTO program){
        try{
            if(program==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.addTrainingProgram(program);
            return new ResponseEntity<ProgramDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @PostMapping(value = "/admin/addCourse", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CourseDTO> addCourse(@RequestBody CourseDTO course){
        try{
            if(course==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.addTrainingCourse(course);
            return new ResponseEntity<CourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @PostMapping(value = "/admin/addTrainer", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TrainerDTO> addTrainer(@RequestBody TrainerDTO trainer){
        try{
            if(trainer==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.addTrainer(trainer);
            return new ResponseEntity<TrainerDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    } @PostMapping(value = "/admin/addTrainerSkill", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TrainerDTO> addTrainerSkill(@RequestParam("trainerID") String trainerID ,@RequestBody String skill){
        try{
            if(trainerID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.addTrainerSkill(skill, trainerID);
            return new ResponseEntity<TrainerDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping(value = "/admin/addStudent", produces = "application/json", consumes = "application/json")
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO student){
        try{
            if(student==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.addStudents(student);
            return new ResponseEntity<StudentDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @PostMapping(value = "/admin/assignProgramToCourse", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ProgramCourseDTO> assignProgramToCourse(@RequestBody ProgramCourseDTO programs){
        try{
            if(programs==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.assignPrograminCourse(programs);
            return new ResponseEntity<ProgramCourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @PostMapping(value = "/admin/assignProgramToCourse", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TrainerProgramDTO> assignTrainertoProgram(@RequestBody TrainerProgramDTO trainer){
        try{
            if(trainer==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.assignTrainertoProgram(trainer);
            return new ResponseEntity<TrainerProgramDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @PostMapping(value = "/admin/assignCourseToBatch", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BatchCourseDTO> assignCourseToBatch(@RequestBody BatchCourseDTO batches){
        try{
            if(batches==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.assignCourseToBatch(batches);
            return new ResponseEntity<BatchCourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }

    //---------------Admin Delete Methods--------------------
    @DeleteMapping(value = "/admin/removeStudent", produces = "application/json")
    public ResponseEntity<BatchCourseDTO> removeStudent(@RequestParam("studentID") String studentID){
        try{
            if(studentID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.removeStudents(studentID);
            return new ResponseEntity<BatchCourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @DeleteMapping(value = "/admin/removeProgram", produces = "application/json")
    public ResponseEntity<BatchCourseDTO> removeTrainingProgram(@RequestParam("programID") String programID){
        try{
            if(programID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.removeTrainingProgram(programID);
            return new ResponseEntity<BatchCourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @DeleteMapping(value = "/admin/removeTrainer", produces = "application/json")
    public ResponseEntity<BatchCourseDTO> removeTrainer(@RequestParam("trainerID") String trainerID){
        try{
            if(trainerID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.removeTrainer(trainerID);
            return new ResponseEntity<BatchCourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @DeleteMapping(value = "/admin/removeCourse", produces = "application/json")
    public ResponseEntity<BatchCourseDTO> removeCourse(@RequestParam("courseID") String courseID){
        try{
            if(courseID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.removeTrainingCourse(courseID);
            return new ResponseEntity<BatchCourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    @DeleteMapping(value = "/admin/removeSkill", produces = "application/json")
    public ResponseEntity<BatchCourseDTO> removeSkill(@RequestParam("trainerID") String trainerID, @RequestParam("skillName") String skillName){
        try{
            if(trainerID==null||skillName==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            admService.removeTrainerSkill(skillName, trainerID);
            return new ResponseEntity<BatchCourseDTO>(HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }        
    }
    // ------------------Trainer Methods--------------------
    @GetMapping(value="/trainer/showFeedback", produces="application/json")
    public ResponseEntity<List<FeedbackDTO>> showFeedback(@RequestParam("trainerID") String trainerID){
        try{
            if(trainerID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            List<FeedbackDTO> result = trnService.showFeedBack(trainerID);
            return new ResponseEntity<List<FeedbackDTO>>(result,HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping(value="/trainer/showDefaulters", produces="application/json")
    public ResponseEntity<Map<String,List<StudentDTO>>> showDefaulters(@RequestParam("trainerID") String trainerID){
        try{
            if(trainerID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            Map<String,List<StudentDTO>> result = trnService.showDefaulters(trainerID);
            return new ResponseEntity<Map<String,List<StudentDTO>>>(result,HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // ------------------Student Methods--------------------
    @PostMapping(value="/trainer/giveFeedback", produces="application/json", consumes = "application/json")
    public ResponseEntity<FeedbackDTO> giveFeedback(@RequestParam("studentID") String studentID, @RequestBody FeedbackDTO feedback){
        try{
            if(studentID==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            FeedbackDTO result = stdService.giveFeedback(feedback);
            return new ResponseEntity<FeedbackDTO>(result, HttpStatus.OK);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //----------------User Logins---------------------------
    @PostMapping(value="/admin/login", produces="application/json", consumes = "application/json")
    public ResponseEntity<AdminDTO> loginAdmin(@RequestBody Credentials credentials){
        try{
            if(credentials==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                AdminDTO result = admService.login(credentials.getLoginId(),credentials.getLoginPassword());
            if(result!=null)
                return new ResponseEntity<AdminDTO>(result, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping(value="/trainer/login", produces="application/json", consumes = "application/json")
    public ResponseEntity<TrainerDTO> loginTrainer(@RequestBody Credentials credentials){
        try{
            if(credentials==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            TrainerDTO result = trnService.login(credentials.getLoginId(),credentials.getLoginPassword());
            if(result!=null)
                return new ResponseEntity<TrainerDTO>(result, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PostMapping(value="/student/login", produces="application/json", consumes = "application/json")
    public ResponseEntity<StudentDTO> loginStudent(@RequestBody Credentials credentials){
        try{
            if(credentials==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            StudentDTO result = stdService.login(credentials.getLoginId(),credentials.getLoginPassword());
            if(result!=null)
                return new ResponseEntity<StudentDTO>(result, HttpStatus.OK);
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(CustomException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}