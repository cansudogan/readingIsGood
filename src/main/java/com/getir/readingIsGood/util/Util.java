package com.getir.readingIsGood.util;

import com.getir.readingIsGood.security.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

public class Util {
    public static Long getUserId() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return userDetails.getId();
    }
}
