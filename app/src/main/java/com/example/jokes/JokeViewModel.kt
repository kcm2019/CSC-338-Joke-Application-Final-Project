import androidx.lifecycle.ViewModel
import com.example.jokes.Joke
import com.example.jokes.R

private const val TAG = "JokeViewModel"
class JokeViewModel: ViewModel() {
    var currentIndex = 0

    private val jokeBank = listOf(
        Joke(R.string.joke_pasta, R.string.punchline_pasta),
        Joke(R.string.joke_clock, R.string.punchline_clock),
        Joke(R.string.joke_fish, R.string.punchline_fish),
        Joke(R.string.joke_soccer, R.string.punchline_soccer),
    )

    val currentPunchline: Int
        get() = jokeBank[currentIndex].punchline
    val currentJoke: Int
        get() = jokeBank[currentIndex].textResId
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % jokeBank.size
    }
}