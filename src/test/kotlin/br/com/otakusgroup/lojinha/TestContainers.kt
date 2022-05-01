import com.github.dockerjava.zerodep.shaded.org.apache.hc.client5.http.protocol.RedirectStrategy
import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.containers.GenericContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@Testcontainers
class TestContainers {

    private var underTest = RedisProperties()

    // container {
    @Container
    var redis: GenericContainer<*> = GenericContainer(DockerImageName.parse("redis:5.0.3-alpine"))
        .withExposedPorts(6379)
    // }


    // }
    @BeforeEach
    fun setUp() {
        val address: String = redis.host
        val port: Int = redis.firstMappedPort

        // Now we have an address and port for Redis, no matter where it is running
//        underTest = RedisBackedCache(address, port)
    }

    @org.junit.Test
    fun testSimplePutAndGet() {
        underTest.host = "guizao"

        assertEquals("guizao", underTest.host)
    }
}