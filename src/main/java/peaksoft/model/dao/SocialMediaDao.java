package peaksoft.model.dao;

import peaksoft.model.SocialMedia;

import java.util.List;

public interface SocialMediaDao {
    void saveMedia(SocialMedia socialMedia);

    SocialMedia getSocialMedia(Long id);

    List<SocialMedia> getAllMedia();

    void updateSocialMedia(Long id,SocialMedia socialMedia);

    void deleteSocialMedia(Long id);

    SocialMedia getSocialMediaByName(String name);
}
