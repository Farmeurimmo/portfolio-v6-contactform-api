package fr.farmeurimmo.portfoliov6contactapi.service;

import fr.farmeurimmo.portfoliov6contactapi.dto.ContactFormRequest;
import fr.farmeurimmo.portfoliov6contactapi.service.bot.TelegramBot;
import fr.qadow.backend.dto.TurnstileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactFormService {

    private static final String MISSING_VALUE = "Non renseigné";

    private static final String MESSAGE_TEMPLATE = """
            📬 Nouveau message de contact
            
            👤 Nom : %s
            📧 Email : %s
            📞 Téléphone : %s
            
            💬 Message :
            %s
            """;

    private final TelegramBot telegramBot;
    private final TurnstileService turnstileService;

    public ResponseEntity<String> handleContactFormSubmission(ContactFormRequest request) {
        TurnstileResponse turnstileResponse = turnstileService.validateToken(request.cloudflareTurnstileResponses(), null);
        if (!turnstileResponse.isSuccess()) {
            return ResponseEntity.badRequest().body("Turnstile validation failed: " + String.join(", ", turnstileResponse.getErrorCodes()));
        }

        telegramBot.sendMessage(formatMessage(request));
        return ResponseEntity.ok("Message sent successfully");
    }

    private String formatMessage(ContactFormRequest request) {
        return MESSAGE_TEMPLATE.formatted(
                valueOrDefault(request.name()),
                valueOrDefault(request.email()),
                valueOrDefault(request.phone()),
                valueOrDefault(request.message())
        );
    }

    private String valueOrDefault(String value) {
        return value == null || value.isBlank() ? MISSING_VALUE : value.strip();
    }
}