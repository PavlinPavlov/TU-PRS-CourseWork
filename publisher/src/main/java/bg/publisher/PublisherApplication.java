package bg.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.listener.ChannelTopic;

@SpringBootApplication
public class PublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

	@Bean
	public ChannelTopic topic() {
		return new ChannelTopic("studentMessageQueue");
	}

}
