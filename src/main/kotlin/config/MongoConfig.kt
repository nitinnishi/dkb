package org.dkbfactory.config

//import com.mongodb.Mongo
//import com.mongodb.client.MongoClient
//import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder
//import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
//import org.springframework.data.mongodb.core.MongoTemplate
import java.io.IOException


@Configuration
//@PropertySource("classpath:application.yaml")
//@ConfigurationProperties(prefix = "mongo-db")
class MongoConfig {

    lateinit var host: String
    lateinit var dbname: String


//    @Bean(destroyMethod = "close")
//    @Throws(IOException::class)
//    fun mongo(): Mongo? {
//        return EmbeddedMongoBuilder()
//            .version("2.4.5")
//            .bindIp("127.0.0.1")
//            .port(12345)
//            .build()
//    }

//    @Bean
//    @Throws(IOException::class)
//    fun mongoTemplate(): MongoTemplate? {
//        val mongo = EmbeddedMongoFactoryBean()
//        mongo.setBindIp(host)
//        val mongoClient: MongoClient = mongo.`object` as MongoClient
//        return MongoTemplate(mongoClient, dbname)
//    }
}