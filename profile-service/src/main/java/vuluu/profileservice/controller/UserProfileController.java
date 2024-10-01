package vuluu.profileservice.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vuluu.profileservice.dto.response.UserProfileResponseDTO;
import vuluu.profileservice.service.UserProfileService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {

  UserProfileService userProfileService;

  @GetMapping("/users/get-user-profile/{id}")
  public UserProfileResponseDTO getUserProfile(@PathVariable String id) {
    return userProfileService.getUserProfile(id);
  }

  @GetMapping("/users/get-users")
  public List<UserProfileResponseDTO> getUsers() {
    return userProfileService.getUsers();
  }

}
