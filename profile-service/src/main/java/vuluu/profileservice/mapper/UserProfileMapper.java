package vuluu.profileservice.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import vuluu.profileservice.dto.request.ProfileCreationRequestDTO;
import vuluu.profileservice.dto.response.UserProfileResponseDTO;
import vuluu.profileservice.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
  UserProfile toUserProfile(ProfileCreationRequestDTO requestDTO);
  UserProfileResponseDTO toUserProfileResponseDTO(UserProfile entity);

  List<UserProfileResponseDTO> toListUserProfileResponseDTO(List<UserProfile> list);
}
