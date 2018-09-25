package ua.org.oa.evlashdv.lectures.lecture1.practice.TelegramBotVer1_0;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    String name="";
    @Override
    public void onUpdateReceived(Update update) {
        Message message=update.getMessage();
        if (message!=null && message.hasText()){
            if (message.getText().equals("/help")){
            sendMag(message,"Привет, чем тебе помочь?");
            }
            if  (message.getText().equals("/code")){
                if (!name.equals(message.getChat().getUserName())){
                sendMag(message,"Ваш промо-код: "+Code.CodeCreate(8));
                name=message.getChat().getUserName();
                }else {
                    sendMag(message,"вы уже испольховали свой промо-код");
                }
            }
            else  {
                sendMag(message,"Я тестовый робот От Паши");
            }
        }
    }

    private void sendMag(Message message, String s) {
        SendMessage sendMessage=new SendMessage();
        //sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        //sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return Config.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return Config.BOT_TOKEN;
    }
}
