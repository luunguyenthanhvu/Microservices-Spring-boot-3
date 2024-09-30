package vuluu.profileservice.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vuluu.profileservice.dto.request.ProfileCreationRequestDTO;
import vuluu.profileservice.dto.response.UserProfileResponseDTO;
import vuluu.profileservice.service.UserProfileService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {

  UserProfileService userProfileService;

  @PostMapping("/users/create-user-profile")
  UserProfileResponseDTO createUserProfile(@RequestBody ProfileCreationRequestDTO requestDTO) {
    return userProfileService.createProfile(requestDTO);
  }

  @GetMapping("/users/get-user-profile/{id}")
  public UserProfileResponseDTO getUserProfile(@PathVariable String id) {
    return userProfileService.getUserProfile(id);
  }

}
