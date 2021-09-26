package as.ff.nl.a3mpapi.grpc.service;

import com.students_management.stubs.student.StudentRequest;
import com.students_management.stubs.student.StudentResponse;
import com.students_management.stubs.student.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import as.ff.nl.a3mpapi.Rest.model.Student;
import as.ff.nl.a3mpapi.grpc.dao.StudentDao;

import java.util.List;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase{

    private StudentDao studentDao = new StudentDao();

    @Override
    public void getStudentInfo(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        String studentId = request.getId();
      try {
          Student student = studentDao.findById(studentId);



         StudentResponse studentResponse = StudentResponse.newBuilder()
                  .setId(studentId)
                 .setName(student.getName())
                 .setMail(student.getMail())
                 .build();


         responseObserver.onNext(studentResponse);
         responseObserver.onCompleted();

      }catch (Exception e){

      }
    }

}
