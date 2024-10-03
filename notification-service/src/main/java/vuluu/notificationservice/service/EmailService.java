package vuluu.notificationservice.service;

import com.devteria.identity.exception.AppException;
import com.devteria.identity.exception.ErrorCode;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vuluu.notificationservice.dto.request.EmailRequest;
import vuluu.notificationservice.dto.request.SendEmailRequest;
import vuluu.notificationservice.dto.request.SendTo;
import vuluu.notificationservice.dto.response.EmailResponse;
import vuluu.notificationservice.repository.httpclient.EmailClient;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {

  EmailClient emailClient;
  String apiKey = "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";

  public EmailResponse sendEmail(SendEmailRequest request) {
    EmailRequest emailRequest =
        EmailRequest.builder()
            .sender(
                SendTo.builder().name("Vuluu").email("luunguuenthanhvu123@gmail.com")
                    .build())
            .to(List.of(request.getTo()))
            .subject(request.getSubject())
            .htmlContent(request.getHtmlContent())
            .build();
    try {
      return emailClient.sendEmail(apiKey, emailRequest);
    } catch (Exception e) {
      throw new AppException(ErrorCode.valueOf("loi gui mail"));
    }
  }
}
