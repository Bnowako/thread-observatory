package blaze98.blocking

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.regex.Pattern

@RestController
class PatternController {

    @PostMapping("/check")
    fun checkTextForMatches(@RequestBody check: List<String>): List<String> {
        val regex = """abc""".toRegex()
        return check.filter {
            regex.find(it) != null
        }
    }


    private val regex = """abc""".toRegex()

    @PostMapping("/check/precompiled")
    fun checkTextForMatchesPrecompiled(@RequestBody check: List<String>): List<String> {
        return check.filter {
            regex.find(it) != null
        }
    }

    private val matcher = Pattern.compile("abc").matcher("")

    @PostMapping("/check/precompiled/java-api")
    fun checkTextForMatchesPrecompiledJavaApi(@RequestBody check: List<String>): List<String> {
        return check.filter {
            matcher.reset(it)
            matcher.find()
        }
    }
}
