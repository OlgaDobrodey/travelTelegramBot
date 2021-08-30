package com.experiment.travel.bot;

import com.experiment.travel.model.City;
import com.experiment.travel.service.CityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@PropertySource("classpath:telegram.properties")
public class ChatBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    private final CityService cityService;

    public ChatBot(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText())
            return;

        final String text = update.getMessage().getText();
        final long chatId = update.getMessage().getChatId();
        String information;
        if (text == null) {
            information = "Сообщение не является текстом";
        } else {
            City city = cityService.readForName(text);
            if (city == null) {
                information=text+" Такого города нет в базе";
            } else {
                information = city.getInformation();
            }
        }
        sendMessage(chatId, information);
    }

    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage()
                .setChatId(chatId)
                .setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
