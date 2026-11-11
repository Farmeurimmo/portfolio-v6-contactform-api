package fr.farmeurimmo.portfoliov6contactapi.dto;

public record ContactFormRequest(
        String name,
        String email,
        String phone,
        String message,
        String cloudflareTurnstileResponses
) {
}
