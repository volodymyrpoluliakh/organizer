package kpi.ipt.organizer.auth;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public abstract class AuthUtils {
    private AuthUtils() {
    }

    public static long currentUserId() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (!(requestAttributes instanceof ServletRequestAttributes)) {
            throw new AuthenticationException();
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();

        String userId = request.getHeader("Principal");
        if (userId == null) {
            throw new AuthenticationException("Principal information not found in the request");
        }

        return Long.parseLong(userId);
    }
}
