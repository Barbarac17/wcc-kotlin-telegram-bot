import java.util.concurrent.atomic.AtomicInteger

class GifDao {

    private val gifDao = hashMapOf(
        0 to Gif(link = "https://media.giphy.com/media/11c7UUfN4eoHF6/giphy.gif", id = 0),
        1 to Gif(link = "https://media.giphy.com/media/DdGugw1M5eUsU/giphy.gif", id = 1),
        2 to Gif(link = "https://media.giphy.com/media/xT77XZrTKOxycjaYvK/giphy.gif", id = 2),
        3 to Gif(link ="https://media.giphy.com/media/FvucYGiyX7bcQ/giphy.gif", id = 3),
        4 to Gif(link ="https://media.giphy.com/media/b3Gp6a25caNZC/giphy.gif", id = 4),
        5 to Gif(link = "https://media.giphy.com/media/4hzuhBhNB0h7q/giphy.gif", id = 5),
        6 to Gif(link = "https://media.giphy.com/media/cfuL5gqFDreXxkWQ4o/giphy.gif", id = 6),
        7 to Gif(link = "https://media.giphy.com/media/l2JJDdD7cv4xdGGis/giphy.gif", id = 7)
        //8 to Gif(link = "" id = 8)

    )

    var lastId: AtomicInteger = AtomicInteger(gifDao.size - 1)

    fun getGif(): Gif? {
        val copy = gifDao
        val random = (1..gifDao.size).random()
        return copy[random-1]
    }
}