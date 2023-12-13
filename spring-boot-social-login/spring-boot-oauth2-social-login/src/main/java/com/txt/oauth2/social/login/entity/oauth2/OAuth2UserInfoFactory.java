package com.txt.oauth2.social.login.entity.oauth2;

import com.txt.oauth2.social.login.entity.authen.AuthProvider;
import com.txt.oauth2.social.login.exception.OAuth2AuthenticationProcessingException;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {

        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        }
        else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        }
        else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        }
        else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
