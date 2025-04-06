package com.rst.dockeraimodeldemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerAiModelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerAiModelDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ChatClient.Builder builder) {
        return args -> {
            ChatClient client = builder.build();
            String response = client.prompt("When was Docker crated?")
                    .call()
                    .content();
            System.out.println(response);
        };
    }
}
