package iyteyazilim.projects.digitalcard.mapper;

import iyteyazilim.projects.digitalcard.dto.CommunityDto;
import iyteyazilim.projects.digitalcard.entity.Community;

public class CommunityMapper {

    public static CommunityDto mapToCommmunityDto(Community community){
        return new CommunityDto(
            community.getEmail(),
            community.getPassword()
        );
    }

    public static Community mapToCommunity(CommunityDto communityDto){
        Community community = new Community();
        community.setEmail(communityDto.getEmail());
        community.setPassword(communityDto.getPassword());
        return community;
    }
}