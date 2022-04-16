package br.com.otakusgroup.lojinha.dataprovider.persistence

import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JdbcConfig {

    @Bean
    fun criaconexao(): HikariDataSource{
        val dataSource = HikariDataSource()
        dataSource.driverClassName = "org.postgresql.Driver"
        dataSource.jdbcUrl = "jdbc:postgresql://localhost:5432/lojinha_db"
        dataSource.username = "mangaka"
        dataSource.password = "onepiece"
        print("executou")
        return dataSource
    }
}