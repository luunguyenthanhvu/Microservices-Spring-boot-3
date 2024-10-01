package vuluu.profileservice.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vuluu.profileservice.dto.request.ProfileCreationRequestDTO;
import vuluu.profileservice.dto.response.UserProfileResponseDTO;
import vuluu.profileservice.entity.UserProfile;
import vuluu.profileservice.mapper.UserProfileMapper;
import vuluu.profileservice.repository.UserProfileRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {

  UserProfileRepository userProfileRepository;
  UserProfileMapper userProfileMapper;

  public UserProfileResponseDTO createProfile(ProfileCreationRequestDTO requestDTO) {
    UserProfile userProfile = userProfileMapper.toUserProfile(requestDTO);
    userProfile = userProfileRepository.save(userProfile);
    return userProfileMapper.toUserProfileResponseDTO(userProfile);
  }

  public UserProfileResponseDTO getUserProfile(String id) {
    UserProfile userProfile = userProfileRepository.findById(id)
        .orElseThrow(() -> new RuntimeException());
    return userProfileMapper.toUserProfileResponseDTO(userProfile);
  }
}
