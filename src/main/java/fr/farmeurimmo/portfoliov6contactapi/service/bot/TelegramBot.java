package fr.farmeurimmo.portfoliov6contactapi.service.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Service
public class TelegramBot {

    private final TelegramClient telegramClient;

    @Value("${app.telegram.bot.chat-id}")
    private String chatId;

    public TelegramBot(@Value("${app.telegram.bot.token}") String botToken) {
        this.telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Async
    public void sendMessage(String text) {
        SendMessage message = new SendMessage(chatId, text);

        try {
            telegramClient.execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
