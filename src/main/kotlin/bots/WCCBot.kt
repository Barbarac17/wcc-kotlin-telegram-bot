package bots

import GifDao
import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto
import org.telegram.telegrambots.meta.api.methods.send.SendVideo


import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.media.InputMedia
import org.telegram.telegrambots.meta.api.objects.media.InputMediaVideo
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.io.File






class WCCBot : TelegramLongPollingBot() {



    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return " :heart_eyes_cat: FloraCatbot :sunflower:"
    }

    override fun getBotToken(): String {
        // Return bot token from BotFather
        return "2130071656:AAFKkYLbMYG5SR0iZq4U8r7uMYkt4mO5xSE"
    }

    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val nameSender = update?.message?.from?.firstName
        val chatId = update?.message?.chatId.toString()
        val messageCommand = update?.message?.text


        val welcome = """ Olááá $nameSender lindeza\! 
        | Esse bot é para te animar
        | \/start \- informa os comandos
        | \/vogue \- para você dançar gata
        | \/todepre \- para animar vc
           """.trimMargin()

        try {
            if(messageCommand=="/start") {
                val sendDocument = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = welcome
                    //this.caption = EmojiParser.parseToUnicode("Oláaa $nameSender :smile:")
                    this.document = InputFile().setMedia("https://media.giphy.com/media/SKGo6OYe24EBG/giphy.gif")
                    this.parseMode = "MarkdownV2"
                }

                execute(sendDocument)
            }
            else if (messageCommand=="/vogue"){
                val sendVideo = SendVideo().apply {
                    this.chatId = chatId
                    this.caption = EmojiParser.parseToUnicode("Vem dançar $nameSender :smiley_cat:")
                    this.video = InputFile().setMedia(File("C:\\Users\\user\\Desktop\\bot_telegram_kotlin\\wcc-kotlin-telegram-bot\\src\\main\\resources\\owlkitty-in-vogue-madonna.mp4"))
                    this.parseMode = "MarkdownV2"
                }

                execute(sendVideo)

            }

            else if (messageCommand=="/todepre"){

                val sendGif = SendVideo().apply {
                    val gifS = GifDao().getGif()
                    this.chatId = chatId
                    this.caption = EmojiParser.parseToUnicode("Se anima $nameSender :smiley_cat:")
                    this.video = InputFile().setMedia(gifS?.link)
                    this.parseMode = "MarkdownV2"
                }

                execute(sendGif)

            }

            else {
                val sendDocument = SendMessage().apply {
                    this.chatId = chatId
                    this.text = EmojiParser.parseToUnicode("num funfou :(")
                    this.parseMode = "MarkdownV2"
                }

                execute(sendDocument)
            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }
}

