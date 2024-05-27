package com.mcp.crispy.employee.controller;

import com.mcp.crispy.email.service.AuthenticationService;
import com.mcp.crispy.employee.dto.*;
import com.mcp.crispy.employee.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeApiController {

    private final EmployeeService employeeService;
    private final AuthenticationService authenticationService;

    /**
     * 아이디 찾기, 비밀번호 찾기 메소드
     * @param findEmployeeDto
     * @return
     */
    @PostMapping("/verify/email/v1")
    public ResponseEntity<Map<String, String>> verifyEmployee(@RequestBody FindEmployeeDto findEmployeeDto) {
        boolean employeeExists = employeeService.checkEmployeeExists(findEmployeeDto.getEmpName(), findEmployeeDto.getEmpEmail(), findEmployeeDto.getEmpId());
        if(!employeeExists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "일치하는 회원 정보가 없습니다."));
        }
        authenticationService.sendAndSaveVerificationCode(findEmployeeDto.getEmpEmail());
        return ResponseEntity.ok().body(Map.of("message", "인증 코드가 발송되었습니다."));
    }

//    @IsOwner
    @GetMapping("/{empNo}/v1")
    public ResponseEntity<EmployeeDto> getEmployeeDetails(@PathVariable Integer empNo) {
        EmployeeDto employee = employeeService.getEmployeeDetailsByEmpNo(empNo);
        if (employee != null) {
            log.info("employee: {} {} {}", employee.getEmpZip(), employee.getEmpStreet(), employee.getEmpDetail());
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/password/reset/v1")
    public ResponseEntity<Map<String, String>> getEmployeeResetPassword(@RequestBody EmployeeRequestDto employeeRequestDto) {
        employeeService.resetEmployeePassword(employeeRequestDto.getEmpEmail(), employeeRequestDto.getEmpName());
        return ResponseEntity.ok(Map.of("message", "임시 비밀번호가 전송되었습니다."));
    }

    @PutMapping("/empPw/v1")
    public ResponseEntity<Map<String, String>> changeEmployeePassword(@RequestBody PasswordChangeDto passwordChangeDto, HttpSession session) {
        employeeService.updateEmployeePassword(passwordChangeDto.getEmpId(), passwordChangeDto);
        session.invalidate();
        return ResponseEntity.ok(Map.of("message", "비밀번호가 성공적으로 업데이트 되었습니다. 다시 로그인 해주세요."));
    }

    @PostMapping("/address/v1")
    public ResponseEntity<Map<String, String>> insertOrUpdateAddress(@RequestBody EmpAddressDto empAddressDto) {
        employeeService.insertOrUpdateAddress(empAddressDto);
        return ResponseEntity.ok(Map.of("message", "주소가 성공적으로 추가/업데이트 되었습니다."));
    }

    @PostMapping("/empSign/v1")
    public ResponseEntity<Map<String, String>> insertOrUpdateEmpSign(@RequestBody EmployeeSignDto employeeSignDto) {
        employeeService.insertOrUpdateEmpSign(employeeSignDto);
        return ResponseEntity.ok(Map.of("message", "주소가 성공적으로 추가/업데이트 되었습니다."));
    }

    @PostMapping(value = "/profileImg/v1", consumes = "multipart/form-data")
    public ResponseEntity<Map<String, String>> insertOrUpdateEmpProfile(@RequestParam("empNo") Integer empNo,
                                                      @RequestPart(value = "file", required = false) MultipartFile file) {
        log.info("file: {}", file);
        try {
            employeeService.insertOrUpdateEmpProfile(empNo, file);
            return ResponseEntity.ok(Map.of("message", "주소가 성공적으로 추가/업데이트 되었습니다."));

        } catch (IOException ex) {
            return ResponseEntity.internalServerError().body(Map.of("error", "프로필 이미지 업데이트에 실패했습니다."));
        }
    }

    @PutMapping("/empPhone/v1")
    public ResponseEntity<Map<String, String>> changeEmpPhone(@RequestBody EmployeeUpdateDto employeeUpdateDto,
                                            Principal principal) {
        String username = principal.getName();
        EmployeeDto employee = employeeService.getEmployeeName(username);
        employeeService.changeEmpPhone(employeeUpdateDto.getEmpPhone(), employeeUpdateDto.getEmpNo(), employee.getEmpNo());
        return ResponseEntity.ok(Map.of("message", "휴대폰번호가 변경되었습니다."));
    }

    @PutMapping("/empName/v1")
    public ResponseEntity<Map<String, String>> changeEmpName(@RequestBody EmployeeUpdateDto employeeUpdateDto,
                                           Principal principal) {
        String username = principal.getName();
        EmployeeDto employee = employeeService.getEmployeeName(username);
        employeeService.changeEmpName(employeeUpdateDto.getEmpName(), employeeUpdateDto.getEmpNo(), employee.getEmpNo());
        return ResponseEntity.ok(Map.of("message", "이름이 변경되었습니다."));
    }

    @PutMapping("/posNo/v1")
    public ResponseEntity<Map<String, String>> changePosNo(@RequestBody EmployeeUpdateDto employeeUpdateDto,
                                           Principal principal) {
        String username = principal.getName();
        EmployeeDto employee = employeeService.getEmployeeName(username);
        log.info("PosNo: {}", employeeUpdateDto.getPosNo());
        employeeService.changePosNo(employeeUpdateDto.getPosNo().getCode(), employeeUpdateDto.getEmpNo(), employee.getEmpNo());
        return ResponseEntity.ok(Map.of("message", "직책이 변경되었습니다."));
    }

    @PutMapping("/empStat/v1")
    public ResponseEntity<Map<String, String>> changeEmpStat(@RequestBody EmployeeUpdateDto employeeUpdateDto,
                                           Principal principal) {
        EmployeeDto employee = employeeService.getEmployeeName(principal.getName());
        employeeService.changeEmpStat(employeeUpdateDto.getEmpStat().getValue(), employeeUpdateDto.getEmpNo(), employee.getEmpNo());
        log.info("empStatus: {}", employeeUpdateDto.getEmpStat());
        log.info("empStatus: {}", employeeUpdateDto.getEmpStat().getValue());
        return ResponseEntity.ok(Map.of("message", "직책이 변경되었습니다."));
    }

    @GetMapping("/employees/v1")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
