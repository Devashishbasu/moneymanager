package Devashish.basu.moneymanager.service;

import Devashish.basu.moneymanager.dto.ProfileDTO;
import Devashish.basu.moneymanager.entity.ProfileEntity;
import Devashish.basu.moneymanager.repository.ProfileRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProfileService {

  private final ProfileRepository profileRepository;

  public ProfileDTO registerProfile(ProfileDTO profileDTO){
    ProfileEntity newProfile = toEntity(profileDTO);
    newProfile.setActivationToken(UUID.randomUUID().toString());
    newProfile = profileRepository.save(newProfile);

    return toDTO(newProfile);
  }

  public ProfileEntity toEntity(ProfileDTO profileDTO){
    return ProfileEntity.builder()
        .id(profileDTO.getId())
        .fullname(profileDTO.getFullname())
        .email(profileDTO.getEmail())
        .password(profileDTO.getPassword())
        .createdAt(profileDTO.getCreatedAt())
        .updatedAt(profileDTO.getUpdatedAt())
        .build();
  }

  public ProfileDTO toDTO(ProfileEntity profileEntity){
    return ProfileDTO.builder()
        .id(profileEntity.getId())
        .fullname(profileEntity.getFullname())
        .email(profileEntity.getEmail())
        .profileImageUrl(profileEntity.getProfileImageUrl())
        .createdAt(profileEntity.getCreatedAt())
        .updatedAt(profileEntity.getUpdatedAt())
        .build();
  }
}
