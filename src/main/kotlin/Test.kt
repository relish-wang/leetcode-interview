import java.lang.ref.WeakReference
import java.util.concurrent.ThreadPoolExecutor
import kotlin.concurrent.thread

fun main() {
    var s: String? = "123"
    val w = WeakReference(s)
    println("1: " + w)
    println("2: " + w.get())
    Runtime.getRuntime().gc()
    thread {
        Thread.sleep(10_000)
        println("3: " + w)
        println("4: " + w.get())
    }
}