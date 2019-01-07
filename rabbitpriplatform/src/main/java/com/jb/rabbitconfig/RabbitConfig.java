package com.jb.rabbitconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//声明当前类是一个配置文件类 相当于spring.xml配置文件
public class RabbitConfig {
    @Bean//创建一个rabbitMq队列
        //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue queueMessages() {
        //参数为队列名称
        return new Queue("buyqueue");
    }

    @Bean//创建一个rabbitMq队列
        //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue queueMessage() {
        //参数为队列名称
        return new Queue("addqueue");
    }

    @Bean//创建一个rabbitMq队列
        //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue queueAddSpring() {
        //参数为队列名称
        return new Queue("addSpringqueue");
    }

    @Bean//创建一个rabbitMq队列
        //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue queueDeleteSpring() {
        //参数为队列名称
        return new Queue("deleteSpringqueue");
    }

    @Bean//创建一个rabbitMq队列
        //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue queueUpdateSpring() {
        //参数为队列名称
        return new Queue("updateSpringqueue");
    }

    @Bean//创建一个rabbitMq队列
    //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue gzxUpdateTMaterial() {
        //参数为队列名称
        return new Queue("gzxUpdateTMaterial");
    }

    @Bean//创建一个rabbitMq队列
    //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue gzxupdateService() {
        //参数为队列名称
        return new Queue("gzxupdateService");
    }

    @Bean//创建一个rabbitMq队列
    //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue updateCustommadepr() {
        //参数为队列名称
        return new Queue("gzxupdateCustommadepr");
    }

    @Bean//创建一个rabbitMq队列
    //@Bean 声明当前方法为bean实例方法 把返回值注入到spring环境中
    public Queue queueMessageszzz() {
        //参数为队列名称
        return new Queue("zzzz");
    }

    @Bean
    public Queue queueMessagesss() {
        return new Queue("myqueue");
    }

    @Bean
    public Queue downloadMessages() {
        return new Queue("myqueue");
    }

    @Bean
    public Queue deleteMessages() {
        return new Queue("deleSuppiy");
    }

    @Bean
    public Queue waiveOfferMessages() {
        return new Queue("updateWaiveOffer");
    }

    @Bean
    public Queue queueMessagesssvvv() {
        return new Queue("myqueue666");
    }

}
