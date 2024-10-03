package vuluu.notificationservice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vuluu.notificationservice.dto.request.ApiResponse;
import vuluu.notificationservice.dto.request.SendEmailRequest;
import vuluu.notificationservice.dto.response.EmailResponse;
import vuluu.notificationservice.service.EmailService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class EmailController {

  EmailService emailService;

  @PostMapping("/email/send")
  ApiResponse<EmailResponse> sendEmail(@RequestBody SendEmailRequest request) {
    return ApiResponse.<EmailResponse>builder()
        .result(emailService.sendEmail(request))
        .build();
  }

  @KafkaListener(topics = "onboard-successful")
  public void listen(String message) {
    log.info("Message get" + message);
  }
}
