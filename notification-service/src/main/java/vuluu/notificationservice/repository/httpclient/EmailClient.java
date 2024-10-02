package vuluu.notificationservice.repository.httpclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "email-client", url = "https://api.brevo.com")
public interface EmailClient {

}
